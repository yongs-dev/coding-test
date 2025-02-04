package com.mark.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * <b>Binary Search</b><br>
 * 정렬된 상태에서 원하는 수를 찾을 때 사용(O(NlogN))
 *
 * <p>예시 입출력</p>
 * <pre>
 * 입력:
 * 5
 * 4 1 5 2 3
 * 5
 * 1 3 7 9 3
 *
 * 출력:
 * 1
 * 1
 * 0
 * 0
 * 1
 * </pre>
 */
public class B1920_원하는_정수찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int[] T = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            T[i] = Integer.parseInt(st.nextToken());
        }

        for (int target : T) {
            int result = 0;
            int left = 0;
            int right = A.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (A[mid] > target) {
                    right = mid - 1;
                } else if (A[mid] < target) {
                    left = mid + 1;
                } else {
                    result = 1;
                    break;
                }
            }

            System.out.println(result);
        }
    }
}
