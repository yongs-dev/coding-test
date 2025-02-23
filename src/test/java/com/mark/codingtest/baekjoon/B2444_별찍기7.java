package com.mark.codingtest.baekjoon;

import java.util.Scanner;

/**
 * <pre>
 * 문제
 * 예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.
 *
 * 입력
 * 첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
 *
 * 출력
 * 첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.
 *
 * 예제 입력 1
 * 5
 *
 * 예제 출력 1
 *     *
 *    ***
 *   *****
 *  *******
 * *********
 *  *******
 *   *****
 *    ***
 *     *
 * </pre>
 */
public class B2444_별찍기7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            print(N, i);
        }

        for (int i = N - 1; i >= 1; i--) {
            print(N, i);
        }
    }

    private static void print(int N, int i) {
        for (int j = 0; j < N - i; j++) {
            System.out.print(" ");
        }

        for (int j = 0; j < (2 * i - 1); j++) {
            System.out.print("*");
        }

        System.out.println();
    }
}
