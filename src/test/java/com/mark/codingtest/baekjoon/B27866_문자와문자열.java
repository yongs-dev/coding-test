package com.mark.codingtest.baekjoon;

import java.util.Scanner;

/**
 * <pre>
 * 문제
 * 단어 S와 정수 i가 주어졌을 때, S의 i번째 글자를 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 영어 소문자와 대문자로만 이루어진 단어 S가 주어진다. 단어의 길이는 최대 1,000이다.
 * 둘째 줄에 정수 i가 주어진다.
 *
 * 출력
 * S의 i번째 글자를 출력한다.
 *
 * 예제 입력 1
 * Sprout
 * 3
 *
 * 예제 출력 1
 * r
 *
 * 예제 입력 2
 * shiftpsh
 * 6
 *
 * 예제 출력 2
 * p
 * </pre>
 */
public class B27866_문자와문자열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String INPUT = sc.nextLine();
        int N = sc.nextInt();

        System.out.printf("%s", INPUT.toCharArray()[N - 1]);
    }
}
