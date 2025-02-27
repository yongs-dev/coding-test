package com.mark.codingtest.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * <pre>
 * 문제
 * 수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
 *
 * Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수와 같아야 한다.
 *
 * X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.
 *
 * 입력
 * 첫째 줄에 N이 주어진다.
 *
 * 둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.
 *
 * 출력
 * 첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.
 *
 * 제한
 * 1 ≤ N ≤ 1,000,000
 * -109 ≤ Xi ≤ 109
 * 예제 입력 1
 * 5
 * 2 4 -10 4 -9
 * 예제 출력 1
 * 2 3 0 3 1
 * 예제 입력 2
 * 6
 * 1000 999 1000 999 1000 999
 * 예제 출력 2
 * 1 0 1 0 1 0
 * </pre>
 */
public class B18870_좌표압축 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] S = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = S[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(S);

        int rank = 0;
        Map<Integer, Integer> compressedMap = new HashMap<>();
        for (int num : S) {
            if (!compressedMap.containsKey(num)) {
                compressedMap.put(num, rank++);
            }
        }

        for (int num : A) {
            bw.write(compressedMap.get(num) + " ");
        }

        bw.close();
    }
}
