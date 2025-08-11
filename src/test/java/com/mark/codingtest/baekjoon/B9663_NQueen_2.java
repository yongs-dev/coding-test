package com.mark.codingtest.baekjoon;

import java.util.Scanner;

/**
 * <pre>
 * 문제
 * N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
 * 체스에서 퀸(Queen)은 가로(행), 세로(열), 대각선 어느 방향이든 공격이 가능하다.
 *
 * N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N이 주어진다. (1 ≤ N < 15)
 *
 * 출력
 * 첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
 *
 * 예제 입력 1
 * 8
 * 예제 출력 1
 * 92
 * </pre>
 */
public class B9663_NQueen_2 {

    static int N;
    static int[] columns;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        columns = new int[N];

        backtracking(0);
        System.out.println(count);
    }

    private static void backtracking(int row) {
        if (row == N) { // 3. 정답 출력
            count++;
            return ;
        }

        for (int i = 0; i < N; i++) { // 1. 모든 경우의 수 탐색
            columns[row] = i;
            if (check(row)) { // 2. 가지치기
                backtracking(row + 1);
            }
        }
    }

    private static boolean check(int row) {
        for (int i = 0; i < row; i++) {
            if (columns[row] == columns[i]) return false;   // 직선
            if (Math.abs(row - i) == Math.abs(columns[row] - columns[i])) return false;  // 대각선
        }

        return true;
    }
}