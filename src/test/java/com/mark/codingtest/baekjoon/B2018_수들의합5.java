package com.mark.codingtest.baekjoon;

import java.util.Scanner;

/**
 * <b>Two Pointer</b>
 */
public class B2018_수들의합5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int count = 1;
        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;

        while (endIndex != N) {
            if (sum == N) {
                count++;
                endIndex++;
                sum += endIndex;
            } else if (sum > N) {
                sum -= startIndex;
                startIndex++;
            } else {
                endIndex++;
                sum += endIndex;
            }
        }

        System.out.printf("input: %d, count: %d", N, count);
    }
}
