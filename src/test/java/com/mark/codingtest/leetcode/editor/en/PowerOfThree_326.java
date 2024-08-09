package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//Given an integer n, return true if it is a power of three. Otherwise, return 
//false. 
//
// An integer n is a power of three, if there exists an integer x such that n ==
// 3ˣ. 
//
// 
// Example 1: 
//
// 
//Input: n = 27
//Output: true
//Explanation: 27 = 3³
// 
//
// Example 2: 
//
// 
//Input: n = 0
//Output: false
//Explanation: There is no x where 3ˣ = 0.
// 
//
// Example 3: 
//
// 
//Input: n = -1
//Output: false
//Explanation: There is no x where 3ˣ = (-1).
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
// Related Topics Math Recursion 👍 3097 👎 277


@Slf4j
public class PowerOfThree_326 {

    @Test
    void test() {
        log.info("result: {}", new Solution().isPowerOfThree(9));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfThree(int n) {
            if (n == 0) return false;

            while (n % 3 == 0) {
                n /= 3;
            }

            return n == 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}