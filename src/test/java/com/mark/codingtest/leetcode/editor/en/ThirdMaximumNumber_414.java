package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

//Given an integer array nums, return the third distinct maximum number in this 
//array. If the third maximum does not exist, return the maximum number. 
//
// 
// Example 1: 
//
//
//Input: nums = [3,2,1]
//Output: 1
//Explanation:
//The first distinct maximum is 3.
//The second distinct maximum is 2.
//The third distinct maximum is 1.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2]
//Output: 2
//Explanation:
//The first distinct maximum is 2.
//The second distinct maximum is 1.
//The third distinct maximum does not exist, so the maximum (2) is returned 
//instead.
// 
//
// Example 3: 
//
// 
//Input: nums = [2,2,3,1]
//Output: 1
//Explanation:
//The first distinct maximum is 3.
//The second distinct maximum is 2 (both 2's are counted together since they 
//have the same value).
//The third distinct maximum is 1.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//Follow up: Can you find an 
//O(n) solution?
//
// Related Topics Array Sorting 👍 3053 👎 3189


@Slf4j
public class ThirdMaximumNumber_414 {

    @Test
    void test() {
//        log.info("result: {}", new Solution().thirdMax(new int[] {2, 2, 3, 1}));
//        log.info("result: {}", new Solution().thirdMax(new int[] {1, 2}));
//        log.info("result: {}", new Solution().thirdMax(new int[] {1, 1, 2}));
        log.info("result: {}", new Solution().thirdMax(new int[] {3, 2, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int thirdMax(int[] nums) {
            Set<Integer> uniqueNumbers = new HashSet<>();

            for (int num : nums) {
                uniqueNumbers.add(num);
            }

            // 변수를 정렬할 리스트로 변환
            Integer[] sortedUniqueNumbers = uniqueNumbers.toArray(new Integer[0]);
            Arrays.sort(sortedUniqueNumbers, Collections.reverseOrder());

            // 최대 3개의 값 중 세 번째로 큰 값 찾기
            if (sortedUniqueNumbers.length >= 3) {
                return sortedUniqueNumbers[2];
            } else {
                return sortedUniqueNumbers[0];
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}