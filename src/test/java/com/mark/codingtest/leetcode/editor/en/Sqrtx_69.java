package com.mark.codingtest.leetcode.editor.en;

import org.junit.jupiter.api.Test;

//Given a non-negative integer x, return the square root of x rounded down to 
//the nearest integer. The returned integer should be non-negative as well. 
//
// You must not use any built-in exponent function or operator. 
//
// 
// For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python. 
// 
//
// 
// Example 1: 
//
// 
//Input: x = 4
//Output: 2
//Explanation: The square root of 4 is 2, so we return 2.
// 
//
// Example 2: 
//
// 
//Input: x = 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since we round it down 
//to the nearest integer, 2 is returned.
// 
//
// 
// Constraints: 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
//
// Related Topics Math Binary Search 👍 8106 👎 4495


public class Sqrtx_69 {

    @Test
    void test() {
        new Solution().mySqrt(4);
        new Solution().mySqrt(2147395599);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            if (x==0) return x;

            int left = 1;
            int right = x;
            int result = 0;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (mid <= x / mid) {
                    result = mid;   // mid가 가능한 정답 중 하나
                    left = mid + 1;
                } else {
                    right = mid - 1;    // mid가 너무 큼, 왼쪽으로 이동
                }
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}