package com.mark.codingtest.programmers;

public class P완전범죄 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 2}, {2, 3}, {2, 1}}, 4, 4)); // 2
        System.out.println(solution(new int[][]{{1, 2}, {2, 3}, {2, 1}}, 1, 7)); // 0
        System.out.println(solution(new int[][]{{3, 3}, {3, 3}}, 7, 1));         // 6
        System.out.println(solution(new int[][]{{3, 3}, {3, 3}}, 6, 1));         // -1
    }

    private static int solution(int[][] info, int n, int m) {
        boolean[][] dp = new boolean[n][m];
        dp[0][0] = true;

        for (int[] item : info) {
            int aTrace = item[0];
            int bTrace = item[1];

            boolean[][] nextDp = new boolean[n][m];

            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if (!dp[a][b]) continue;

                    if (a + aTrace < n) {
                        nextDp[a + aTrace][b] = true;
                    }

                    if (b + bTrace < m) {
                        nextDp[a][b + bTrace] = true;
                    }
                }
            }

            dp = nextDp;
        }

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                if (dp[a][b]) return a;
            }
        }

        return -1;
    }
}
