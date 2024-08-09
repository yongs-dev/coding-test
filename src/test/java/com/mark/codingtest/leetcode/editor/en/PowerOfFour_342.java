package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//Given an integer n, return true if it is a power of four. Otherwise, return 
//false. 
//
// An integer n is a power of four, if there exists an integer x such that n == 
//4ˣ. 
//
// 
// Example 1: 
// Input: n = 16
//Output: true
// 
// Example 2: 
// Input: n = 5
//Output: false
// 
// Example 3: 
// Input: n = 1
//Output: true
// 
// 
// Constraints: 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
//
// 
//Follow up: Could you solve it without loops/recursion?
//
// Related Topics Math Bit Manipulation Recursion 👍 3927 👎 398


@Slf4j
public class PowerOfFour_342 {

    @Test
    void test() {
        log.info("result: {}", new Solution().isPowerOfFour(16));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfFour(int n) {
            if (n <= 0) return false;

            while (n % 4 == 0) {
                n /= 4;
            }

            return n == 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}