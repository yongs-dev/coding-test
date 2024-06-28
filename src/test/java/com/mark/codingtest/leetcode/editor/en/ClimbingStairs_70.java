package com.mark.codingtest.leetcode.editor.en;

import org.junit.jupiter.api.Test;

//You are climbing a staircase. It takes n steps to reach the top. 
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can 
//you climb to the top? 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 45 
// 
//
// Related Topics Math Dynamic Programming Memoization 👍 21818 👎 832


public class ClimbingStairs_70 {

    @Test
    void test() {
        new Solution().climbStairs(2);
        new Solution().climbStairs(3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            // Dynamic Programming
            if (n == 1) {
                return 1;
            }

            if (n == 2) {
                return 2;
            }

            int first = 1;
            int second = 2;
            int result = 0;

            for (int i = 3; i <= n; i++) {
                result = first + second;
                first = second;
                second = result;
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}