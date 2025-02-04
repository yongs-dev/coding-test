package com.mark.codingtest.baekjoon;

import java.util.Scanner;

/**
 * <b>그리디 (Greedy)</b>
 *
 * <p>예시 입출력</p>
 * <pre>
 * 입력:
 * 10 4200  동전 수, 목표 금액
 * 1
 * 5
 * 10
 * 50
 * 100
 * 500
 * 1000
 * 5000
 * 10000
 * 50000
 *
 * 출력:
 * 6
 * </pre>
 */
public class B11047_동전개수의_최솟값구하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(n + ", " + m);
    }
}
