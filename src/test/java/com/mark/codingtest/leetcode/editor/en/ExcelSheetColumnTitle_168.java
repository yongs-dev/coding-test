package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//Given an integer columnNumber, return its corresponding column title as it 
//appears in an Excel sheet. 
//
// For example: 
//
// 
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28 
//...
// 
//
// 
// Example 1: 
//
// 
//Input: columnNumber = 1
//Output: "A"
// 
//
// Example 2: 
//
// 
//Input: columnNumber = 28
//Output: "AB"
// 
//
// Example 3: 
//
// 
//Input: columnNumber = 701
//Output: "ZY"
// 
//
// 
// Constraints: 
//
// 
// 1 <= columnNumber <= 2³¹ - 1 
// 
//
// Related Topics Math String 👍 5546 👎 810


@Slf4j
public class ExcelSheetColumnTitle_168 {

    @Test
    void test() {
//        log.info("result: {}", new Solution().convertToTitle(1));
//        log.info("result: {}", new Solution().convertToTitle(28));
        log.info("result: {}", new Solution().convertToTitle(701));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToTitle(int columnNumber) {
            StringBuilder columnTitle = new StringBuilder();

            while (columnNumber > 0) {
                columnNumber--;  // Adjust for 1-based index
                int remainder = columnNumber % 26;
                columnTitle.append((char) (remainder + 'A'));
                columnNumber /= 26;
            }

            return columnTitle.reverse().toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}