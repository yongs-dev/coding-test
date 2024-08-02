package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//An ugly number is a positive integer whose prime factors are limited to 2, 3, 
//and 5. 
//
// Given an integer n, return true if n is an ugly number. 
//
// 
// Example 1: 
//
// 
//Input: n = 6
//Output: true
//Explanation: 6 = 2 × 3
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: true
//Explanation: 1 has no prime factors, therefore all of its prime factors are 
//limited to 2, 3, and 5.
// 
//
// Example 3: 
//
// 
//Input: n = 14
//Output: false
//Explanation: 14 is not ugly since it includes the prime factor 7.
// 
//
// 
// Constraints: 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
//
// Related Topics Math 👍 3357 👎 1706


@Slf4j
public class UglyNumber_263 {

    @Test
    void test() {
        log.info("result: {}", new Solution().isUgly(6));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isUgly(int n) {
            if (n <= 0) return false;

            int[] divisors = new int[]{2, 3, 5};

            for (int divisor : divisors) {
                while (n % divisor == 0) {
                    n /= divisor;
                }
            }

            return n == 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}