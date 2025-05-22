package com.mark.codingtest.programmers;

public class P택배상자꺼내기 {

    public static void main(String[] args) {
        System.out.println(solution(22, 6, 8));
        System.out.println(solution(13, 3, 6));
    }

    private static int solution(int n, int w, int num) {
        int height = (n + w - 1) / w;
        int[][] boxes = new int[height][w];

        int value = 1;
        for (int row = height - 1; row >= 0; row--) {
            if ((height - 1 - row) % 2 == 0) {
                for (int col = 0; col < w && value <= n; col++) {
                    boxes[row][col] = value++;
                }
            } else {
                for (int col = w - 1; col >= 0 && value <= n; col--) {
                    boxes[row][col] = value++;
                }
            }
        }

        int targetRow = -1;
        int targetCol = -1;

        outer:
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < w; col++) {
                if (boxes[row][col] == num) {
                    targetRow = row;
                    targetCol = col;
                    break outer;
                }
            }
        }

        int count = 0;
        for (int row = 0; row <= targetRow; row++) {
            if (boxes[row][targetCol] != 0) {
                count++;
            }
        }

        return count;
    }
}
