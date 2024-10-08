package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

//The next greater element of some element x in an array is the first greater 
//element that is to the right of x in the same array. 
//
// You are given two distinct 0-indexed integer arrays nums1 and nums2, where 
//nums1 is a subset of nums2. 
//
// For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[
//j] and determine the next greater element of nums2[j] in nums2. If there is no 
//next greater element, then the answer for this query is -1. 
//
// Return an array ans of length nums1.length such that ans[i] is the next 
//greater element as described above. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
//Output: [-1,3,-1]
//Explanation: The next greater element for each value of nums1 is as follows:
//- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so 
//the answer is -1.
//- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
//- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so 
//the answer is -1.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [2,4], nums2 = [1,2,3,4]
//Output: [3,-1]
//Explanation: The next greater element for each value of nums1 is as follows:
//- 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
//- 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so 
//the answer is -1.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums1.length <= nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 10⁴ 
// All integers in nums1 and nums2 are unique. 
// All the integers of nums1 also appear in nums2. 
// 
//
// 
//Follow up: Could you find an 
//O(nums1.length + nums2.length) solution?
//
// Related Topics Array Hash Table Stack Monotonic Stack 👍 8142 👎 789


@Slf4j
public class NextGreaterElementI_496 {

    @Test
    void test() {
//        log.info("result: {}", new Solution().nextGreaterElement(new int[] {4,1,2}, new int[] {1,3,4,2}));
        log.info("result: {}", new Solution().nextGreaterElement_bruteForce(new int[] {4,1,2}, new int[] {1,3,4,2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> nextGreaterMap = new HashMap<>();
            Stack<Integer> stack = new Stack<>();

            for (int num : nums2) {
                while (!stack.isEmpty() && stack.peek() < num) {
                    nextGreaterMap.put(stack.pop(), num);
                }

                stack.push(num);
            }

            while (!stack.isEmpty()) {
                nextGreaterMap.put(stack.pop(), -1);
            }

            int[] result = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                result[i] = nextGreaterMap.get(nums1[i]);
            }

            return result;
        }

        public int[] nextGreaterElement_bruteForce(int[] nums1, int[] nums2) {
            int[] result = new int[nums1.length];

            for (int i = 0; i < nums1.length; i++) {
                int j = 0;
                while (j < nums2.length && nums2[j] != nums1[i]) {
                    j++;
                }

                int nextGreater = -1;
                for (int k = j + 1; k <nums2.length; k++) {
                    if (nums2[k] > nums1[i]) {
                        nextGreater = nums2[k];
                        break;
                    }
                }

                result[i] = nextGreater;;
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}