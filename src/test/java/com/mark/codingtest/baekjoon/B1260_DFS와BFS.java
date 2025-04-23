package com.mark.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * <pre>
 * 문제
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
 *
 * 입력
 * 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
 *
 * 출력
 * 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
 *
 * 예제 입력 1
 * 4 5 1
 * 1 2
 * 1 3
 * 1 4
 * 2 4
 * 3 4
 * 예제 출력 1
 * 1 2 4 3
 * 1 2 3 4
 * 예제 입력 2
 * 5 5 3
 * 5 4
 * 5 2
 * 1 2
 * 3 4
 * 3 1
 * 예제 출력 2
 * 3 1 2 5 4
 * 3 1 4 2 5
 * 예제 입력 3
 * 1000 1 1000
 * 999 1000
 * 예제 출력 3
 * 1000 999
 * 1000 999
 * </pre>
 */
public class B1260_DFS와BFS {

    static List<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int V = Integer.parseInt(input[2]);

        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            graph[start].add(end);
            graph[end].add(start);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N + 1];
        dfs(V);

        sb.append("\n");

        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }

    private static void dfs(int vertex) {
        if (visited[vertex]) return;

        visited[vertex] = true;
        sb.append(vertex).append(" ");

        for (int neighbor : graph[vertex]) {
            dfs(neighbor);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();

            if (!visited[vertex]) {
                visited[vertex] = true;
                sb.append(vertex).append(" ");

                for (int neighbor : graph[vertex]) {
                    queue.offer(neighbor);
                }
            }
        }
    }
}
