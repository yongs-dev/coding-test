package com.mark.codingtest.baekjoon;

import java.util.Scanner;

/**
 * <pre>
 * 문제
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 *
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * 입력
 * 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
 *
 * 출력
 * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
 *
 * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 *
 * 예제 입력 1
 * 3 1
 * 예제 출력 1
 * 1
 * 2
 * 3
 * 예제 입력 2
 * 4 2
 * 예제 출력 2
 * 1 2
 * 1 3
 * 1 4
 * 2 1
 * 2 3
 * 2 4
 * 3 1
 * 3 2
 * 3 4
 * 4 1
 * 4 2
 * 4 3
 * 예제 입력 3
 * 4 4
 * 예제 출력 3
 * 1 2 3 4
 * 1 2 4 3
 * 1 3 2 4
 * 1 3 4 2
 * 1 4 2 3
 * 1 4 3 2
 * 2 1 3 4
 * 2 1 4 3
 * 2 3 1 4
 * 2 3 4 1
 * 2 4 1 3
 * 2 4 3 1
 * 3 1 2 4
 * 3 1 4 2
 * 3 2 1 4
 * 3 2 4 1
 * 3 4 1 2
 * 3 4 2 1
 * 4 1 2 3
 * 4 1 3 2
 * 4 2 1 3
 * 4 2 3 1
 * 4 3 1 2
 * 4 3 2 1
 * </pre>
 */
public class B15649_N과M1 {

    static int N, M;
    static int[] selected;
    static boolean[] visited;

    /**
     * <pre>
     * <b>백트래킹의 개념</b>
     * DFS(깊이 우선 탐색) 구조를 사용해 해결해야 할 문제의 모든 경우의 수를 탐색
     * 탐색 도중에 현재 상황에서 더 이상 유효하지 않은 경우(목표하는 조건을 만족하지 않음)가 생기면,
     * 그 분기를 더 깊이 들어가지 않고 되돌아가(backtrack) 다른 경우의 수를 시도.
     *
     * 주로 재귀 함수(DFS)와 함께 쓰이며, 순열, 조합 문제나 그래프에서 특정 조건을 만족하는 경로 찾기 등 다양한 곳에서 활용
     *
     * 예시 상황
     * 1부터 N까지의 수 중 중복 없이 M개를 고른 수열을 모두 찾아야 함
     * 즉, 현재까지 고른 숫자들이 중복되지 않아야 하고, 선택한 숫자가 M개가 되면 출력
     * </pre>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        selected = new int[M];
        visited = new boolean[N + 1];

        backtrack(0);
    }

    private static void backtrack(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(selected[i]);
                if (i < M - 1) {
                    System.out.print(" ");
                }
            }

            System.out.println();
            return ;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[depth] = i;

                backtrack(depth + 1);

                visited[i] = false;
            }
        }
    }
}
