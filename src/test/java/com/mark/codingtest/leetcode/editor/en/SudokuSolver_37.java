package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//Write a program to solve a Sudoku puzzle by filling the empty cells. 
//
// A sudoku solution must satisfy all of the following rules: 
//
// 
// Each of the digits 1-9 must occur exactly once in each row. 
// Each of the digits 1-9 must occur exactly once in each column. 
// Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-
//boxes of the grid. 
// 
//
// The '.' character indicates empty cells. 
//
// 
// Example 1: 
// 
// 
//Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5
//",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".
//",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".
//","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5
//"],[".",".",".",".","8",".",".","7","9"]]
//Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4
//","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3
//"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],[
//"9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3",
//"4","5","2","8","6","1","7","9"]]
//Explanation: The input board is shown above and the only valid solution is 
//shown below:
// 
//
//
//
// 
// Constraints: 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] is a digit or '.'. 
// It is guaranteed that the input board has only one solution. 
// 
//
// Related Topics Array Hash Table Backtracking Matrix 👍 9711 👎 273


@Slf4j
public class SudokuSolver_37 {

    @Test
    void test() {
        new Solution().solveSudoku(new char[][] {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        });
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solveSudoku(char[][] board) {
            solve(board);
        }

        private boolean solve(char[][] board) {
            // 스도쿠 보드를 순회하며 빈 칸 ('.') 찾기
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    if (board[row][col] == '.') { // 빈 칸 발견
                        // 1부터 9까지의 숫자를 넣어본다
                        for (char num = '1'; num <= '9'; num++) {
                            if (isValid(board, row, col, num)) {
                                board[row][col] = num; // 숫자를 넣어본다

                                // 재귀적으로 다음 빈 칸을 해결
                                if (solve(board)) {
                                    return true; // 해결된 경우
                                } else {
                                    board[row][col] = '.'; // 실패 시 다시 빈 칸으로 복구
                                }
                            }
                        }
                        return false; // 어떤 숫자도 넣을 수 없는 경우
                    }
                }
            }
            return true; // 모든 빈 칸이 해결된 경우
        }

        // 숫자가 해당 위치에 유효한지 확인하는 메소드
        private boolean isValid(char[][] board, int row, int col, char num) {
            // 행과 열에서 중복 확인
            for (int i = 0; i < 9; i++) {
                if (board[row][i] == num || board[i][col] == num) {
                    return false;
                }
            }

            // 3x3 박스에서 중복 확인
            int boxRowStart = (row / 3) * 3;
            int boxColStart = (col / 3) * 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[boxRowStart + i][boxColStart + j] == num) {
                        return false;
                    }
                }
            }

            return true; // 중복이 없는 경우
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}