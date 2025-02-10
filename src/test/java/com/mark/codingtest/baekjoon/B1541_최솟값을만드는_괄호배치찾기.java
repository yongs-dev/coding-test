package com.mark.codingtest.baekjoon;

import java.util.Scanner;

/**
 * <b>그리디 (Greedy)</b>
 * <pre>
 *  input:
 *  100-40+50+74-30+29-45+43+11
 *
 *  output:
 *  -222
 * </pre>
 */
public class B1541_최솟값을만드는_괄호배치찾기 {

    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] A = input.split("-");
        for (int i = 0; i < A.length; i++) {
            int temp = sum(A[i]);

            if (i == 0) {
                result += temp;
            } else {
                result -= temp;
            }
        }

        System.out.println(result);
    }

    private static int sum(String str) {
        int sum = 0;
        String[] array = str.split("[+]");

        for (String s : array) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }
}
