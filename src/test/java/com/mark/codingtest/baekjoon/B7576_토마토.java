package com.mark.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * 철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 토마토는 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다.
 *
 * 창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
 *
 * 토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
 *
 * 입력
 * 첫 줄에는 상자의 크기를 나타내는 두 정수 M,N이 주어진다. M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M,N ≤ 1,000 이다. 둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다. 즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다. 하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다. 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
 *
 * 토마토가 하나 이상 있는 경우만 입력으로 주어진다.
 *
 * 출력
 * 여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다. 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
 *
 * 예제 입력 1
 * 6 4
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 1
 * 예제 출력 1
 * 8
 * 예제 입력 2
 * 6 4
 * 0 -1 0 0 0 0
 * -1 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 1
 * 예제 출력 2
 * -1
 * 예제 입력 3
 * 6 4
 * 1 -1 0 0 0 0
 * 0 -1 0 0 0 0
 * 0 0 0 0 -1 0
 * 0 0 0 0 -1 1
 * 예제 출력 3
 * 6
 * 예제 입력 4
 * 5 5
 * -1 1 0 0 0
 * 0 -1 -1 -1 0
 * 0 -1 -1 -1 0
 * 0 -1 -1 -1 0
 * 0 0 0 0 0
 * 예제 출력 4
 * 14
 * 예제 입력 5
 * 2 2
 * 1 -1
 * -1 1
 * 예제 출력 5
 * 0
 * </pre>
 */
public class B7576_토마토 {

    static int N;
    static int M;

    static int[][] map;
    static Queue<int[]> queue = new LinkedList<>();

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        map = new int[N][M];

        for (int n = 0; n < N; n++) {
            input = br.readLine().split(" ");

            for (int m = 0; m < M; m++) {
                map[n][m] = Integer.parseInt(input[m]);

                if (map[n][m] == 1) {
                    queue.add(new int[] {n, m});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = current[0] + dx[i];
                int y = current[1] + dy[i];

                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (map[x][y] == 0) {
                        map[x][y] = map[current[0]][current[1]] + 1;
                        queue.offer(new int[] {x, y});
                    }
                }
            }
        }

        int result = 0;
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (map[n][m] == 0) {
                    System.out.println("-1");
                    return;
                }

                result = Math.max(result, map[n][m]);
            }
        }

        System.out.println(result - 1);
    }
}
