package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number 
//of rows like this: (you may want to display this pattern in a fixed font for 
//better legibility) 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R
// 
//
// And then read line by line: "PAHNAPLSIIGYIR" 
//
// Write the code that will take a string and make this conversion given a 
//number of rows: 
//
// 
//string convert(string s, int numRows);
// 
//
// 
// Example 1: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
// 
//
// Example 2: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// Example 3: 
//
// 
//Input: s = "A", numRows = 1
//Output: "A"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of English letters (lower-case and upper-case), ',' and '.'. 
// 1 <= numRows <= 1000 
// 
//
// Related Topics String 👍 7849 👎 14855


@Slf4j
public class ZigzagConversion_6 {

    @Test
    void test() {
        log.info("result: {}", new Solution().convert("PAYPALISHIRING", 3));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            // 특수 경우 처리: 행이 1인 경우, 입력 문자열 그대로 반환
            if (numRows == 1 || numRows >= s.length()) {
                return s;
            }

            // 각 행에 해당하는 StringBuilder 배열 생성
            StringBuilder[] rows = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++) {
                rows[i] = new StringBuilder();
            }

            int currentRow = 0; // 현재 행 인덱스
            boolean goingDown = false; // 방향 전환을 위한 플래그

            // 문자열의 각 문자를 해당 행에 추가
            for (char c : s.toCharArray()) {
                rows[currentRow].append(c);
                // 현재 행이 첫 행 또는 마지막 행에 도달하면 방향을 전환
                if (currentRow == 0 || currentRow == numRows - 1) {
                    goingDown = !goingDown;
                }
                // 방향에 따라 행 인덱스 조정
                currentRow += goingDown ? 1 : -1;
            }

            // 모든 행의 문자열을 합쳐 최종 결과 생성
            StringBuilder result = new StringBuilder();
            for (StringBuilder row : rows) {
                result.append(row);
            }

            return result.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}