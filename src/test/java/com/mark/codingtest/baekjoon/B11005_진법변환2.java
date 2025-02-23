package com.mark.codingtest.baekjoon;

import java.util.Scanner;

/**
 * <pre>
 * 문제
 * 10진법 수 N이 주어진다. 이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오.
 *
 * 10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
 *
 * A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
 *
 * 입력
 * 첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36) N은 10억보다 작거나 같은 자연수이다.
 *
 * 출력
 * 첫째 줄에 10진법 수 N을 B진법으로 출력한다.
 *
 * 예제 입력 1
 * 60466175 36
 * 예제 출력 1
 * ZZZZZ
 * </pre>
 */
public class B11005_진법변환2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        convertToBase(N, B);
    }

    private static void convertToBase(int N, int B) {
        if (N == 0) return;

        convertToBase(N / B, B);

        int rem = N  % B;
        if (rem < 10) {
            System.out.print((char) ('0' + rem));
        } else {
            System.out.print((char) ('A' + (rem - 10)));
        }
    }
}
