package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

//Given an integer array nums of length n and an integer target, find three 
//integers in nums such that the sum is closest to target. 
//
// Return the sum of the three integers. 
//
// You may assume that each input would have exactly one solution. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,2,1,-4], target = 1
//Output: 2
//Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// 
//
// Example 2: 
//
// 
//Input: nums = [0,0,0], target = 1
//Output: 0
//Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 500 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics Array Two Pointers Sorting 👍 10556 👎 574


@Slf4j
public class ThreeSumClosest_16 {

    @Test
    void test() {
        log.info("result: {}", new Solution().threeSumClosest(new int[] {-1, 2, 1, -4}, 1));
//        log.info("result: {}", new Solution().threeSumClosest(new int[] {0, 0, 0}, 1));
//        log.info("result: {}", new Solution().threeSumClosest(new int[] {1, 1, 1, 1}, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);

            int closest = nums[0] + nums[1] + nums[2];

            for (int i = 0; i < nums.length - 2; i++) {
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];

                    if (Math.abs(sum - target) < Math.abs(closest - target)) {
                        closest = sum;
                    }

                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        return closest;
                    }
                }
            }

            return closest;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}