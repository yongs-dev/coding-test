package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

//A perfect number is a positive integer that is equal to the sum of its 
//positive divisors, excluding the number itself. A divisor of an integer x is an 
//integer that can divide x evenly. 
//
// Given an integer n, return true if n is a perfect number, otherwise return 
//false. 
//
// 
// Example 1: 
//
// 
//Input: num = 28
//Output: true
//Explanation: 28 = 1 + 2 + 4 + 7 + 14
//1, 2, 4, 7, and 14 are all divisors of 28.
// 
//
// Example 2: 
//
// 
//Input: num = 7
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= num <= 10⁸ 
// 
//
// Related Topics Math 👍 1101 👎 1241


@Slf4j
public class PerfectNumber_507 {

    @Test
    void test() {
        log.info("result: {}", new Solution().checkPerfectNumber(100));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkPerfectNumber(int num) {
            if (num <= 1) return false;
            int sum = 1;

//            for (int i = 2; i < num; i++) {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    sum += i;

                    if (i != num / i) {
                        sum += num / i;
                    } else {
                        System.out.println(i);
                    }
                }
            }

            return num == sum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}