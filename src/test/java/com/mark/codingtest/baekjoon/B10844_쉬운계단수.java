package com.mark.codingtest.baekjoon;

import java.util.Scanner;

/**
 * <pre>
 * 문제
 * 45656이란 수를 보자.
 *
 * 이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.
 *
 * N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자. 0으로 시작하는 수는 계단수가 아니다.
 *
 * 입력
 * 첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.
 *
 * 출력
 * 첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.
 *
 * 예제 입력 1
 * 1
 * 예제 출력 1
 * 9
 * 예제 입력 2
 * 2
 * 예제 출력 2
 * 17
 * </pre>
 */
public class B10844_쉬운계단수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] A = new int[N + 1][10];
        int MOD = 1_000_000_000;

        for (int i = 1; i <=9; i++) {
            A[1][i] = 1;
        }

        for (int i = 2;i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j >= 1) A[i][j] += A[i - 1][j - 1];
                if (j <= 8) A[i][j] += A[i - 1][j + 1];
                A[i][j] %= MOD;
            }
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result = (result + A[N][i]) % MOD;
        }

        System.out.println(result);
    }
}
