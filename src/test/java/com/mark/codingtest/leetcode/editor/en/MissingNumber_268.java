package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

//Given an array nums containing n distinct numbers in the range [0, n], return 
//the only number in the range that is missing from the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,0,1]
//Output: 2
//Explanation: n = 3 since there are 3 numbers, so all numbers are in the range 
//[0,3]. 2 is the missing number in the range since it does not appear in nums.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1]
//Output: 2
//Explanation: n = 2 since there are 2 numbers, so all numbers are in the range 
//[0,2]. 2 is the missing number in the range since it does not appear in nums.
// 
//
// Example 3: 
//
// 
//Input: nums = [9,6,4,2,3,5,7,0,1]
//Output: 8
//Explanation: n = 9 since there are 9 numbers, so all numbers are in the range 
//[0,9]. 8 is the missing number in the range since it does not appear in nums.
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 10⁴ 
// 0 <= nums[i] <= n 
// All the numbers of nums are unique. 
// 
//
// 
// Follow up: Could you implement a solution using only O(1) extra space 
//complexity and O(n) runtime complexity? 
//
// Related Topics Array Hash Table Math Binary Search Bit Manipulation Sorting ?
//? 12153 👎 3331


@Slf4j
public class MissingNumber_268 {

    @Test
    void test() {
//        log.info("result: {}", new Solution().missingNumber(new int[] {3,0,1}));
//        log.info("result: {}", new Solution().missingNumber(new int[] {0,1}));
        log.info("result: {}", new Solution().missingNumber(new int[] {9,6,4,2,3,5,7,0,1}));
//        log.info("result: {}", new Solution().missingNumber(new int[] {1, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * <b>0 ~ n까지의 총합 - 배열의 총합 = 누락된 숫자</b>
         */
        public int missingNumber(int[] nums) {
            int n = nums.length;

            // 0부터 n까지의 총합
            int totalSum = (n * (n + 1)) / 2;

            // 배열의 총합
            int arraySum = 0;
            for (int num : nums) {
                arraySum += num;
            }

            // 누락된 숫자
            return totalSum - arraySum;
        }

        /**
         * <b>0부터 n까지의 숫자와 배열의 숫자를 XOR 연산하면 남은 숫자가 누락된 숫자</b>
         */
        public int missingNumber2(int[] nums) {
            int n = nums.length;
            int xor = 0;

            // 0부터 n까지의 숫자와 배열의 숫자를 XOR 연산
            for (int i = 0; i <= n; i++) {
                xor ^= i;
            }
            for (int num : nums) {
                xor ^= num;
            }

            // 남은 숫자가 누락된 숫자
            return xor;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}