package com.mark.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <pre>
 * 문제
 * N×N개의 수가 N×N 크기의 표에 채워져 있다. (x1, y1)부터 (x2, y2)까지 합을 구하는 프로그램을 작성하시오. (x, y)는 x행 y열을 의미한다.
 *
 * 예를 들어, N = 4이고, 표가 아래와 같이 채워져 있는 경우를 살펴보자.
 *
 * 1	2	3	4
 * 2	3	4	5
 * 3	4	5	6
 * 4	5	6	7
 * 여기서 (2, 2)부터 (3, 4)까지 합을 구하면 3+4+5+4+5+6 = 27이고, (4, 4)부터 (4, 4)까지 합을 구하면 7이다.
 *
 * 표에 채워져 있는 수와 합을 구하는 연산이 주어졌을 때, 이를 처리하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 표의 크기 N과 합을 구해야 하는 횟수 M이 주어진다. (1 ≤ N ≤ 1024, 1 ≤ M ≤ 100,000) 둘째 줄부터 N개의 줄에는 표에 채워져 있는 수가 1행부터 차례대로 주어진다. 다음 M개의 줄에는 네 개의 정수 x1, y1, x2, y2 가 주어지며, (x1, y1)부터 (x2, y2)의 합을 구해 출력해야 한다. 표에 채워져 있는 수는 1,000보다 작거나 같은 자연수이다. (x1 ≤ x2, y1 ≤ y2)
 *
 * 출력
 * 총 M줄에 걸쳐 (x1, y1)부터 (x2, y2)까지 합을 구해 출력한다.
 *
 * 예제 입력 1
 * 4 3
 * 1 2 3 4
 * 2 3 4 5
 * 3 4 5 6
 * 4 5 6 7
 * 2 2 3 4
 * 3 4 3 4
 * 1 1 4 4
 * 예제 출력 1
 * 27
 * 6
 * 64
 * 예제 입력 2
 * 2 4
 * 1 2
 * 3 4
 * 1 1 1 1
 * 1 2 1 2
 * 2 1 2 1
 * 2 2 2 2
 * 예제 출력 2
 * 1
 * 2
 * 3
 * 4
 * </pre>
 */
public class B11660_구간합구하기5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N + 1][N + 1];
        int[][] S = new int[N + 1][N + 1];

        // 입력 받기 및 누적합 계산
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                S[i][j] = S[i - 1][j] + S[i][j - 1] - S[i - 1][j - 1] + A[i][j];
            }
        }

        // 쿼리 처리
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = S[x2][y2]
                    - S[x1 - 1][y2]
                    - S[x2][y1 - 1]
                    + S[x1 - 1][y1 - 1];
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
