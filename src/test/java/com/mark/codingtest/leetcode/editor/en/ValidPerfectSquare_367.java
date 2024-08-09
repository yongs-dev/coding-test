package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//Given a positive integer num, return true if num is a perfect square or false 
//otherwise. 
//
// A perfect square is an integer that is the square of an integer. In other 
//words, it is the product of some integer with itself. 
//
// You must not use any built-in library function, such as sqrt. 
//
// 
// Example 1: 
//
// 
//Input: num = 16
//Output: true
//Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
// 
//
// Example 2: 
//
// 
//Input: num = 14
//Output: false
//Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an 
//integer.
// 
//
// 
// Constraints: 
//
// 
// 1 <= num <= 2³¹ - 1 
// 
//
// Related Topics Math Binary Search 👍 4247 👎 309


@Slf4j
public class ValidPerfectSquare_367 {

    @Test
    void test() {
        log.info("result: {}", new Solution().isPerfectSquare(128));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {
            if (num < 1) {
                return false;
            }

            long x = num;
            while (x * x > num) {
                x = (x + num / x) / 2;
            }

            return x * x == num;
        }

        /**
         * <b>Binary Search</b>
         */
        public boolean isPerfectSquare2(int num) {
            int left = 1;
            int right = num;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                long square = mid * mid;

                if (square == num) {
                    return true;
                } else if (square < num) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}