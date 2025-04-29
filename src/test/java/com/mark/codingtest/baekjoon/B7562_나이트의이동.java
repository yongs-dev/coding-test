package com.mark.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * 문제
 * 체스판 위에 한 나이트가 놓여져 있다. 나이트가 한 번에 이동할 수 있는 칸은 아래 그림에 나와있다. 나이트가 이동하려고 하는 칸이 주어진다. 나이트는 몇 번 움직이면 이 칸으로 이동할 수 있을까?
 *
 * 입력
 * 입력의 첫째 줄에는 테스트 케이스의 개수가 주어진다.
 *
 * 각 테스트 케이스는 세 줄로 이루어져 있다. 첫째 줄에는 체스판의 한 변의 길이 l(4 ≤ l ≤ 300)이 주어진다. 체스판의 크기는 l × l이다. 체스판의 각 칸은 두 수의 쌍 {0, ..., l-1} × {0, ..., l-1}로 나타낼 수 있다. 둘째 줄과 셋째 줄에는 나이트가 현재 있는 칸, 나이트가 이동하려고 하는 칸이 주어진다.
 *
 * 출력
 * 각 테스트 케이스마다 나이트가 최소 몇 번만에 이동할 수 있는지 출력한다.
 *
 * 예제 입력 1
 * 3
 * 8
 * 0 0
 * 7 0
 * 100
 * 0 0
 * 30 50
 * 10
 * 1 1
 * 1 1
 * 예제 출력 1
 * 5
 * 28
 * 0
 * </pre>
 */
public class B7562_나이트의이동 {

    static int l;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            l = Integer.parseInt(br.readLine());
            map = new int[l][l];
            visited = new int[l][l];

            String[] input = br.readLine().split(" ");
            int[] knight = new int[] {Integer.parseInt(input[0]), Integer.parseInt(input[1])};

            input = br.readLine().split(" ");
            int[] destination = new int[] {Integer.parseInt(input[0]), Integer.parseInt(input[1])};

            bfs(knight, destination);
        }
    }

    private static void bfs(int[] knight, int[] destination) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(knight);
        visited[knight[0]][knight[1]] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[0] == destination[0] && current[1] == destination[1]) {
                System.out.println(visited[current[0]][current[1]] - 1);
                return;
            }

            for (int i = 0; i < 8; i++) {
                int x = current[0] + dx[i];
                int y = current[1] + dy[i];

                if (x >= 0 && y >= 0 && x < l && y < l) {
                    if (visited[x][y] == 0) {
                        visited[x][y] = visited[current[0]][current[1]] + 1;
                        queue.offer(new int[] {x, y});
                    }
                }
            }
        }
    }
}
