package com.mark.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <pre>
 * 문제
 * 세계적인 도둑 상덕이는 보석점을 털기로 결심했다.
 *
 * 상덕이가 털 보석점에는 보석이 총 N개 있다. 각 보석은 무게 Mi와 가격 Vi를 가지고 있다. 상덕이는 가방을 K개 가지고 있고, 각 가방에 담을 수 있는 최대 무게는 Ci이다. 가방에는 최대 한 개의 보석만 넣을 수 있다.
 *
 * 상덕이가 훔칠 수 있는 보석의 최대 가격을 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N과 K가 주어진다. (1 ≤ N, K ≤ 300,000)
 *
 * 다음 N개 줄에는 각 보석의 정보 Mi와 Vi가 주어진다. (0 ≤ Mi, Vi ≤ 1,000,000)
 *
 * 다음 K개 줄에는 가방에 담을 수 있는 최대 무게 Ci가 주어진다. (1 ≤ Ci ≤ 100,000,000)
 *
 * 모든 숫자는 양의 정수이다.
 *
 * 출력
 * 첫째 줄에 상덕이가 훔칠 수 있는 보석 가격의 합의 최댓값을 출력한다.
 *
 * 예제 입력 1
 * 2 1
 * 5 10
 * 100 100
 * 11
 * 예제 출력 1
 * 10
 * 예제 입력 2
 * 3 2
 * 1 65
 * 5 23
 * 2 99
 * 10
 * 2
 * 예제 출력 2
 * 164
 * </pre>
 */
public class B1202_보석도둑 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] bags = new int[K];
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int[] A = new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])};
            queue.offer(A);
        }

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);

        PriorityQueue<Integer> candidates = new PriorityQueue<>(Comparator.reverseOrder());

        long total = 0;
        for (int bag : bags) {
            while (!queue.isEmpty() && queue.peek()[0] <= bag) {
                candidates.offer(queue.poll()[1]);
            }

            if (!candidates.isEmpty()) {
                total += candidates.poll();
            }
        }

        System.out.println(total);
    }
}
