package com.mark.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * 문제
 * N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다. 최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.
 *
 * 만약에 이동하는 도중에 한 개의 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 한 개 까지 부수고 이동하여도 된다.
 *
 * 한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸이다.
 *
 * 맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)이 주어진다. 다음 N개의 줄에 M개의 숫자로 맵이 주어진다. (1, 1)과 (N, M)은 항상 0이라고 가정하자.
 *
 * 출력
 * 첫째 줄에 최단 거리를 출력한다. 불가능할 때는 -1을 출력한다.
 *
 * 예제 입력 1
 * 6 4
 * 0100
 * 1110
 * 1000
 * 0000
 * 0111
 * 0000
 * 예제 출력 1
 * 15
 * 예제 입력 2
 * 4 4
 * 0111
 * 1111
 * 1111
 * 1110
 * 예제 출력 2
 * -1
 * </pre>
 */
@SuppressWarnings("unused")
// @see https://www.acmicpc.net/problem/2206
public class B2206_벽부수고이동하기 {
    static int N, M;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] NM = input.split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1][2];

        for (int i = 1; i <= N; i++) {
            input = br.readLine();

            for (int j = 1; j <= M; j++) {
                map[i][j] = input.charAt(j - 1) - '0';
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {1, 1, 1, 0});
        visited[1][1][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            int broken = current[3];

            if (x == N && y == M) return distance;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || ny < 1 || nx > N || ny > M) continue;

                // 벽이 아닌 경우
                if (map[nx][ny] == 0 && !visited[nx][ny][broken]) {
                    visited[nx][ny][broken] = true;
                    queue.offer(new int[] {nx, ny, distance + 1, broken});
                }

                // 벽인데 아직 안 부쉈을 경우
                if (map[nx][ny] == 1 && broken == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    queue.offer(new int[]{nx, ny, distance + 1, 1});
                }
            }
        }

        return -1;
    }
}
