package com.mark.codingtest.baekjoon;

import java.util.Scanner;

/**
 * <pre>
 * 문제
 * 자연수
 * N과 정수 K가 주어졌을 때 이항 계수 N combination K를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에
 * N과 K가 주어진다. (1 ≤ N ≤ 10, 0 ≤ K ≤ N)
 *
 * 출력
 * N combination K 출력한다.
 *
 * 예제 입력 1
 * 5 2
 * 예제 출력 1
 * 10
 * </pre>
 */
public class B11050_이항계수1 {

    static int N;
    static int K;
    static int[][] D;

    /**
     * <b>조합 (Combination)</b><br>
     * <p>점화식을 이쁘게 잘 구하자</p>
     * <p>n개의 숫자에서 r개를 뽑는 경우의 수 -> nCr = n! / ((n-r)! * r!) </p>
     * <p>조합과 비교되는 순열은 n개의 숫자에서 r개를 순서를 고려해 뽑는 경우의 수 -> nPr = n! / (n-r)!</p>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        D = new int[N + 1][N + 1];

        // 초기화
        for (int i = 0; i <= N; i++) {
            D[i][i] = 1;
            D[i][0] = 1;
            D[i][1] = i;
        }
        
        // 점화식으로 배열 완성
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
            }
        }

        System.out.println(D[N][K]);
    }

    public static void main_usingFactorial() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(factorial(N) / (factorial(K) * factorial(N - K)));
    }

    private static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }
}
