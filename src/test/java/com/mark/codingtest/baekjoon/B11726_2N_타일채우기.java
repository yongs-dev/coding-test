package com.mark.codingtest.baekjoon;

import java.util.Scanner;

/**
 * <b>동적 계획법 (Dynamic Programming)</b>
 *
 * <pre>
 * input-1:
 * 9
 *
 * output-1:
 * 55
 *
 * input-2:
 * 2
 *
 * output-2:
 * 2
 * </pre>
 */
public class B11726_2N_타일채우기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] D = new int[N + 1];
        D[1] = 1;   // N이 1일때 타일 채우는 경우의 수
        D[2] = 2;   // N이 2일때 타일 채우는 경우의 수

        for (int i = 3; i <= N; i++) {
            D[i] = (D[i - 1] + D[i - 2]) % 10007;
        }

        System.out.println(D[N]);
    }
}
