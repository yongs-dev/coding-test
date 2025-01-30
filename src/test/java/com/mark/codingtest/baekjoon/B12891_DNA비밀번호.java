package com.mark.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <b>Sliding Window</b><br>
 * 2개의 포인터로 범위(Window)를 유지한 채 이동(Slide)하며 문제를 해결
 */
public class B12891_DNA비밀번호 {

    static int[] checkArray = new int[4];
    static int[] myArray = new int[4];
    static int checkSecret = 0;

    /**
     * 4 2
     * GATA
     * 1 0 0 1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int result = 0;
        char[] A = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArray[i] = Integer.parseInt(st.nextToken());

            if (checkArray[i] == 0) {
                checkSecret++;
            }
        }

        for (int i = 0; i < P; i++) {
            add(A[i]);
        }

        for (int i = P; i < S; i++) {
            int j = i - P;
            add(A[i]);
            remove(A[j]);
            if (checkSecret == 4) result++;
        }

        System.out.printf("result: %d", result);
    }

    private static void add(char c) {
        switch (c) {
            case 'A':
                myArray[0]++;
                if (myArray[0] == checkArray[0]) checkSecret++;
                break;
            case 'C':
                myArray[1]++;
                if (myArray[1] == checkArray[1]) checkSecret++;
                break;
            case 'G':
                myArray[2]++;
                if (myArray[2] == checkArray[2]) checkSecret++;
                break;
            case 'T':
                myArray[3]++;
                if (myArray[3] == checkArray[3]) checkSecret++;
                break;
        }
    }

    private static void remove(char c) {
        switch (c) {
            case 'A':
                if (myArray[0] == checkArray[0]) checkSecret--;
                myArray[0]--;
                break;
            case 'C':
                if (myArray[1] == checkArray[1]) checkSecret--;
                myArray[1]--;
                break;
            case 'G':
                if (myArray[2] == checkArray[2]) checkSecret--;
                myArray[2]--;
                break;
            case 'T':
                if (myArray[3] == checkArray[3]) checkSecret--;
                myArray[3]--;
                break;
        }
    }
}
