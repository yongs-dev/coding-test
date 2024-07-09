package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

//Given a non-empty array of integers nums, every element appears twice except 
//for one. Find that single one. 
//
// You must implement a solution with a linear runtime complexity and use only 
//constant extra space. 
//
// 
// Example 1: 
// Input: nums = [2,2,1]
//Output: 1
// 
// Example 2: 
// Input: nums = [4,1,2,1,2]
//Output: 4
// 
// Example 3: 
// Input: nums = [1]
//Output: 1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -3 * 10⁴ <= nums[i] <= 3 * 10⁴ 
// Each element in the array appears twice except for one element which appears 
//only once. 
// 
//
// Related Topics Array Bit Manipulation 👍 16453 👎 717


@Slf4j
public class SingleNumber_136 {

    @Test
    void test() {
        log.info("result: {}", new Solution().singleNumber(new int[] {4,1,2,1,2}));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int result = 0;

            for (int num : nums) {
                result ^= num;
            }

            return result;
        }

        public int singleNumber2(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            return map.entrySet().stream()
                    .filter(entry -> entry.getValue() == 1)
                    .findFirst()
                    .map(Map.Entry::getKey)
                    .orElseGet(() -> 0);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}