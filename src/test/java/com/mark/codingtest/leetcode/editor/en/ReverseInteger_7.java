package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//Given a signed 32-bit integer x, return x with its digits reversed. If 
//reversing x causes the value to go outside the signed 32-bit integer range [-2³¹, 2³¹ -
// 1], then return 0. 
//
// Assume the environment does not allow you to store 64-bit integers (signed 
//or unsigned). 
//
// 
// Example 1: 
//
// 
//Input: x = 123
//Output: 321
// 
//
// Example 2: 
//
// 
//Input: x = -123
//Output: -321
// 
//
// Example 3: 
//
// 
//Input: x = 120
//Output: 21
// 
//
// 
// Constraints: 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// Related Topics Math 👍 13317 👎 13604


@Slf4j
public class ReverseInteger_7 {

    @Test
    void test() {
        log.info("result: {}", new Solution().reverse(-123));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            int reversed = 0;

            while (x != 0) {
                int digit = x % 10;
                x /= 10;

                if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                    return 0;
                }
                if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                    return 0;
                }

                reversed = reversed * 10 + digit;
            }

            return reversed;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}