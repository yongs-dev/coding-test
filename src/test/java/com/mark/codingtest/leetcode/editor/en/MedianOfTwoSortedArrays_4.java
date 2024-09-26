package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//Given two sorted arrays nums1 and nums2 of size m and n respectively, return 
//the median of the two sorted arrays. 
//
// The overall run time complexity should be O(log (m+n)). 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
// 
//
// 
// Constraints: 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics Array Binary Search Divide and Conquer 👍 28709 👎 3222


@Slf4j
public class MedianOfTwoSortedArrays_4 {

    @Test
    void test() {
        log.info("result: {}", new Solution().findMedianSortedArrays(new int[] {1,2}, new int[] {3,4}));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * <b>Binary Search</b><br>
         * O(log (m+n)) 시간복잡도
         */
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                return findMedianSortedArrays(nums2, nums1);
            }

            int m = nums1.length;
            int n = nums2.length;
            int low = 0, high = m;

            while (low <= high) {
                int partitionX = (low + high) / 2;
                int partitionY = (m + n + 1) / 2 - partitionX;

                int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
                int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

                int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
                int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

                if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                    if ((m + n) % 2 == 0) {
                        return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                    } else {
                        return Math.max(maxLeftX, maxLeftY);
                    }
                } else if (maxLeftX > minRightY) {
                    high = partitionX - 1;
                } else {
                    low = partitionX + 1;
                }
            }

            throw new IllegalArgumentException();
        }

        /**
         * <b>Two Pointer</b><br>
         * O(m+n) 시간 복잡도
         */
        public double findMedianSortedArrays_using_twoPointer(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;
            int totalLength = m + n;
            int[] merged = new int[totalLength];
            int i = 0, j = 0, index = 0;

            while (i < m && j < n) {
                if (nums1[i] <= nums2[j]) {
                    merged[index++] = nums1[i++];
                } else {
                    merged[index++] = nums2[j++];
                }
            }

            while (i < m) {
                merged[index++] = nums1[i++];
            }

            while (j < n) {
                merged[index++] = nums2[j++];
            }

            if (totalLength % 2 == 1) {
                return merged[totalLength / 2];
            } else {
                return (merged[totalLength / 2 - 1] + merged[totalLength / 2]) / 2.0;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}