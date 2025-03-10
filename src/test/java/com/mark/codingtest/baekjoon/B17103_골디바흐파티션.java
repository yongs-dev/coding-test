package com.mark.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <pre>
 * 문제
 * 골드바흐의 추측: 2보다 큰 짝수는 두 소수의 합으로 나타낼 수 있다.
 * 짝수 N을 두 소수의 합으로 나타내는 표현을 골드바흐 파티션이라고 한다. 짝수 N이 주어졌을 때, 골드바흐 파티션의 개수를 구해보자. 두 소수의 순서만 다른 것은 같은 파티션이다.
 *
 * 입력
 * 첫째 줄에 테스트 케이스의 개수 T (1 ≤ T ≤ 100)가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 N은 짝수이고, 2 < N ≤ 1,000,000을 만족한다.
 *
 * 출력
 * 각각의 테스트 케이스마다 골드바흐 파티션의 수를 출력한다.
 *
 * 예제 입력 1
 * 5
 * 6
 * 8
 * 10
 * 12
 * 100
 * 예제 출력 1
 * 1
 * 1
 * 2
 * 1
 * 6
 * </pre>
 */
public class B17103_골디바흐파티션 {

    static final int MAX = 1_000_000;
    static final boolean[] isPrime = new boolean[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sieve();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int count = countGoldbachPartitions(N);
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    private static void sieve() {
        for (int i = 2; i <= MAX; i++) isPrime[i] = true;
        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j +=i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    private static int countGoldbachPartitions(int N) {
        int count = 0;

        for (int i = 2; i <= N / 2; i++) {
            int j = N - i;

            if (isPrime[i] && isPrime[j]) {
                count++;
            }
        }

        return count;
    }
}
