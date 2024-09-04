package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array nums of n integers where nums[i] is in the range [1, n], 
//return an array of all the integers in the range [1, n] that do not appear in nums. 
//
// 
// Example 1: 
// Input: nums = [4,3,2,7,8,2,3,1]
//Output: [5,6]
// 
// Example 2: 
// Input: nums = [1,1]
//Output: [2]
// 
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 1 <= nums[i] <= n 
// 
//
// 
// Follow up: Could you do it without extra space and in O(n) runtime? You may 
//assume the returned list does not count as extra space. 
//
// Related Topics Array Hash Table 👍 9458 👎 493


@Slf4j
public class FindAllNumbersDisappearedInAnArray_448 {

    @Test
    void test() {
        log.info("result: {}", new Solution().findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> result = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                int absValue = Math.abs(nums[i]);
                if (nums[absValue - 1] > 0) {
                    nums[absValue - 1] = -nums[absValue - 1];
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    result.add(i + 1);
                }
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}