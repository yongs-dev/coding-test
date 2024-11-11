package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be 
//validated according to the following rules: 
//
// 
// Each row must contain the digits 1-9 without repetition. 
// Each column must contain the digits 1-9 without repetition. 
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 
//without repetition. 
// 
//
// Note: 
//
// 
// A Sudoku board (partially filled) could be valid but is not necessarily 
//solvable. 
// Only the filled cells need to be validated according to the mentioned rules. 
//
// 
//
// 
// Example 1: 
// 
// 
//Input: board = 
//[["5","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//Output: true
//
//
// Example 2:
//
//
//Input: board =
//[["8","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//Output: false
//Explanation: Same as Example 1, except with the 5 in the top left corner
//being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is
//invalid.
//
//
//
// Constraints:
//
//
// board.length == 9
// board[i].length == 9
// board[i][j] is a digit 1-9 or '.'.
//
//
// Related Topics Array Hash Table Matrix 👍 10946 👎 1154


@Slf4j
public class ValidSudoku_36 {

    @Test
    void test() {
//        log.info("result: {}", new Solution().isValidSudoku(new char[][] {
//                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        }));

        log.info("result: {}", new Solution().isValidSudoku(new char[][] {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        }));
    }

    // 00 ~ 22, 30 ~ 52, 60 ~ 82
    // 03 ~ 25, 33 ~ 55, 63 ~ 85
    // 06 ~ 28, 36 ~ 38, 66 ~ 88

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            // 행, 열, 3x3 박스를 위한 셋 배열
            Set<String> seen = new HashSet<>();

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char current = board[i][j];

                    if (current != '.') {
                        // 같은 숫자가 행, 열, 박스에 있는지 확인
                        if (!seen.add(current + " in row " + i) ||
                                !seen.add(current + " in column " + j) ||
                                !seen.add(current + " in box " + (i / 3) + "-" + (j / 3))) {
                            return false; // 중복된 숫자가 발견된 경우e
                        }
                    }
                }
            }
            return true; // 중복이 없으면 유효한 스도쿠
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}