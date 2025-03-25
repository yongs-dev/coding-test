package com.mark.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <pre>
 * 문제
 * N×N크기의 행렬로 표현되는 종이가 있다. 종이의 각 칸에는 -1, 0, 1 중 하나가 저장되어 있다. 우리는 이 행렬을 다음과 같은 규칙에 따라 적절한 크기로 자르려고 한다.
 *
 * 1. 만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
 * 2. (1)이 아닌 경우에는 종이를 같은 크기의 종이 9개로 자르고, 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
 * 이와 같이 종이를 잘랐을 때, -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 구해내는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N(1 ≤ N ≤ 37, N은 3k 꼴)이 주어진다. 다음 N개의 줄에는 N개의 정수로 행렬이 주어진다.
 *
 * 출력
 * 첫째 줄에 -1로만 채워진 종이의 개수를, 둘째 줄에 0으로만 채워진 종이의 개수를, 셋째 줄에 1로만 채워진 종이의 개수를 출력한다.
 *
 * 예제 입력 1
 * 9
 * 0 0 0 1 1 1 -1 -1 -1
 * 0 0 0 1 1 1 -1 -1 -1
 * 0 0 0 1 1 1 -1 -1 -1
 * 1 1 1 0 0 0 0 0 0
 * 1 1 1 0 0 0 0 0 0
 * 1 1 1 0 0 0 0 0 0
 * 0 1 -1 0 1 -1 0 1 -1
 * 0 -1 1 0 1 -1 0 1 -1
 * 0 1 -1 1 0 -1 0 1 -1
 * 예제 출력 1
 * 10
 * 12
 * 11
 * </pre>
 */
public class B1780_종이의개수 {

    static int N;
    static int[][] matrix;
    static int zero = 0, plus = 0, minus = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            for (int j = 0; j < input.length; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }

        dfs(0, 0, N);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    private static void dfs(int x, int y, int size) {
        if (check(x, y, size)) {
            count(matrix[x][y]);
            return ;
        }

        int oneThird = size / 3;
        dfs(x, y, oneThird);
        dfs(x, y + oneThird, oneThird);
        dfs(x, y + oneThird * 2, oneThird);

        dfs(x + oneThird, y, oneThird);
        dfs(x + oneThird, y + oneThird, oneThird);
        dfs(x + oneThird, y + oneThird * 2, oneThird);

        dfs(x + oneThird * 2, y, oneThird);
        dfs(x + oneThird * 2, y + oneThird, oneThird);
        dfs(x + oneThird * 2, y + oneThird * 2, oneThird);
    }

    private static boolean check(int x, int y, int size) {
        int target = matrix[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (matrix[i][j] != target) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void count(int target) {
        switch (target) {
            case 0: zero++; break;
            case 1: plus++; break;
            case -1: minus++; break;
        }
    }
}
