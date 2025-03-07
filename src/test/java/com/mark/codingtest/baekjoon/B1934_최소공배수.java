package com.mark.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <pre>
 * 문제
 * 두 자연수 A와 B에 대해서, A의 배수이면서 B의 배수인 자연수를 A와 B의 공배수라고 한다. 이런 공배수 중에서 가장 작은 수를 최소공배수라고 한다. 예를 들어, 6과 15의 공배수는 30, 60, 90등이 있으며, 최소 공배수는 30이다.
 *
 * 두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 둘째 줄부터 T개의 줄에 걸쳐서 A와 B가 주어진다. (1 ≤ A, B ≤ 45,000)
 *
 * 출력
 * 첫째 줄부터 T개의 줄에 A와 B의 최소공배수를 입력받은 순서대로 한 줄에 하나씩 출력한다.
 *
 * 예제 입력 1
 * 3
 * 1 45000
 * 6 10
 * 13 17
 *
 * 예제 출력 1
 * 45000
 * 30
 * 221
 * </pre>
 */
public class B1934_최소공배수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int gcd = gcd(a, b);
            int lcm = (a * b) / gcd;

            sb.append(lcm).append("\n");
        }

        System.out.println(sb);
    }

    /**
     * <b>유클리드 호제법(Euclidean Algorithm)</b><br>
     * gcd(a, b) = gcd(b, a % b)
     */
    private static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;  // 1. a를 b로 나눈 나머지 r을 구한다.
            a = b;          // 2. 이제 b가 새로운 a가 된다.
            b = r;          // 3. 나머지 r을 다시 b에 넣고 반복
        }

        return a;           // 4. b가 0이 될 때의 a가 GCD
    }
}
