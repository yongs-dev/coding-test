package com.mark.codingtest.highscorekit;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Heap {

    /**
     * 매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다. 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해
     * Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
     * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
     * Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
     * Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때,
     * 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
     * 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
     * scoville	            K	return
     * [1, 2, 3, 9, 10, 12]	7	2
     */
    @Test
    public void 더_맵게() {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        int answer = 0;
        Integer one, two;

        // 큐 생성
        Queue<Integer> heap = new PriorityQueue<>();

        for (int j : scoville) {
            heap.add(j);
        }

        while (heap.peek() < K) {
            // int형 우선순위가 낮은 숫자 순
            if (heap.size() < 2) {
                answer = -1;
                break;
            } else {
                one = heap.poll();
                two = heap.poll();

                one += (two * 2);
                heap.offer(one);
                answer++;
            }
        }

        assertThat(answer).isEqualTo(2);
    }

    /**
     * 하드디스크는 한 번에 하나의 작업만 수행할 수 있습니다. 디스크 컨트롤러를 구현하는 방법은 여러 가지가 있습니다.
     * 가장 일반적인 방법은 요청이 들어온 순서대로 처리하는 것입니다.
     * jobs	return
     * [[0, 3], [1, 9], [2, 6]]	9
     * A -> B -> C 시간의 평균은 10ms(= (3 + 11 + 16) / 3)
     * A -> C -> B 각 작업의 요청부터 종료까지 걸린 시간의 평균은 9ms(= (3 + 7 + 17) / 3)가 됩니다.
     * 작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수로 주어질 때, 작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지 return
     * (단, 소수점 이하의 수는 버립니다)
     */
    @Test
    public void 디스크_컨트롤러() {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        int answer = 0;

        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        int index = 0;
        int count = 0;
        int total = 0;
        int end = 0;

        while (count < jobs.length) {
            while (index < jobs.length && jobs[index][0] <= end) {
                heap.add(jobs[index++]);
            }

            if (heap.isEmpty()) {
                end = jobs[index][0];
            } else {
                int[] cur = heap.poll();
                total += cur[1] + end - cur[0];
                end += cur[1];
                count++;
            }
        }

        answer = total / jobs.length;

        assertThat(answer).isEqualTo(9);
    }

    /**
     * 명령어	수신 탑(높이)
     * I 숫자	큐에 주어진 숫자를 삽입합니다.
     * D 1	    큐에서 최댓값을 삭제합니다.
     * D -1	    큐에서 최솟값을 삭제합니다.
     * 이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.
     * operations	return
     * ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]	[0,0]
     * ["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]	[333, -45]
     */
    @Test
    public void 이중우선순위큐() {
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] answer = {};

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (String operation : operations) {
            String[] oper = operation.split(" ");

            if ("I".equals(oper[0])) {
                minHeap.offer(Integer.valueOf(oper[1]));
                maxHeap.offer(Integer.valueOf(oper[1]));
            } else if ("D".equals(oper[0])) {
                if ("1".equals(oper[1]) && !maxHeap.isEmpty()) {
                    minHeap.remove(maxHeap.poll());
                } else if (!minHeap.isEmpty()){
                    maxHeap.remove(minHeap.poll());
                }
            }
        }

        answer = minHeap.isEmpty() || maxHeap.isEmpty()
                ? new int[]{0, 0}
                : new int[]{maxHeap.poll(), minHeap.poll()};

        assertThat(answer).containsExactly(333, -45);
    }
}
