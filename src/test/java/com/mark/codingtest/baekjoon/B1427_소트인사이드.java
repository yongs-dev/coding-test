package com.mark.codingtest.baekjoon;

import java.util.Scanner;

/**
 * <pre>
 * 문제
 * 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
 *
 * 입력
 * 첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
 *
 * 출력
 * 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
 *
 * 예제 입력 1
 * 2143
 * 예제 출력 1
 * 4321
 * 예제 입력 2
 * 999998999
 * 예제 출력 2
 * 999999998
 * 예제 입력 3
 * 61423
 * 예제 출력 3
 * 64321
 * 예제 입력 4
 * 500613009
 * 예제 출력 4
 * 965310000
 * </pre>
 */
public class B1427_소트인사이드 {

    /**
     * <b>선택 정렬(Selection Sort). O(N^2)</b><br>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();
        int[] A = new int[N.length()];

        for (int i = 0; i < N.length(); i++) {
            A[i] = Integer.parseInt(N.substring(i, i + 1));
        }

        for (int i = 0; i < N.length(); i++) {
            int maxIndex = i;

            for (int j = i + 1; j < N.length(); j++) {
                if (A[j] > A[maxIndex]) {
                    maxIndex = j;
                }
            }

            int swap = A[maxIndex];
            A[maxIndex] = A[i];
            A[i] = swap;
        }

        for (int i = 0; i < N.length(); i++) {
            System.out.print(A[i]);
        }
    }
}
