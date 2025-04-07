package com.mark.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <pre>
 * 문제
 * N×N의 표에 수 N^2개 채워져 있다. 채워진 수에는 한 가지 특징이 있는데, 모든 수는 자신의 한 칸 위에 있는 수보다 크다는 것이다. N=5일 때의 예를 보자.
 *
 * 12	7	9	15	5
 * 13	8	11	19	6
 * 21	10	26	31	16
 * 48	14	28	35	25
 * 52	20	32	41	49
 * 이러한 표가 주어졌을 때, N번째 큰 수를 찾는 프로그램을 작성하시오. 표에 채워진 수는 모두 다르다.
 *
 * 입력
 * 첫째 줄에 N(1 ≤ N ≤ 1,500)이 주어진다. 다음 N개의 줄에는 각 줄마다 N개의 수가 주어진다. 표에 적힌 수는 -10억보다 크거나 같고, 10억보다 작거나 같은 정수이다.
 *
 * 출력
 * 첫째 줄에 N번째 큰 수를 출력한다.
 *
 * 예제 입력 1
 * 5
 * 12 7 9 15 5
 * 13 8 11 19 6
 * 21 10 26 31 16
 * 48 14 28 35 25
 * 52 20 32 41 49
 * 예제 출력 1
 * 35
 * </pre>
 */
public class B2075_N번째큰수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            for (String s : br.readLine().split(" ")) {
                queue.offer(Integer.parseInt(s));

                if (queue.size() > N) {
                    queue.poll();
                }
            }
        }

        System.out.println(queue.peek());
    }
}
