package com.mark.codingtest.baekjoon;

import java.util.Scanner;

/**
 * <pre>
 * 문제
 * LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.
 *
 * 예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.
 *
 * 입력
 * 첫째 줄과 둘째 줄에 두 문자열이 주어진다. 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.
 *
 * 출력
 * 첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를 출력한다.
 *
 * 예제 입력 1
 * ACAYKP
 * CAPCAK
 * 예제 출력 1
 * 4
 * </pre>
 */
public class B9251_LCS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();
        int[][] dp = new int[A.length() + 1][B.length() + 1];

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[A.length()][B.length()]);
    }
}
