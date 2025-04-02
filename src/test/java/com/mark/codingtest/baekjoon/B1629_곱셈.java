package com.mark.codingtest.baekjoon;

import java.util.Scanner;

/**
 * <pre>
 * 문제
 * 자연수 A를 B번 곱한 수를 알고 싶다. 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 주어진다. A, B, C는 모두 2,147,483,647 이하의 자연수이다.
 *
 * 출력
 * 첫째 줄에 A를 B번 곱한 수를 C로 나눈 나머지를 출력한다.
 *
 * 예제 입력 1
 * 10 11 12
 * 예제 출력 1
 * 4
 * </pre>
 */
public class B1629_곱셈 {

    static long A, B, C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        A = Long.parseLong(input[0]);
        B = Long.parseLong(input[1]);
        C = Long.parseLong(input[2]);

        System.out.println(pow(A, B, C));
    }

    private static long pow(long a, long b, long c) {
        if (b == 0) return 1;
        if (b == 1) return a % c;

        long half = pow(a, b / 2, c);
        long result = (half * half) % c;

        if (b % 2 == 1) {
            result = (result * a) % c;
        }

        return result;
    }
}
