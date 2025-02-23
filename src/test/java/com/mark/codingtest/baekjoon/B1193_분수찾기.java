package com.mark.codingtest.baekjoon;

import java.util.Scanner;

/**
 * <pre>
 * 문제
 * 무한히 큰 배열에 다음과 같이 분수들이 적혀있다.
 *
 * 1/1 1/2 1/3 1/4 1/5
 * 2/1 2/2 2/3 2/4  …
 * 3/1 3/2 3/3  …   …
 * 4/1 4/2  …   …   …
 * 5/1  …   …   …   …
 *  …   …   …   …   …
 * 이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
 *
 * X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.
 *
 * 출력
 * 첫째 줄에 분수를 출력한다.
 *
 * 예제 입력 1
 * 1
 * 예제 출력 1
 * 1/1
 * 예제 입력 2
 * 2
 * 예제 출력 2
 * 1/2
 * 예제 입력 3
 * 3
 * 예제 출력 3
 * 2/1
 * </pre>
 */
public class B1193_분수찾기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        int n = 1;
        while (n * (n + 1) / 2 < X) {
            n++;
        }

        int start = (n * (n - 1)) / 2 + 1;
        int position = X - start;

        int numerator, denominator;

        if (n % 2 == 0) {
            numerator = 1 + position;
            denominator = n - position;
        } else {
            numerator = n - position;
            denominator = 1 + position;
        }

        System.out.println(numerator + "/" + denominator);
    }
}
