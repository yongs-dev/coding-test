package com.mark.codingtest.baekjoon;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class B11720_숫자의합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String input = sc.next();

        int result = 0;
        for (char c : input.toCharArray()) {
            result += c - '0';
        }

        System.out.printf("result: %d", result);
    }
}
