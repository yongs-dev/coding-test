package com.mark.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * <b>DFS (Depth First-Search)</b><br>
 *
 * <p>예시 입력/출력:</p>
 * <pre>
 * 입력:
 * 6 5
 * 1 2
 * 2 5
 * 5 1
 * 3 4
 *
 * 출력:
 * 2
 * </pre>
 */
public class B11724_연결요소의_개수구하기 {
    static boolean[] visited;
    static List<Integer>[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        A = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            A[end].add(start);
        }

        int count = 0;
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }

        System.out.printf("count = %d", count);
    }

    private static void dfs(int v) {
        if (visited[v]) return;

        visited[v] = true;
        for (int i : A[v]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}
