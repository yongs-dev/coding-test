package com.mark.codingtest.baekjoon;

import java.util.Scanner;

/**
 * <pre>
 * 문제
 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
 *
 * 1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * 2. X가 2로 나누어 떨어지면, 2로 나눈다.
 * 3. 1을 뺀다.
 * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
 *
 * 입력
 * 첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.
 *
 * 출력
 * 첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
 *
 * 예제 입력 1
 * 2
 * 예제 출력 1
 * 1
 * 예제 입력 2
 * 10
 * 예제 출력 2
 * 3
 * 힌트
 * 10의 경우에 10 → 9 → 3 → 1 로 3번 만에 만들 수 있다.
 * </pre>
 */
public class B1463_1로만들기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N + 1];

        A[1] = 0;

        for (int i = 2; i <= N; i++) {
            A[i] = A[i - 1] + 1;

            if (i % 3 == 0) {
                A[i] = Math.min(A[i], A[i / 3] + 1);
            }

            if (i % 2 == 0) {
                A[i] = Math.min(A[i], A[i / 2] + 1);
            }
        }

        System.out.println(A[N]);
    }
}
