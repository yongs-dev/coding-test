package com.mark.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * <pre>
 * 문제
 * 정수를 저장하는 덱을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 *
 * 명령은 총 여덟 가지이다.
 *
 * 1 X: 정수 X를 덱의 앞에 넣는다. (1 ≤ X ≤ 100,000)
 * 2 X: 정수 X를 덱의 뒤에 넣는다. (1 ≤ X ≤ 100,000)
 * 3: 덱에 정수가 있다면 맨 앞의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
 * 4: 덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
 * 5: 덱에 들어있는 정수의 개수를 출력한다.
 * 6: 덱이 비어있으면 1, 아니면 0을 출력한다.
 * 7: 덱에 정수가 있다면 맨 앞의 정수를 출력한다. 없다면 -1을 대신 출력한다.
 * 8: 덱에 정수가 있다면 맨 뒤의 정수를 출력한다. 없다면 -1을 대신 출력한다.
 * 입력
 * 첫째 줄에 명령의 수 N이 주어진다. (1 ≤ N ≤ 1,000,000)
 *
 * 둘째 줄부터 N개 줄에 명령이 하나씩 주어진다.
 *
 * 출력을 요구하는 명령은 하나 이상 주어진다.
 *
 * 출력
 * 출력을 요구하는 명령이 주어질 때마다 명령의 결과를 한 줄에 하나씩 출력한다.
 *
 * 예제 입력 1
 * 11
 * 6
 * 1 3
 * 1 8
 * 7
 * 8
 * 3
 * 2 5
 * 1 2
 * 5
 * 4
 * 4
 *
 * 예제 출력 1
 * 1
 * 8
 * 3
 * 8
 * 3
 * 5
 * 3
 * </pre>
 */
public class B28279_덱2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            String Q = input[0];

            switch (Q) {
                case "1":
                    deque.addFirst(Integer.parseInt(input[1])); break;
                case "2":
                    deque.addLast(Integer.parseInt(input[1])); break;
                case "3":
                    sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n"); break;
                case "4":
                    sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n"); break;
                case "5":
                    sb.append(deque.size()).append("\n"); break;
                case "6":
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n"); break;
                case "7":
                    sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n"); break;
                case "8":
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n"); break;
            }
        }

        System.out.println(sb);
    }
}
