package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

//Given two integer arrays nums1 and nums2, return an array of their 
//intersection. Each element in the result must be unique and you may return the result in 
//any order. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2]
// 
//
// Example 2: 
//
// 
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [9,4]
//Explanation: [4,9] is also accepted.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
//
// Related Topics Array Hash Table Two Pointers Binary Search Sorting 👍 6087 👎
// 2294


@Slf4j
public class IntersectionOfTwoArrays_349 {

    @Test
    void test() {
        log.info("result: {}", new Solution().intersection(new int[] {4,9,5}, new int[] {9,4,9,8,4}));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);

            HashSet<Integer> set = new HashSet<>();
            int i = 0, j = 0;

            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] == nums2[j]) {
                    set.add(nums1[i]);
                    i++;
                    j++;
                } else if (nums1[i] < nums2[j]) {
                    i++;
                } else {
                    j++;
                }
            }

            int[] result = new int[set.size()];
            int index = 0;
            for (int k : set) {
                result[index++] = k;
            }

            return result;
        }

        public int[] intersection2(int[] nums1, int[] nums2) {
            HashSet<Integer> set = new HashSet<>();
            for (int i : nums1) {
                set.add(i);
            }

            HashSet<Integer> intersectionSet = new HashSet<>();
            for (int i : nums2) {
                if (set.contains(i)) {
                    intersectionSet.add(i);
                }
            }

            int[] result = new int[intersectionSet.size()];
            int index = 0;
            for (int i : intersectionSet) {
                result[index++] = i;
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}