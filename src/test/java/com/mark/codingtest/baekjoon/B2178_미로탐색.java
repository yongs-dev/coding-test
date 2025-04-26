package com.mark.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * 문제
 * N×M크기의 배열로 표현되는 미로가 있다.
 *
 * 1	0	1	1	1	1
 * 1	0	1	0	1	0
 * 1	0	1	0	1	1
 * 1	1	1	0	1	1
 * 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
 *
 * 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
 *
 * 입력
 * 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
 *
 * 출력
 * 첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
 *
 * 예제 입력 1
 * 4 6
 * 101111
 * 101010
 * 101011
 * 111011
 * 예제 출력 1
 * 15
 * 예제 입력 2
 * 4 6
 * 110110
 * 110110
 * 111111
 * 111101
 * 예제 출력 2
 * 9
 * 예제 입력 3
 * 2 25
 * 1011101110111011101110111
 * 1110111011101110111011101
 * 예제 출력 3
 * 38
 * 예제 입력 4
 * 7 7
 * 1011111
 * 1110001
 * 1000001
 * 1000001
 * 1000001
 * 1000001
 * 1111111
 * 예제 출력 4
 * 13
 * </pre>
 */
public class B2178_미로탐색 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split("");

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        bfs();
        System.out.println(map[N - 1][M - 1]);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int k = 0; k < 4; k++) {
                int x = current[0] + dx[k];
                int y = current[1] + dy[k];

                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (map[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        map[x][y] = map[current[0]][current[1]] + 1;
                        queue.offer(new int[] {x, y});
                    }
                }
            }
        }
    }
}
