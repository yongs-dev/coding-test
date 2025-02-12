package com.mark.codingtest.baekjoon;

import java.util.Scanner;

/**
 * <b>동적 계획법 (Dynamic Programming)</b>
 * <p>Bottom-Up 방식 풀이</p>
 *
 * <pre>
 * input:
 * 10
 *
 * output:
 * 55
 * </pre>
 */
public class B2747_피보나치_수열_BottomUp {
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

        for (int i = 2; i <= N; i++) {
            D[i] = D[i - 1] + D[i - 2];
        }

        System.out.println(D[N]);
    }
}
