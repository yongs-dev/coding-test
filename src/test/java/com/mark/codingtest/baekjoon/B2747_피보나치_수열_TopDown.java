package com.mark.codingtest.baekjoon;

import java.util.Scanner;

/**
 * <b>동적 계획법 (Dynamic Programming)</b>
 * <p>Top-Down 방식 풀이</p>
 *
 * <pre>
 * input:
 * 10
 *
 * output:
 * 55
 * </pre>
 */
public class B2747_피보나치_수열_TopDown {
    static int[] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        D = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            D[i] = -1;
        }

        D[0] = 0;
        D[1] = 1;

        fibo(N);
        System.out.println(D[N]);
    }

    private static int fibo(int n) {
        if (D[n] != -1) {
            return D[n];
        }

        return D[n] = fibo(n - 2) + fibo(n - 1);
    }
}
