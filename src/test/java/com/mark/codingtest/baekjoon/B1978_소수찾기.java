package com.mark.codingtest.baekjoon;

import java.util.Scanner;

/**
 * <pre>
 * 문제
 * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
 *
 * 출력
 * 주어진 수들 중 소수의 개수를 출력한다.
 *
 * 예제 입력 1
 * 4
 * 1 3 5 7
 * 예제 출력 1
 * 3
 * </pre>
 */
public class B1978_소수찾기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;

        for (int i = 0; i < N; i++) {
            int M = sc.nextInt();

            if (M == 1) continue;

            boolean isPrime = true;

            for (int j = 2; j * j <= M; j++) {
                if (M % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                result++;
            }
        }

        System.out.println(result);
    }
}
