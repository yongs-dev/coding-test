package com.mark.codingtest.baekjoon;

import java.util.*;
import java.io.*;

/**
 * <pre>
 * 문제
 * 한가롭게 방학에 놀고 있던 도현이는 갑자기 재밌는 자료구조를 생각해냈다. 그 자료구조의 이름은 queuestack이다.
 *
 * queuestack의 구조는 다음과 같다.
 * 1번,
 * 2번, ... ,
 * N번의 자료구조(queue 혹은 stack)가 나열되어있으며, 각각의 자료구조에는 한 개의 원소가 들어있다.
 *
 * queuestack의 작동은 다음과 같다.
 * 
 *
 * x_0을 입력받는다.
 * x_0을 1번 자료구조에 삽입한 뒤 1번 자료구조에서 원소를 pop한다. 그때 pop된 원소를 x_1이라 한다.
 * x_1을 2번 자료구조에 삽입한 뒤 2번 자료구조에서 원소를 pop한다. 그때 pop된 원소를 x_2이라 한다.
 * x_{N-1}을 N번 자료구조에 삽입한 뒤 N번 자료구조에서 원소를 pop한다. 그때 pop된 원소를 x_N이라 한다.
 * x_N을 리턴한다.
 * 
 * 도현이는 길이 M의 수열 C를 가져와서 수열의 원소를 앞에서부터 차례대로 queuestack에 삽입할 것이다. 이전에 삽입한 결과는 남아 있다. (예제 1 참고)
 *
 * queuestack에 넣을 원소들이 주어졌을 때, 해당 원소를 넣은 리턴값을 출력하는 프로그램을 작성해보자.
 *
 * 입력
 * 첫째 줄에 queuestack을 구성하는 자료구조의 개수 N이 주어진다. (1 <= N <= 100,000)
 * 둘째 줄에 길이 N의 수열 A가 주어진다. i번 자료구조가 큐라면 A_i = 0, 스택이라면  A_i = 1이다.
 * 셋째 줄에 길이 N의 수열 B가 주어진다. B_i는 i번 자료구조에 들어 있는 원소이다. (1 <= B_i <= 1,000,000,000)
 * 넷째 줄에 삽입할 수열의 길이 M이 주어진다. (1 <= M <= 100,000)
 * 다섯째 줄에 queuestack에 삽입할 원소를 담고 있는 길이 M의 수열 C가 주어진다. (1 <= C_i <= 1,000,000,000)
 *
 * 입력으로 주어지는 모든 수는 정수이다.
 *
 * 출력
 * 수열 
 * C의 원소를 차례대로 queuestack에 삽입했을 때의 리턴값을 공백으로 구분하여 출력한다.
 *
 * 예제 입력 1 
 * 4
 * 0 1 1 0
 * 1 2 3 4
 * 3
 * 2 4 7
 *
 * 예제 출력 1 
 * 4 1 2
 *
 * 각 상태에 대한 큐스택 내부를 표현하면 다음과 같다.
 * 초기 상태 : [1, 2, 3, 4]
 * 첫 번째 원소 삽입 : [2, 2, 3, 1]
 * 두 번째 원소 삽입 : [4, 2, 3, 2]
 * 세 번째 원소 삽입 : [7, 2, 3, 4]
 *
 * 예제 입력 2 
 * 5
 * 1 1 1 1 1
 * 1 2 3 4 5
 * 3
 * 1 3 5
 *
 * 예제 출력 2 
 * 1 3 5
 * </pre>
 */
public class B24511_queuestack {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        Deque<Integer> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (A[i] == 0) deque.addLast(num);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            deque.addFirst(Integer.parseInt(st.nextToken()));
            bw.write(deque.pollLast() + " ");
        }

        bw.close();
    }
}
