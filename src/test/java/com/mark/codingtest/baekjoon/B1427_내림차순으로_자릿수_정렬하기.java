package com.mark.codingtest.baekjoon;

import java.util.Scanner;

/**
 * <b>Selection Sort</b><br>
 * O(N^2)
 */
public class B1427_내림차순으로_자릿수_정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int A[] = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            A[i] = Integer.parseInt(str.substring(i, i + 1));
        }

        for (int i = 0; i < str.length(); i++) {
            int max = i;

            for (int j = i + 1; j < str.length(); j++) {
                if (A[j] > A[max]) {
                    max = j;
                }
            }

            if (A[i] < A[max]) {
                int swap = A[max];
                A[max] = A[i];
                A[i] = swap;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            System.out.print(A[i]);
        }
    }
}
