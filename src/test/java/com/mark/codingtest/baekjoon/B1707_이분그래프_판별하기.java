package com.mark.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>이분 그래프(Bipartite Graph, DFS)</b>
 *
 * <pre>
 * 입력:
 * 2    테스트 케이스 개수
 * 3 2  노드 개수, 엣지 개수
 * 1 3
 * 2 3
 * 4 4
 * 1 2
 * 2 3
 * 3 4
 * 4 2
 *
 * 출력:
 * YES
 * NO
 * </pre>
 */
public class B1707_이분그래프_판별하기 {

    static List<Integer>[] A;
    static int[] check;
    static boolean[] visited;
    static boolean isEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            String[] input = br.readLine().split(" ");
            int V = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);

            A = new ArrayList[V + 1];
            check = new int[V + 1];
            visited = new boolean[V + 1];
            isEven = true;

            // 인접 리스트 각 ArrayList 초기화
            for (int i = 1; i < V + 1; i++) {
                A[i] = new ArrayList<>();
            }

            // Edge 데이터 저장
            for (int i = 0; i < E; i++) {
                input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                A[start].add(end);
                A[end].add(start);
            }

            // 모든 노드 DFS 실행
            for (int i = 1; i <= V; i++) {
                // 각 노드 DFS 실행 -> 결과가 이분 그래프 아니면 반복
                if (isEven) {
                    dfs(i);
                } else {
                    break;
                }
            }

            System.out.println(isEven ? "YES" : "NO");
        }
    }

    private static void dfs(int start) {
        visited[start] = true;

        // 인접 리스트로 받아서 start에 연결된 모든 노드를 탐색
        for (int node : A[start]) {
            if (!visited[node]) {
                // 바로 직전에 있는 노드와 다른 집합으로 분류 필요
                check[node] = (check[start] + 1) % 2;
                dfs(node);
            } else if (check[start] == check[node]) {
                isEven = false;
            }
        }
    }
}
