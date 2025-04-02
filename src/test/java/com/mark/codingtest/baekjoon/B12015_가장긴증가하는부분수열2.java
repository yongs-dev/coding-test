package com.mark.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 * 문제
 * 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
 *
 * 예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 30, 50} 이고, 길이는 4이다.
 *
 * 입력
 * 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다.
 *
 * 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000,000)
 *
 * 출력
 * 첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
 *
 * 예제 입력 1
 * 6
 * 10 20 10 30 20 50
 * 예제 출력 1
 * 4
 * </pre>
 */
public class B12015_가장긴증가하는부분수열2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }

        List<Integer> dp = new ArrayList<>();

        for (int x : A) {
            if (dp.isEmpty() || dp.getLast() < x) {
                dp.add(x);
            } else {
                int index = Collections.binarySearch(dp, x);
                if (index < 0) {
                    index = -(index + 1);
                }

                dp.set(index, x);
            }
        }

        System.out.println(dp.size());
    }
}
