package com.mark.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * <pre>
 * 문제
 * 크기가 N인 수열 A = A1, A2, ..., AN이 있다. 수열의 각 원소 Ai에 대해서 오등큰수 NGF(i)를 구하려고 한다.
 *
 * Ai가 수열 A에서 등장한 횟수를 F(Ai)라고 했을 때, Ai의 오등큰수는 오른쪽에 있으면서 수열 A에서 등장한 횟수가 F(Ai)보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다. 그러한 수가 없는 경우에 오등큰수는 -1이다.
 *
 * 예를 들어, A = [1, 1, 2, 3, 4, 2, 1]인 경우 F(1) = 3, F(2) = 2, F(3) = 1, F(4) = 1이다. A1의 오른쪽에 있으면서 등장한 횟수가 3보다 큰 수는 없기 때문에, NGF(1) = -1이다. A3의 경우에는 A7이 오른쪽에 있으면서 F(A3=2) < F(A7=1) 이기 때문에, NGF(3) = 1이다. NGF(4) = 2, NGF(5) = 2, NGF(6) = 1 이다.
 *
 * 입력
 * 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째에 수열 A의 원소 A1, A2, ..., AN (1 ≤ Ai ≤ 1,000,000)이 주어진다.
 *
 * 출력
 * 총 N개의 수 NGF(1), NGF(2), ..., NGF(N)을 공백으로 구분해 출력한다.
 *
 * 예제 입력 1
 * 7
 * 1 1 2 3 4 2 1
 * 예제 출력 1
 * -1 -1 1 2 2 1 -1
 * </pre>
 */
public class B17299_오등큰수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] result = new int[N];
        Map<Integer, Integer> freqMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            freqMap.put(A[i], freqMap.getOrDefault(A[i], 0) + 1); // 빈도 저장
        }

        Stack<Integer> stack = new Stack<>(); // 인덱스 저장용

        for (int i = N - 1; i >= 0; i--) {
            // 현재 수의 빈도
            int currFreq = freqMap.get(A[i]);

            // 스택의 top이 나보다 빈도수가 작거나 같으면 pop
            while (!stack.isEmpty() && freqMap.get(A[stack.peek()]) <= currFreq) {
                stack.pop();
            }

            // 스택이 비었다면 -1, 아니면 해당 인덱스의 수가 오등큰수
            result[i] = stack.isEmpty() ? -1 : A[stack.peek()];

            // 현재 인덱스를 스택에 push
            stack.push(i);
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int n : result) {
            sb.append(n).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
