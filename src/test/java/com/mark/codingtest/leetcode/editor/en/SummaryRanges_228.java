package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

//You are given a sorted unique integer array nums. 
//
// A range [a,b] is the set of all integers from a to b (inclusive). 
//
// Return the smallest sorted list of ranges that cover all the numbers in the 
//array exactly. That is, each element of nums is covered by exactly one of the 
//ranges, and there is no integer x such that x is in one of the ranges but not in 
//nums. 
//
// Each range [a,b] in the list should be output as: 
//
// 
// "a->b" if a != b 
// "a" if a == b 
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [0,1,2,4,5,7]
//Output: ["0->2","4->5","7"]
//Explanation: The ranges are:
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
// 
//
// Example 2: 
//
// 
//Input: nums = [0,2,3,4,6,8,9]
//Output: ["0","2->4","6","8->9"]
//Explanation: The ranges are:
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 20 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// All the values of nums are unique. 
// nums is sorted in ascending order. 
// 
//
// Related Topics Array 👍 3949 👎 2164


@Slf4j
public class SummaryRanges_228 {

    @Test
    void test() {
        log.info("result: {}", new Solution().summaryRanges(new int[] {0,1,2,4,5,7}));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> result = new ArrayList<>();

            if (nums == null || nums.length == 0) {
                return result;
            }

            int start = nums[0];
            int end = nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == end + 1) {
                    end = nums[i];
                } else {
                    if (start == end) {
                        result.add(String.valueOf(start));
                    } else {
                        result.add(start + "->" + end);
                    }
                    start = nums[i];
                    end = nums[i];
                }
            }

            if (start == end) {
                result.add(String.valueOf(start));
            } else {
                result.add(start + "->" + end);
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}