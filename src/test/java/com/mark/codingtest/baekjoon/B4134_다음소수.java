package com.mark.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <pre>
 * 문제
 * 정수 n(0 ≤ n ≤ 4*10^9)가 주어졌을 때, n보다 크거나 같은 소수 중 가장 작은 소수 찾는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다.
 *
 * 출력
 * 각각의 테스트 케이스에 대해서 n보다 크거나 같은 소수 중 가장 작은 소수를 한 줄에 하나씩 출력한다.
 *
 * 예제 입력 1
 * 3
 * 6
 * 20
 * 100
 *
 * 예제 출력 1
 * 7
 * 23
 * 101
 * </pre>
 */
public class B4134_다음소수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());

        for (int i = 0; i < C; i++) {
            long N = Long.parseLong(br.readLine());

            if (N <= 1) {
                System.out.println(2);
                continue;
            }

            while (true) {
                boolean isPrime = true;

                for (long j = 2; j * j <= N; j++) {
                    if (N % j == 0) {
                        N++;
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    System.out.println(N);
                    break;
                }
            }
        }
    }
}
