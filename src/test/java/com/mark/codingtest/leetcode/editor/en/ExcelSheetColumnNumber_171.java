package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//Given a string columnTitle that represents the column title as appears in an 
//Excel sheet, return its corresponding column number. 
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
//Input: columnTitle = "A"
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: columnTitle = "AB"
//Output: 28
// 
//
// Example 3: 
//
// 
//Input: columnTitle = "ZY"
//Output: 701
// 
//
// 
// Constraints: 
//
// 
// 1 <= columnTitle.length <= 7 
// columnTitle consists only of uppercase English letters. 
// columnTitle is in the range ["A", "FXSHRXW"]. 
// 
//
// Related Topics Math String 👍 4764 👎 365


@Slf4j
public class ExcelSheetColumnNumber_171 {

    @Test
    void test() {
//        log.info("result: {}", new Solution().titleToNumber("A"));
//        log.info("result: {}", new Solution().titleToNumber("AB"));
        log.info("result: {}", new Solution().titleToNumber("ZY"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int titleToNumber(String columnTitle) {
            int result = 0;

            for (int i = 0; i < columnTitle.length(); i++) {
                result = result * 26 + columnTitle.charAt(i) - 'A' + 1;
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}