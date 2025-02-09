package com.mark.codingtest.baekjoon;

import java.util.*;

/**
 * <b>위상 정렬(Topology Sort)</b>
 * <p>사이클이 없는 방향 그래프에서 노드 순서를 찾는 알고리즘. 항상 결과가 동일하지 않다.</p>
 *
 * <pre>
 * 입력:
 * 4 2  노드 개수, 엣지 개수
 * 4 2
 * 3 1
 *
 * 출력:
 * 4 2 3 1
 *
 * 입력:
 * 3 2
 * 1 3
 * 2 3
 *
 * 출력:
 * 1 2 3
 * </pre>
 */
public class B2252_줄세우기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<List<Integer>> A = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
        }

        int[] inDegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            A.get(S).add(E);
            inDegree[E]++;  // 진입 차수 배열 데이터 저장
        }

        // 위상 정렬
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");

            for (int next : A.get(now)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }
}
