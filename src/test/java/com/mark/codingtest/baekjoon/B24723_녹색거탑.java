package com.mark.codingtest.baekjoon;

import java.util.Scanner;

/**
 * <pre>
 * 문제
 * 녹색거탑은 위 그림과 같이 규칙적으로 쌓여있다.
 *
 * 그림의 시야에 보이지 않는 블록은 없다.
 * 그림의 시야에 보이는 블록의 윗면만 이용해 녹색거탑을 내려올 수 있다.
 * 녹색거탑이 N층이면, 총 N개의 블록을 이용한 최단 경로로만 내려온다.
 * 녹색거탑을 내려올 때는 정상에서 시작해 노란색 바닥까지, 항상 인접한 아래층의 블록으로만 내려온다.
 *
 * 입력
 * 녹색거탑의 높이를 나타내는 정수 N이 주어진다. (1 <= N <= 5)
 *
 * 출력
 * 녹색거탑의 정상에서 바닥으로 내려오는 경우의 수를 출력한다.
 *
 * 예제 입력 1
 * 1
 * 예제 출력 1
 * 2
 *
 * 예제 입력 2
 * 2
 * 예제 출력 2
 * 4
 * </pre>
 */
public class B24723_녹색거탑 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(1 << N);
    }
}
