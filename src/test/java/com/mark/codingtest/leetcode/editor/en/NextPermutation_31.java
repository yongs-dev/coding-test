package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

//A permutation of an array of integers is an arrangement of its members into a 
//sequence or linear order. 
//
// 
// For example, for arr = [1,2,3], the following are all the permutations of 
//arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1]. 
// 
//
// The next permutation of an array of integers is the next lexicographically 
//greater permutation of its integer. More formally, if all the permutations of the 
//array are sorted in one container according to their lexicographical order, 
//then the next permutation of that array is the permutation that follows it in the 
//sorted container. If such arrangement is not possible, the array must be 
//rearranged as the lowest possible order (i.e., sorted in ascending order). 
//
// 
// For example, the next permutation of arr = [1,2,3] is [1,3,2]. 
// Similarly, the next permutation of arr = [2,3,1] is [3,1,2]. 
// While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does 
//not have a lexicographical larger rearrangement. 
// 
//
// Given an array of integers nums, find the next permutation of nums. 
//
// The replacement must be in place and use only constant extra memory. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: [1,3,2]
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,1]
//Output: [1,2,3]
// 
//
// Example 3: 
//
// 
//Input: nums = [1,1,5]
//Output: [1,5,1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
//
// Related Topics Array Two Pointers 👍 18746 👎 4774


@Slf4j
public class NextPermutation_31 {

    @Test
    void test() {
//        new Solution().nextPermutation(new int[] {1, 2, 3});
        new Solution().nextPermutation(new int[] {3, 2, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            // 1. 뒤에서부터 탐색하여 처음으로 nums[i] < nums[i+1]인 i를 찾는다.
            int i = nums.length - 2;
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }

            // 2. 그 지점이 있으면, nums[i]보다 큰 값 중 가장 가까운 값을 찾고 교환한다.
            if (i >= 0) {
                int j = nums.length - 1;
                while (nums[j] <= nums[i]) {
                    j--;
                }
                swap(nums, i, j);
            }

            // 3. i 이후의 숫자들은 오름차순으로 재배열한다.
            reverse(nums, i + 1);
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private void reverse(int[] nums, int start) {
            int end = nums.length - 1;
            while (start < end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}