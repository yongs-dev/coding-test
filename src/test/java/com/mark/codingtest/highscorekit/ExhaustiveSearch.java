package com.mark.codingtest.highscorekit;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ExhaustiveSearch {

    /**
     * 명함 번호	가로 길이	세로 길이
     * 1	    60	    50
     * 2	    30	    70
     * 3	    60	    30
     * 4	    80	    40
     * 가장 긴 가로 길이와 세로 길이가 각각 80, 70이기 때문에 80(가로) x 70(세로) 크기의 지갑을 만들면 모든 명함들을 수납할 수 있습니다.
     * 하지만 2번 명함을 가로로 눕혀 수납한다면 80(가로) x 50(세로) 크기의 지갑으로 모든 명함들을 수납할 수 있습니다. 이때의 지갑 크기는 4000(=80 x 50)입니다.
     * 모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다. 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.
     * [[60, 50], [30, 70], [60, 30], [80, 40]]	4000
     * [[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]	120
     * [[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]	133
     */
    @Test
    public void 최소직사각형() {
        int[][] sizes = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
        int answer = 0;

        int maxWidth = 0;
        int maxHeight = 0;

        for (int[] size : sizes) {
            maxWidth = Math.max(maxWidth, Math.max(size[0], size[1]));
            maxHeight = Math.max(maxHeight, Math.min(size[0], size[1]));
        }

        answer = maxWidth * maxHeight;

        assertThat(answer).isEqualTo(133);
    }

    /**
     * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
     * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
     * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
     * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
     * [1,2,3,4,5]	[1]
     * [1,3,2,4,2]	[1,2,3]
     */
    @Test
    public void 모의고사() {
        int[] answers = {1, 2, 3, 4, 5};
        int[] one = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % 5]) {
                score[0]++;
            }

            if (answers[i] == two[i % 8]) {
                score[1]++;
            }

            if (answers[i] == three[i % 10]) {
                score[2]++;
            }
        }

        int maxScore = score[0];
        for (int i = 0; i < score.length; i++) {
            if (maxScore < score[i]) {
                maxScore = score[i];
            }
        }

        List<Integer> grade = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (maxScore == score[i]) {
                grade.add(i + 1);
            }
        }

        int[] answer = grade.stream().mapToInt(Integer::intValue).toArray();
        assertThat(answer).containsExactly(1);
    }

    /**
     * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
     * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
     * numbers는 길이 1 이상 7 이하인 문자열입니다.
     * numbers는 0~9까지 숫자만으로 이루어져 있습니다.
     * "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
     * numbers	return
     * "17"	    3
     * "011"	2
     */
    static Set<Integer> primeSet = new HashSet<>();

    // DFS(Depth-First Search) 깊이 우선 탐색
    @Test
    public void 소수_찾기() {
        String numbers = "011";
        int answer = 0;

        primeDFS(numbers, "");

        for (Integer num : primeSet) {
            int i = 0;
            for (i = 2; i < num; i++) {
                if (num % i == 0) {
                    break;
                }
            }
            if (i == num) {
                answer++;
            }
        }

        assertThat(answer).isEqualTo(2);
    }

    private void primeDFS(String numbers, String str) {
        int length = numbers.length();
        if (!"".equals(str)) {
            primeSet.add(Integer.valueOf(str));
        }
        for (int i = 0; i < length; i++) {
            primeDFS(numbers.substring(0, i) + numbers.substring(i + 1, length), str + numbers.charAt(i));
        }
    }

    /**
     * Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
     * Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
     * 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
     * brown	yellow	return
     * 10	2	[4, 3]
     * 8	1	[3, 3]
     * 24	24	[8, 6]
     */
    @Test
    public void 카펫() {
        int brown = 10;
        int yellow = 2;
        int[] answer = new int[2];

        int area = brown + yellow;

        for (int i = 1; i <= area; i++) {
            int row = area / i;

            if (i > row) {
                continue;
            }

            int insideBlock = (row - 2) * (i - 2);
            if (insideBlock == yellow) {
                answer[0] = row;
                answer[1] = i;
                break;
            }
        }

        assertThat(answer).containsExactly(4, 3);
    }

    /**
     * 피로도 시스템(0 이상의 정수로 표현합니다)이 있으며, 일정 피로도를 사용해서 던전을 탐험할 수 있습니다. 이때,
     * 각 던전마다 탐험을 시작하기 위해 필요한 "최소 필요 피로도"와 던전 탐험을 마쳤을 때 소모되는 "소모 피로도"가 있습니다.
     * "최소 필요 피로도"는 해당 던전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도를 나타내며, "소모 피로도"는 던전을 탐험한 후 소모되는 피로도를 나타냅니다.
     * 예를 들어 "최소 필요 피로도"가 80, "소모 피로도"가 20인 던전을 탐험하기 위해서는 유저의 현재 남은 피로도는 80 이상 이어야 하며, 던전을 탐험한 후에는 피로도 20이 소모됩니다.
     *
     * 이 게임에는 하루에 한 번씩 탐험할 수 있는 던전이 여러개 있는데, 한 유저가 오늘 이 던전들을 최대한 많이 탐험하려 합니다.
     * 유저의 현재 피로도 k와 각 던전별 "최소 필요 피로도", "소모 피로도"가 담긴 2차원 배열 dungeons 가 매개변수로 주어질 때,
     * 유저가 탐험할수 있는 최대 던전 수를 return 하도록 solution 함수를 완성해주세요.
     *
     * dungeons의 세로(행) 길이(즉, 던전의 개수)는 1 이상 8 이하입니다.
     * dungeons의 가로(열) 길이는 2 입니다.
     * dungeons의 각 행은 각 던전의 ["최소 필요 피로도", "소모 피로도"] 입니다.
     * "최소 필요 피로도"는 항상 "소모 피로도"보다 크거나 같습니다.
     * "최소 필요 피로도"와 "소모 피로도"는 1 이상 1,000 이하인 자연수입니다.
     * 서로 다른 던전의 ["최소 필요 피로도", "소모 피로도"]가 서로 같을 수 있습니다.
     *
     * k	dungeons	                result
     * 80	[[80,20],[50,40],[30,10]]	3
     */
    static Integer fatigueAnswer = 0;
    static boolean[] fatigueVisited;

    // DFS(Depth-First Search) 깊이 우선 탐색
    @Test
    public void 피로도() {
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        int k = 80;
        fatigueVisited = new boolean[dungeons.length];

        fatigueDFS(0, k, dungeons);

        assertThat(fatigueAnswer).isEqualTo(3);
    }

    private void fatigueDFS(int depth, int limitFatigue, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!fatigueVisited[i] && dungeons[i][0] <= limitFatigue) {
                fatigueVisited[i] = true;
                fatigueDFS(depth + 1, limitFatigue - dungeons[i][1], dungeons);
                fatigueVisited[i] = false;
            }
        }

        fatigueAnswer = Math.max(fatigueAnswer, depth);
    }

    /**
     * n개의 송전탑이 전선을 통해 하나의 트리 형태로 연결되어 있습니다. 당신은 이 전선들 중 하나를 끊어서 현재의 전력망 네트워크를 2개로 분할하려고 합니다.
     * 이때, 두 전력망이 갖게 되는 송전탑의 개수를 최대한 비슷하게 맞추고자 합니다.
     * 송전탑의 개수 n, 그리고 전선 정보 wires가 매개변수로 주어집니다. 전선들 중 하나를 끊어서 송전탑 개수가 가능한 비슷하도록 두 전력망으로 나누었을 때
     * 두 전력망이 가지고 있는 송전탑 개수의 차이(절대값)를 return 하도록 solution 함수를 완성해주세요.
     *
     * n은 2 이상 100 이하인 자연수입니다.
     * wires는 길이가 n-1인 정수형 2차원 배열입니다.
     * wires의 각 원소는 [v1, v2] 2개의 자연수로 이루어져 있으며, 이는 전력망의 v1번 송전탑과 v2번 송전탑이 전선으로 연결되어 있다는 것을 의미합니다.
     * 1 ≤ v1 < v2 ≤ n 입니다.
     * 전력망 네트워크가 하나의 트리 형태가 아닌 경우는 입력으로 주어지지 않습니다.
     * n	wires	                                            result
     * 9	[[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]	3
     * 4	[[1,2],[2,3],[3,4]]	                                0
     * 7	[[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]	            1
     */

    // BFS(Breadth-First Search) 너비 우선 탐색
    private static int[][] graph;
    @Test
    public void 전력망을_둘로_나누기() {
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        int n = 9;
        int answer = Integer.MAX_VALUE;

        // 인접 행렬 만들기
        graph = new int[n + 1][n + 1];
        for (int[] wire : wires) {
            graph[wire[0]][wire[1]] = 1;
            graph[wire[1]][wire[0]] = 1;
        }

        // 선 하나씩 끊으면서 BFS 탐색
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            // 선 끊기
            graph[v1][v2] = 0;
            graph[v2][v1] = 0;

            // BFS
            answer = Math.min(answer, wiresBFS(v1, n));

            // 끊었던 선 복구
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }

        assertThat(answer).isEqualTo(3);
    }

    private int wiresBFS(int v1, int n) {
        int cnt = 1;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(v1);

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            visited[temp] = true;

            for (int i = 1; i < n + 1; i++) {
                if (graph[temp][i] == 1 && !visited[i]) {
                    queue.add(i);
                    cnt++;
                }
            }
        }

        // cnt, n - cnt는 각각 연결된 전력망
        return Math.abs(cnt - (n - cnt));
    }

    /**
     * 사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는, 길이 5 이하의 모든 단어가 수록되어 있습니다.
     * 사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.
     * 단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.
     *
     * word	result
     * "AAAAE"	6
     * "AAAE"	10
     * "I"	    1563
     * "EIO"	1189
     */
    static String[] WORDS = {"A", "E", "I", "O", "U"};
    static List<String> dictionaryList = new ArrayList<>();
    static int MAX_LENGTH = 5;

    // DFS(Depth-First Search) 너비 우선 탐색
    @Test
    public void 모음사전() {
        String target = "AAAAE";
        int answer = 0;

        dictionaryDFS("", 0);

        for (int i = 0; i <dictionaryList.size(); i++) {
            if (target.equals(dictionaryList.get(i))) {
                answer = i;
                break;
            }
        }

        assertThat(answer).isEqualTo(6);
    }

    private void dictionaryDFS(String str, int len) {
        dictionaryList.add(str);
        if (len == MAX_LENGTH) return;

        for (String s : WORDS) {
            dictionaryDFS(str + s, len + 1);
        }
    }
}
