package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//Given an integer num, return a string of its base 7 representation. 
//
// 
// Example 1: 
// Input: num = 100
//Output: "202"
// 
// Example 2: 
// Input: num = -7
//Output: "-10"
// 
// 
// Constraints: 
//
// 
// -10⁷ <= num <= 10⁷ 
// 
//
// Related Topics Math 👍 808 👎 233


@Slf4j
public class Base7_504 {

    @Test
    void test() {
        log.info("result: {}", new Solution().convertToBase7(100));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToBase7(int num) {
            if (num == 0) return "0";

            StringBuilder result = new StringBuilder();
            boolean isNegative = num < 0;
            num = Math.abs(num);

            while (num > 0) {
                result.append(num % 7);
                num /= 7;
            }

            if (isNegative) {
                result.append('-');
            }

            return result.reverse().toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}