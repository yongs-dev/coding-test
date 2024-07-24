package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//Given an integer n, return true if it is a power of two. Otherwise, return 
//false. 
//
// An integer n is a power of two, if there exists an integer x such that n == 2
//ˣ. 
//
// 
// Example 1: 
//
// 
//Input: n = 1
//Output: true
//Explanation: 2⁰ = 1
// 
//
// Example 2: 
//
// 
//Input: n = 16
//Output: true
//Explanation: 2⁴ = 16
// 
//
// Example 3: 
//
// 
//Input: n = 3
//Output: false
// 
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
// Related Topics Math Bit Manipulation Recursion 👍 6820 👎 433


@Slf4j
public class PowerOfTwo_231 {

    @Test
    void test() {
        log.info("result: {}", new Solution().isPowerOfTwo(3));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfTwo(int n) {
            return n > 0 && (n & (n - 1)) == 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}