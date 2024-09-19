package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//Given a binary array nums, return the maximum number of consecutive 1's in 
//the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,0,1,1,1]
//Output: 3
//Explanation: The first two digits or the last three digits are consecutive 1s.
// The maximum number of consecutive 1s is 3.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,0,1,1,0,1]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] is either 0 or 1. 
// 
//
// Related Topics Array 👍 5828 👎 457


@Slf4j
public class MaxConsecutiveOnes_485 {

    @Test
    void test() {
        log.info("result: {}", new Solution().findMaxConsecutiveOnes(new int[] {1,1,0,1,1,1}));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int count = 0;
            int max = 0;
            for (int num : nums) {
                if (num == 1) {
                    count++;
                } else {
                    count = 0;
                }

                if (count > max) {
                    max = count;
                }
            }

            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}