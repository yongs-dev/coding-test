package com.mark.codingtest.baekjoon;

import java.util.Scanner;

/**
 * <pre>
 * 자연수
 * N과 정수 K가 주어졌을 때 이항 계수 N combination K를 1,000,000,007로 나눈 나머지를 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 4,000,000, 0 ≤ K ≤ N)
 *
 * 출력
 * N combination K를 1,000,000,007로 나눈 나머지를 출력한다.
 *
 * 예제 입력 1
 * 5 2
 * 예제 출력 1
 * 10
 * </pre>
 */
public class B11401_이항계수3 {

    static int MOD = 1_000_000_007;
    static long[] fact;
    static long[] invFact;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        fact = new long[N + 1];
        invFact = new long[N + 1];
        initFactorial(N);

        long result = fact[N];
        result = (result * invFact[K]) % MOD;
        result = (result * invFact[N - K]) % MOD;
        System.out.println(result);
    }

    private static void initFactorial(int n) {
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[n] = pow(fact[n], MOD - 2);

        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }
    }

    private static long pow(long base, int exp) {
        if (exp == 0) return 1;
        if (exp == 1) return base % MOD;

        long half = pow(base, exp / 2);
        long result = (half * half) % MOD;

        if (exp % 2 == 1) {
            result = (result * base) % MOD;
        }

        return result;
    }
}
