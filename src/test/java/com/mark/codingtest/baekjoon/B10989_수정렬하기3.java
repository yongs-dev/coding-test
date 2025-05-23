package com.mark.codingtest.baekjoon;

import java.io.*;

/**
 * <pre>
 * 문제
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
 *
 * 출력
 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 *
 * 예제 입력 1
 * 10
 * 5
 * 2
 * 3
 * 1
 * 4
 * 2
 * 3
 * 5
 * 1
 * 7
 * 예제 출력 1
 * 1
 * 1
 * 2
 * 2
 * 3
 * 3
 * 4
 * 5
 * 5
 * 7
 * </pre>
 */
public class B10989_수정렬하기3 {

    /**
     * <b>계수 정렬(Counting Sort). O(N)</b><br>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 값의 범위가 1~10,000이므로 10001 크기의 배열 생성
        int[] count = new int[10001];

        // 입력값 개수를 배열에 저장 (Counting Sort)
        for (int i = 0; i < N; i++) {
            count[Integer.parseInt(br.readLine())]++;
        }

        // 정렬된 결과 출력
        for (int i = 1; i <= 10000; i++) {
            while (count[i]-- > 0) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
