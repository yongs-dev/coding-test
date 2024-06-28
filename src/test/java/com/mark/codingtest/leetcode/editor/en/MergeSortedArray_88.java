package com.mark.codingtest.leetcode.editor.en;

import org.junit.jupiter.api.Test;

//You are given two integer arrays nums1 and nums2, sorted in non-decreasing 
//order, and two integers m and n, representing the number of elements in nums1 and 
//nums2 respectively. 
//
// Merge nums1 and nums2 into a single array sorted in non-decreasing order. 
//
// The final sorted array should not be returned by the function, but instead 
//be stored inside the array nums1. To accommodate this, nums1 has a length of m + 
//n, where the first m elements denote the elements that should be merged, and the 
//last n elements are set to 0 and should be ignored. nums2 has a length of n. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//Output: [1,2,2,3,5,6]
//Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//The result of the merge is [1,2,2,3,5,6] with the underlined elements coming 
//from nums1.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1], m = 1, nums2 = [], n = 0
//Output: [1]
//Explanation: The arrays we are merging are [1] and [].
//The result of the merge is [1].
// 
//
// Example 3: 
//
// 
//Input: nums1 = [0], m = 0, nums2 = [1], n = 1
//Output: [1]
//Explanation: The arrays we are merging are [] and [1].
//The result of the merge is [1].
//Note that because m = 0, there are no elements in nums1. The 0 is only there 
//to ensure the merge result can fit in nums1.
// 
//
// 
// Constraints: 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -10⁹ <= nums1[i], nums2[j] <= 10⁹ 
// 
//
// 
// Follow up: Can you come up with an algorithm that runs in O(m + n) time? 
//
// Related Topics Array Two Pointers Sorting 👍 14762 👎 1917


public class MergeSortedArray_88 {

    @Test
    void test() {
        new Solution().merge(new int[] {1, 2, 3, 0, 0, 0}, 3, new int[] {2, 5, 6}, 3);
//        new Solution().merge(new int[] {1}, 1, new int[] {}, 0);
//        new Solution().merge(new int[] {0}, 0, new int[] {1}, 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // 포인터를 배열의 끝에서부터 시작합니다.
            int p1 = m - 1; // nums1의 마지막 유효 요소 인덱스
            int p2 = n - 1; // nums2의 마지막 요소 인덱스
            int p = m + n - 1; // nums1의 마지막 위치 인덱스

            // nums1과 nums2를 역순으로 비교하여 큰 값을 뒤에서부터 채워 나갑니다.
            while (p1 >= 0 && p2 >= 0) {
                if (nums1[p1] > nums2[p2]) {
                    nums1[p--] = nums1[p1--];
                } else {
                    nums1[p--] = nums2[p2--];
                }
            }

            // nums2 배열에 남아있는 요소를 처리합니다.
            // nums1 배열에 남아있는 요소는 이미 정렬된 상태이므로 무시해도 됩니다.
            while (p2 >= 0) {
                nums1[p--] = nums2[p2--];
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}