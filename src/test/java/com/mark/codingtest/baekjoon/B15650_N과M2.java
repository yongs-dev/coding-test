package com.mark.codingtest.baekjoon;

import java.util.Scanner;

/**
 * <pre>
 * 문제
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 *
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * 고른 수열은 오름차순이어야 한다.
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
 * 2 3
 * 2 4
 * 3 4
 * 예제 입력 3
 * 4 4
 * 예제 출력 3
 * 1 2 3 4
 * </pre>
 */
public class B15650_N과M2 {

    static int N, M;
    static int[] selected;

    /**
     * <pre>
     * “조합”이므로 한 번 선택한 숫자는 다시 선택되지 않고, 오름차순을 보장
     * 백트래킹으로 모든 경우의 수를 탐색하되, 이미 뽑은 숫자보다 작은 숫자는 다시 고르지 않도록 하여 중복 및 순서 문제를 해결
     * </pre>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        selected = new int[M];
        backtrack(1, 0);
    }

    private static void backtrack(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(selected[i] + (i == M - 1 ? "\n" : " "));
            }

            return ;
        }

        for (int i = start; i <= N; i++) {
            selected[depth] = i;
            backtrack(i + 1, depth + 1);
        }
    }
}
