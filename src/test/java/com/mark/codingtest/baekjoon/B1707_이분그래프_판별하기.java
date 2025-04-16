package com.mark.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 문제
 * 그래프의 정점의 집합을 둘로 분할하여, 각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때, 그러한 그래프를 특별히 이분 그래프 (Bipartite Graph) 라 부른다.
 *
 * 그래프가 입력으로 주어졌을 때, 이 그래프가 이분 그래프인지 아닌지 판별하는 프로그램을 작성하시오.
 *
 * 입력
 * 입력은 여러 개의 테스트 케이스로 구성되어 있는데, 첫째 줄에 테스트 케이스의 개수 K가 주어진다. 각 테스트 케이스의 첫째 줄에는 그래프의 정점의 개수 V와 간선의 개수 E가 빈 칸을 사이에 두고 순서대로 주어진다. 각 정점에는 1부터 V까지 차례로 번호가 붙어 있다. 이어서 둘째 줄부터 E개의 줄에 걸쳐 간선에 대한 정보가 주어지는데, 각 줄에 인접한 두 정점의 번호 u, v (u ≠ v)가 빈 칸을 사이에 두고 주어진다.
 *
 * 출력
 * K개의 줄에 걸쳐 입력으로 주어진 그래프가 이분 그래프이면 YES, 아니면 NO를 순서대로 출력한다.
 *
 * 제한
 * 2 ≤ K ≤ 5
 * 1 ≤ V ≤ 20,000
 * 1 ≤ E ≤ 200,000
 * 예제 입력 1
 * 2
 * 3 2
 * 1 3
 * 2 3
 * 4 4
 * 1 2
 * 2 3
 * 3 4
 * 4 2
 * 예제 출력 1
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
