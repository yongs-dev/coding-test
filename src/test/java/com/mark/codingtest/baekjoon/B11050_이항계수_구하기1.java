package com.mark.codingtest.baekjoon;

import java.util.Scanner;

/**
 * <b>조합 (Combination)</b><br>
 * <p>점화식을 이쁘게 잘 구하자</p>
 * <p>n개의 숫자에서 r개를 뽑는 경우의 수 -> nCr = n! / ((n-r)! * r!) </p>
 * <p>조합과 비교되는 순열은 n개의 숫자에서 r개를 순서를 고려해 뽑는 경우의 수 -> nPr = n! / (n-r)!</p>
 *
 * <pre>
 * 입력:
 * 5 2
 *
 * 출력:
 * 10
 * </pre>
 */
public class B11050_이항계수_구하기1 {

    static int N;
    static int K;
    static int[][] D;

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
}
