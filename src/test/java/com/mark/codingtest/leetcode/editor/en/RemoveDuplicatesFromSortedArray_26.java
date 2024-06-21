package com.mark.codingtest.leetcode.editor.en;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//Given an integer array nums sorted in non-decreasing order, remove the 
//duplicates in-place such that each unique element appears only once. The relative 
//order of the elements should be kept the same. Then return the number of unique 
//elements in nums. 
//
// Consider the number of unique elements of nums to be k, to get accepted, you 
//need to do the following things: 
//
// 
// Change the array nums such that the first k elements of nums contain the 
//unique elements in the order they were present in nums initially. The remaining 
//elements of nums are not important as well as the size of nums. 
// Return k. 
// 
//
// Custom Judge: 
//
// The judge will test your solution with the following code: 
//
// 
//int[] nums = [...]; // Input array
//int[] expectedNums = [...]; // The expected answer with correct length
//
//int k = removeDuplicates(nums); // Calls your implementation
//
//assert k == expectedNums.length;
//for (int i = 0; i < k; i++) {
//    assert nums[i] == expectedNums[i];
//}
// 
//
// If all assertions pass, then your solution will be accepted. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,2]
//Output: 2, nums = [1,2,_]
//Explanation: Your function should return k = 2, with the first two elements 
//of nums being 1 and 2 respectively.
//It does not matter what you leave beyond the returned k (hence they are 
//underscores).
// 
//
// Example 2: 
//
// 
//Input: nums = [0,0,1,1,1,2,2,3,3,4]
//Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
//Explanation: Your function should return k = 5, with the first five elements 
//of nums being 0, 1, 2, 3, and 4 respectively.
//It does not matter what you leave beyond the returned k (hence they are 
//underscores).
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -100 <= nums[i] <= 100 
// nums is sorted in non-decreasing order. 
// 
//
// Related Topics Array Two Pointers 👍 14418 👎 18566


public class RemoveDuplicatesFromSortedArray_26 {

    @Test
    void test() {
//        new Solution().removeDuplicates(new int[] {1, 1, 2});
        new Solution().removeDuplicates(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) return 0; // 예외 처리

            int slow = 0; // slow 포인터는 유일한 요소들이 저장될 위치를 나타냄
            for (int fast = 1; fast < nums.length; fast++) {
                if (nums[fast] != nums[slow]) {
                    slow++; // slow 포인터 이동
                    nums[slow] = nums[fast]; // slow 포인터 위치에 fast 포인터의 값 저장
                }
            }
            return slow + 1; // 유일한 요소들의 개수를 나타내는 값 반환
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}