package com.mark.codingtest.baekjoon;

import java.util.Scanner;

/**
 * <b>정수론 (Number Theory)</b>
 * <p>에라토스테네스의 체 (Sieve of Eratosthenes)</p>
 * <pre>
 *  input:
 *  3 16
 *
 *  output:
 *  3
 *  5
 *  7
 *  11
 *  13
 * </pre>
 */
public class B1929_소수구하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] A = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (A[i] == 0) continue;

            for (int j = i + i; j <= N; j = j + i) {
                A[j] = 0;
            }
        }

        for (int i = M; i <= N; i++) {
            if (A[i] != 0) {
                System.out.println(A[i]);
            }
        }
    }
}
