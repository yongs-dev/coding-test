package com.mark.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * <pre>
 * 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
 *
 *
 * 입력
 * 첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
 *
 * 출력
 * 첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
 *
 * 예제 입력 1
 * 7
 * 0110100
 * 0110101
 * 1110101
 * 0000111
 * 0100000
 * 0111110
 * 0111000
 * 예제 출력 1
 * 3
 * 7
 * 8
 * 9
 * </pre>
 */
public class B2667_단지번호붙이기 {
    static int N;
    static boolean[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new boolean[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < N; j++) {
                graph[i][j] = input.charAt(j) == '1';
            }
        }

        List<Integer> complexCounts = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] && !visited[i][j]) {
                    complexCounts.add(bfs(i, j));
                }
            }
        }

        System.out.println(complexCounts.size());
        Collections.sort(complexCounts);
        for (int i : complexCounts) {
            System.out.println(i);
        }
    }

    private static int bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int k = 0; k < 4; k++) {
                int x = current[0] + dx[k];
                int y = current[1] + dy[k];

                if (x >= 0 && x < N && y >= 0 && y < N) {
                    if (!visited[x][y] && graph[x][y]) {
                        visited[x][y] = true;
                        queue.add(new int[]{x, y});
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
