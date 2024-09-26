package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array nums of n integers, return an array of all the unique
//quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
//
//
// 0 <= a, b, c, d < n
// a, b, c, and d are distinct.
// nums[a] + nums[b] + nums[c] + nums[d] == target
// 
//
// You may return the answer in any order.
//
// 
// Example 1: 
//
// 
//Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [2,2,2,2,2], target = 8
//Output: [[2,2,2,2]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics Array Two Pointers Sorting 👍 11489 👎 1412


@Slf4j
public class FourSum_18 {

    @Test
    void test() {
//        log.info("result: {}", new Solution().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        log.info("result: {}", new Solution().fourSum(new int[]{2, 2, 2, 2, 2}, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();

            for (int i = 0; i < nums.length - 3; i++) {
                // 중복된 값 건너뛰기
                if (i > 0 && nums[i] == nums[i - 1]) continue;

                for (int j = i + 1; j < nums.length - 2; j++) {
                    // 중복된 값 건너뛰기
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                    int left = j + 1;
                    int right = nums.length - 1;

                    while (left < right) {
                        long sum = (long) nums[i] + (long) nums[j] + (long) nums[left] + (long) nums[right];

                        if (sum == target) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                            // 중복된 값 건너뛰기
                            while (left < right && nums[left] == nums[left + 1]) left++;
                            while (left < right && nums[right] == nums[right - 1]) right--;

                            left++;
                            right--;
                        } else if (sum < target) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}