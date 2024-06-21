package com.mark.codingtest.leetcode.editor.en;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//You are given a large integer represented as an integer array digits, where 
//each digits[i] is the iᵗʰ digit of the integer. The digits are ordered from most 
//significant to least significant in left-to-right order. The large integer does 
//not contain any leading 0's. 
//
// Increment the large integer by one and return the resulting array of digits. 
//
//
// 
// Example 1: 
//
// 
//Input: digits = [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
//Incrementing by one gives 123 + 1 = 124.
//Thus, the result should be [1,2,4].
// 
//
// Example 2: 
//
// 
//Input: digits = [4,3,2,1]
//Output: [4,3,2,2]
//Explanation: The array represents the integer 4321.
//Incrementing by one gives 4321 + 1 = 4322.
//Thus, the result should be [4,3,2,2].
// 
//
// Example 3: 
//
// 
//Input: digits = [9]
//Output: [1,0]
//Explanation: The array represents the integer 9.
//Incrementing by one gives 9 + 1 = 10.
//Thus, the result should be [1,0].
// 
//
// 
// Constraints: 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// digits does not contain any leading 0's. 
// 
//
// Related Topics Array Math 👍 9263 👎 5379


public class PlusOne_66 {

    @Test
    void test() {
//        new Solution().plusOne(new int[] {1, 2, 3});
//        new Solution().plusOne(new int[] {4, 3, 2, 1});
//        new Solution().plusOne(new int[] {9});
        new Solution().plusOne(new int[] {8, 9});
        new Solution().plusOne(new int[] {9, 9});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            int n = digits.length;

            for (int i = n - 1; i >= 0; i--) {
                digits[i]++;

                if (digits[i] < 10) {
                    return digits;
                }

                digits[i] = 0;
            }

            int[] newDigits = new int[n + 1];
            newDigits[0] = 1;

            return newDigits;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}