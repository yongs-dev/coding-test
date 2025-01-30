package com.mark.codingtest.baekjoon;

import java.util.Scanner;

public class B1546_평균 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long max = 0;
        long sum = 0;

        for (int i = 0; i < N; i++) {
            int score = sc.nextInt();
            max = Math.max(max, score);
            sum += score;
        }

        double result = sum * 100.0 / max / N;
        System.out.printf("%d %d %f\n", max, sum, result);
    }
}
