package com.mark.codingtest.programmers;

public class P서버증설횟수 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5}, 3, 5));
        System.out.println(solution(new int[]{0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0}, 5, 1));
        System.out.println(solution(new int[]{0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1}, 1, 1));
    }

    private static int solution(int[] players, int m, int k) {
        int ans = 0;
        int active = 0;
        int[] install = new int[24];

        for (int i = 0; i < 24; i++) {
            if (i >= k) {
                active -= install[i - k];
            }

            int req = players[i] / m;
            if (active < req) {
                int add = req - active;
                ans += add;
                active += add;
                install[i] = add;
            }
        }

        return ans;
    }
}
