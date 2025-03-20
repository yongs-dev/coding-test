package com.mark.codingtest.baekjoon;

import java.util.Scanner;

/**
 * <pre>
 * 문제
 * 오늘도 서준이는 동적 프로그래밍 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.
 *
 * 오늘은 n의 피보나치 수를 재귀호출과 동적 프로그래밍으로 구하는 알고리즘을 배웠다. 재귀호출에 비해 동적 프로그래밍이 얼마나 빠른지 확인해 보자. 아래 의사 코드를 이용하여 n의 피보나치 수를 구할 경우 코드1 코드2 실행 횟수를 출력하자.
 *
 * 피보나치 수 재귀호출 의사 코드는 다음과 같다.
 *
 * fib(n) {
 *     if (n = 1 or n = 2)
 *     then return 1;  # 코드1
 *     else return (fib(n - 1) + fib(n - 2));
 * }
 * 피보나치 수 동적 프로그래밍 의사 코드는 다음과 같다.
 *
 * fibonacci(n) {
 *     f[1] <- f[2] <- 1;
 *     for i <- 3 to n
 *         f[i] <- f[i - 1] + f[i - 2];  # 코드2
 *     return f[n];
 * }
 * 입력
 * 첫째 줄에 n(5 ≤ n ≤ 40)이 주어진다.
 *
 * 출력
 * 코드1 코드2 실행 횟수를 한 줄에 출력한다.
 *
 * 예제 입력 1
 * 5
 * 예제 출력 1
 * 5 3
 * 예제 입력 2
 * 30
 * 예제 출력 2
 * 832040 28
 * </pre>
 */
public class B24416_알고리즘수업_피보나치수1 {

    static int recursiveCount = 0;
    static int dpCount = 0;
    static int dp[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new int[N];

        fibonacciRecursive(N);
        fibonacciDP(N);

        System.out.println(recursiveCount + " " + dpCount);
    }

    private static int fibonacciRecursive(int num) {
        if (num == 1 || num == 2) {
            recursiveCount++;
            return 1;
        }

        return fibonacciRecursive(num - 1) + fibonacciRecursive(num - 2);
    }

    private static int fibonacciDP(int num) {
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < num; i++) {
            dpCount++;
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[num - 1];
    }
}
