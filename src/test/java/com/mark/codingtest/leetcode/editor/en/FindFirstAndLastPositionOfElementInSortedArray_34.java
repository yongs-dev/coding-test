package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//Given an array of integers nums sorted in non-decreasing order, find the 
//starting and ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// 
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// 
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums is a non-decreasing array. 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics Array Binary Search 👍 20848 👎 539


@Slf4j
public class FindFirstAndLastPositionOfElementInSortedArray_34 {

    @Test
    void test() {
        log.info("result: {}", new Solution().searchRange(new int[] {5,7,7,8,8,10}, 8));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] result = new int[] {-1, -1};

            result[0] = searchElement(nums, target, true);
            result[1] = searchElement(nums, target, false);

            return result;
        }

        private int searchElement(int[] nums, int target, boolean findFirst) {
            int left = 0;
            int right = nums.length - 1;
            int index = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    index = mid;

                    if (findFirst) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return index;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}