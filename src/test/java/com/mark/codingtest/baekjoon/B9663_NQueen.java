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
public class B9663_NQueen {

    static int N;
    static int[] col;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        col = new int[N];

        backtrack(0);

        System.out.println(count);
    }

    private static void backtrack(int row) {
        if (row == N) {
            count++;
            return ;
        }

        for (int i = 0; i < N; i++) {
            col[row] = i;

            if (isValid(row)) {
                backtrack(row + 1);
            }
        }
    }

    private static boolean isValid(int row) {
        for (int i = 0; i < row; i++) {
            if (col[row] == col[i]) {
                return false;
            }

            if (Math.abs(col[row] - col[i]) == Math.abs(row - i)) {
                return false;
            }
        }

        return true;
    }
}
