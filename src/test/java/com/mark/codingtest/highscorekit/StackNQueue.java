package com.mark.codingtest.highscorekit;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class StackNQueue {

    /**
     * 배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 이때,
     * 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다.
     * 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 예를 들면,
     * arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
     * arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
     * 배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
     *
     * [1,1,3,3,0,1,1]	[1,3,0,1]
     * [4,4,4,3,3]	[4,3]
     */
    @Test
    public void 같은_숫자는_싫어() {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        int[] answer;

        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            if (stack.isEmpty() || stack.peek() != num) {
                stack.push(num);
            }
        }

        int index = stack.size();
        answer = new int[index];

        while (!stack.isEmpty()) {
            answer[--index] = stack.pop();
        }

        assertThat(answer).containsExactly(1, 3, 0, 1);
    }

    /**
     * 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
     * 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
     * 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
     * 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때
     * 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
     *
     * [93, 30, 55]	[1, 30, 5]	[2, 1]
     * [95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
     */
    @Test
    public void 기능개발() {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        Queue<Integer> queue = new ArrayDeque<>();

        // 각 기능이 배포되는데 필요한 일수 계산
        for (int i = 0; i < progresses.length; i++) {
            int days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            queue.offer(days);
        }

        // 각 날짜에 배포되는 기능의 개수 계산
        ArrayList<Integer> answerList = new ArrayList<>();
        int count = 1;
        int currentDay = queue.poll();

        while (!queue.isEmpty()) {
            int nextDay = queue.poll();

            // 현재 기능이 다음 기능보다 더 오래 걸리면 배포 가능
            if (currentDay >= nextDay) {
                count++;
            } else {
                // 다음 기능이 더 오래 걸리면 현재까지의 배포된 기능 개수 추가
                answerList.add(count);
                count = 1;
                currentDay = nextDay;
            }
        }

        // 마지막에 남은 기능의 개수 추가
        answerList.add(count);

        // ArrayList를 배열로 변환
        int[] answer = answerList.stream().mapToInt(Integer::intValue).toArray();

        assertThat(answer).containsExactly(1, 3, 2);
    }

    /**
     * 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어
     * "()()" 또는 "(())()" 는 올바른 괄호입니다.
     * ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
     * '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
     *
     * "()()"	true
     * "(())()"	true
     * ")()("	false
     * "(()("	false
     */
    @Test
    public void 올바른_괄호() {
        String s = "(())()";
        boolean answer = false;
        LinkedList<Character> stack = new LinkedList<>();

        for (char bracket : s.toCharArray()) {
            if (bracket == '(') {
                stack.push(bracket);
            } else if (!stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                // 올바르지 않은 괄호
                answer = false;
                break;
            }
        }

        // 스택이 비어있으면 올바른 괄호
        answer = stack.isEmpty();

        assertThat(answer).isTrue();
    }

    /**
     * 이 문제에서는 운영체제가 다음 규칙에 따라 프로세스를 관리할 경우 특정 프로세스가 몇 번째로 실행되는지 알아내면 됩니다.
     * 1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
     * 2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
     * 3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
     *   3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.
     * 예를 들어 프로세스 4개 [A, B, C, D]가 순서대로 실행 대기 큐에 들어있고, 우선순위가 [2, 1, 3, 2]라면 [C, D, A, B] 순으로 실행하게 됩니다.
     * 현재 실행 대기 큐(Queue)에 있는 프로세스의 중요도가 순서대로 담긴 배열 priorities와,
     * 몇 번째로 실행되는지 알고싶은 프로세스의 위치를 알려주는 location이 매개변수로 주어질 때,
     * 해당 프로세스가 몇 번째로 실행되는지 return 하도록 solution 함수를 작성해주세요.
     */
    @Test
    public void 운영체제() {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        int answer = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        for (int priority : priorities) {
            queue.offer(priority);
        }

        // 대기 큐의 최대 우선순위 값 찾기
        int maxPriority = Collections.max(queue);

        while (!queue.isEmpty()) {
            int front = queue.poll();

            // 현재 꺼낸 프로세스의 우선순위가 최대값이면 실행하고 answer 증가
            if (front == maxPriority) {
                answer++;
                if (location == 0) {
                    break; // 목표로 하는 프로세스가 실행되었으므로 종료
                }
                location--;
                maxPriority = Collections.max(queue); // 새로운 최대 우선순위 찾기
            } else {
                queue.offer(front); // 현재 꺼낸 프로세스의 우선순위가 최대값이 아니면 다시 큐에 넣기
                if (location == 0) {
                    location = queue.size() - 1; // 목표 프로세스 위치 업데이트
                } else {
                    location--; // 목표 프로세스 위치 업데이트
                }
            }
        }

        assertThat(answer).isEqualTo(5);
    }

    /**
     * 트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
     * 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있습니다.
     * 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.
     * 예를 들어, 트럭 2대가 올라갈 수 있고 무게를 10kg까지 견디는 다리가 있습니다.
     * 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.
     * 경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
     * 0	    []	            []	            [7,4,5,6]
     * 1~2	    []	            [7]	            [4,5,6]
     * 3	    [7]	            [4]	            [5,6]
     * 4	    [7]	            [4,5]	        [6]
     * 5	    [7,4]	        [5]	            [6]
     * 6~7	    [7,4,5]	        [6]	            []
     * 8	    [7,4,5,6]	    []	            []
     * 따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.
     *
     * solution 함수의 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭 별 무게 truck_weights가 주어집니다.
     * 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.
     */
    @Test
    public void 다리를_지나는_트럭() {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        int answer = 0;

        // 다리를 건너는 트럭을 나타내는 큐
        Queue<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++){
            bridge.offer(0);
        }

        int index = 0;
        // 다리에 있는 현재 트럭의 무게이다.
        int currentWeight = 0;

        while (index < truck_weights.length) {
            // 현재 다리에 있는 트럭무게에서 곧 나갈 트럭의 무게를 빼준다.
            currentWeight -= bridge.poll();
            // 새 트럭이 들어올 것이므로 1초를 추가한다.
            answer++;
            // 현재 다리에 있는 트럭 무게와 곧 들어올 트럭 무게의 합과 다리의 하중을 비교
            if (currentWeight + truck_weights[index] <= weight) {
                // 무게를 버틴다면 다리에 트럭을 추가한다.
                bridge.offer(truck_weights[index]);
                // 현재 다리에 있는 트럭 무게에도 새 트럭 무게를 더해준다.
                // 그리고 다음 트럭을 지정하기 위해 후위 연산자를 써주어 index를 증가시켰다.
                currentWeight += truck_weights[index++];
            } else{
                // 버티지 못한다면 0을 추가한다.
                bridge.offer(0);
            }
        }

        //처음 설정한 0으로 채워진 다리가 전부 치환되면 결국 처음 다리 길이와 같으므로
        //트럭이 지나간 시간 + 다리 길이
        answer += bridge_length;

        assertThat(answer).isEqualTo(8);
    }

    /**
     * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
     * prices	        return
     * [1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
     * 1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
     * 2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
     * 3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
     * 4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
     * 5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.
     */
    @Test
    public void 주식가격() {
        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = prices.length - index - 1;
        }

        assertThat(answer).containsExactly(4, 3, 1, 1, 0);
    }
}
