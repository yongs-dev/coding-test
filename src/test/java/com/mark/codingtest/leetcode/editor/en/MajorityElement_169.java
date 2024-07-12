package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

//Given an array nums of size n, return the majority element. 
//
// The majority element is the element that appears more than ⌊n / 2⌋ times. 
//You may assume that the majority element always exists in the array. 
//
// 
// Example 1: 
// Input: nums = [3,2,3]
//Output: 3
// 
// Example 2: 
// Input: nums = [2,2,1,1,1,2,2]
//Output: 2
// 
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//Follow-up: Could you solve the problem in linear time and in 
//O(1) space?
//
// Related Topics Array Hash Table Divide and Conquer Sorting Counting 👍 19114 
//👎 625


@Slf4j
public class MajorityElement_169 {

    @Test
    void test() {
        log.info("result: {}", new Solution().majorityElement(new int[] {3, 2, 3}));
        log.info("result: {}", new Solution().majorityElement(new int[] {2,2,1,2,2,1,1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * Boyer-Moore 투표 알고리즘
         */
        public int majorityElement(int[] nums) {
            int candidate = nums[0];
            int count = 1;

            for (int i = 1; i < nums.length; i++) {
                if (count == 0) {
                    candidate = nums[i];
                }

                if (nums[i] == candidate) {
                    count++;
                } else {
                    count--;
                }
            }

            return candidate;
        }

        public int majorityElement2(int[] nums) {
            int half = nums.length / 2;
            Map<Integer, Integer> candidate = new HashMap<>();

            for (int num : nums) {
                candidate.put(num, candidate.getOrDefault(num, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : candidate.entrySet()) {
                if (entry.getValue() > half) {
                    return entry.getKey();
                }
            }

            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}