package com.mark.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <pre>
 * 문제
 * 지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다. 어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다. 지민이는 이 보드를 잘라서 K×K 크기의 체스판으로 만들려고 한다.
 *
 * 체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다. 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다. 따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.
 *
 * 보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 K×K 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다. 당연히 K×K 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 정수 N, M, K가 주어진다. 둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.
 *
 * 출력
 * 첫째 줄에 지민이가 잘라낸 K×K 보드를 체스판으로 만들기 위해 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.
 *
 * 제한
 * 1 ≤ N, M ≤ 2000
 * 1 ≤ K ≤ min(N, M)
 * 예제 입력 1
 * 4 4 3
 * BBBB
 * BBBB
 * BBBW
 * BBWB
 * 예제 출력 1
 * 2
 * 예제 입력 2
 * 8 8 8
 * WBWBWBWB
 * BWBWBWBW
 * WBWBWBWB
 * BWBBBWBW
 * WBWBWBWB
 * BWBWBWBW
 * WBWBWBWB
 * BWBWBWBW
 * 예제 출력 2
 * 1
 * 예제 입력 3
 * 10 13 10
 * BBBBBBBBWBWBW
 * BBBBBBBBBWBWB
 * BBBBBBBBWBWBW
 * BBBBBBBBBWBWB
 * BBBBBBBBWBWBW
 * BBBBBBBBBWBWB
 * BBBBBBBBWBWBW
 * BBBBBBBBBWBWB
 * WWWWWWWWWWBWB
 * WWWWWWWWWWBWB
 * 예제 출력 3
 * 30
 * 예제 입력 4
 * 9 23 9
 * BBBBBBBBBBBBBBBBBBBBBBB
 * BBBBBBBBBBBBBBBBBBBBBBB
 * BBBBBBBBBBBBBBBBBBBBBBB
 * BBBBBBBBBBBBBBBBBBBBBBB
 * BBBBBBBBBBBBBBBBBBBBBBB
 * BBBBBBBBBBBBBBBBBBBBBBB
 * BBBBBBBBBBBBBBBBBBBBBBB
 * BBBBBBBBBBBBBBBBBBBBBBB
 * BBBBBBBBBBBBBBBWWWWWWWW
 * 예제 출력 4
 * 40
 * </pre>
 */
public class B25682_체스판다시칠하기2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        // 누적합 배열
        int[][] blackStart = new int[N + 1][M + 1];
        int[][] whiteStart = new int[N + 1][M + 1];

        // prefix sum 구성
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                char expectedBlack = ((i + j) % 2 == 0) ? 'B' : 'W';
                char expectedWhite = ((i + j) % 2 == 0) ? 'W' : 'B';

                blackStart[i][j] = blackStart[i - 1][j] + blackStart[i][j - 1] - blackStart[i - 1][j - 1] + (board[i - 1][j - 1] != expectedBlack ? 1 : 0);
                whiteStart[i][j] = whiteStart[i - 1][j] + whiteStart[i][j - 1] - whiteStart[i - 1][j - 1] + (board[i - 1][j - 1] != expectedWhite ? 1 : 0);
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                int bCount = blackStart[i][j] - blackStart[i - K][j] - blackStart[i][j - K] + blackStart[i - K][j - K];
                int wCount = whiteStart[i][j] - whiteStart[i - K][j] - whiteStart[i][j - K] + whiteStart[i - K][j - K];

                min = Math.min(min, Math.min(bCount, wCount));
            }
        }

        System.out.println(min);

    }
}
