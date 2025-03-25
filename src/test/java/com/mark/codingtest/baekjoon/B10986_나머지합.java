package com.mark.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <pre>
 * 문제
 * 수 N개 A1, A2, ..., AN이 주어진다. 이때, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.
 * 즉, Ai + ... + Aj (i ≤ j) 의 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수를 구해야 한다.
 *
 * 입력
 * 첫째 줄에 N과 M이 주어진다. (1 ≤ N ≤ 106, 2 ≤ M ≤ 103)
 *
 * 둘째 줄에 N개의 수 A1, A2, ..., AN이 주어진다. (0 ≤ Ai ≤ 109)
 *
 * 출력
 * 첫째 줄에 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 출력한다.
 *
 * 예제 입력 1
 * 5 3
 * 1 2 3 1 2
 * 예제 출력 1
 * 7
 * </pre>
 */
public class B10986_나머지합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] S = new int[M];

        long sum = 0;
        long result = 0;
        S[0] = 1;

        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(input[i]);
            sum += num;
            int reminder = (int) (sum % M);
            S[reminder]++;
        }

        for (int i = 0; i < M; i++) {
            if (S[i] >= 2) {
                result += (long) S[i] * (S[i] - 1) / 2;
            }
        }

        System.out.println(result);
    }
}
