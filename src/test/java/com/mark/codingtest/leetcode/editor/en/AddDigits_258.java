package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//Given an integer num, repeatedly add all its digits until the result has only 
//one digit, and return it. 
//
// 
// Example 1: 
//
// 
//Input: num = 38
//Output: 2
//Explanation: The process is
//38 --> 3 + 8 --> 11
//11 --> 1 + 1 --> 2 
//Since 2 has only one digit, return it.
// 
//
// Example 2: 
//
// 
//Input: num = 0
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= num <= 2³¹ - 1 
// 
//
// 
// Follow up: Could you do it without any loop/recursion in O(1) runtime? 
//
// Related Topics Math Simulation Number Theory 👍 4837 👎 1936


@Slf4j
public class AddDigits_258 {

    @Test
    void test() {
        log.info("result: {}", new Solution().addDigits(38));
        log.info("result: {}", new Solution().addDigits(782));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int addDigits(int num) {
            while (num >= 10) {
                int sum = 0;
                while (num > 0) {
                    sum += num % 10;
                    num /= 10;
                }
                num = sum;
            }

            return num;
        }

        /**
         * <b>디지털 루트 (Digital Root)</b><br>
         * 1 + (num - 1) % 9
         */
        public int addDigits_(int num) {
            if (num == 0) return 0;
            return 1 + (num - 1) % 9;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}