package com.mark.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <b>Union & Find</b>
 *
 * <pre>
 * 입력:
 * 7 8      원소 개수, 질의 개수
 * 0 1 3
 * 1 1 7
 * 0 7 6
 * 1 7 1
 * 0 3 7
 * 0 4 2
 * 0 1 1
 * 1 1 1
 *
 * 출력:
 * NO
 * NO
 * YES
 * </pre>
 */
public class B1717_집합_표현하기 {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int query = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);

            if (query == 0) {
                union(a, b);
            } else {
                System.out.println(checkSame(a, b) ? "YES" : "NO");
            }
        }
    }

    private static void union(int a, int b) {
        // 대표 노드 찾아서
        a = find(a);
        b = find(b);

        // 다른 경우 연결
        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            int i = find(parent[a]);
            return parent[a] = i; // value를 index로 바꿔서 재탐색. ( + 경로 압축)
        }
    }

    private static boolean checkSame(int a, int b) {
        return find(a) == find(b);
    }
}
