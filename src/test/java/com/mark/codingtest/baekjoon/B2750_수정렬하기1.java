package com.mark.codingtest.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <b>버블 정렬(Bubble Sort)</b><br>
 * O(N^2)
 */
public class B2750_수정렬하기1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (A[j] > A[j + 1]) {
                    int swap = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = swap;
                }
            }
        }

        System.out.println(Arrays.toString(A));
    }
}
