package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//Given an integer array nums, move all 0's to the end of it while maintaining 
//the relative order of the non-zero elements. 
//
// Note that you must do this in-place without making a copy of the array. 
//
// 
// Example 1: 
// Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]
// 
// Example 2: 
// Input: nums = [0]
//Output: [0]
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
//Follow up: Could you minimize the total number of operations done?
//
// Related Topics Array Two Pointers 👍 16764 👎 464


@Slf4j
public class MoveZeroes_283 {

    @Test
    void test() {
        new Solution().moveZeroes(new int[] {0,1,0,3,12});
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int nonZeroIndex = 0;

            // 모든 0이 아닌 요소를 앞으로 이동
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[nonZeroIndex++] = nums[i];
                }
            }

            // 나머지 부분을 0으로 채우기
            for (int i = nonZeroIndex; i < nums.length; i++) {
                nums[i] = 0;
            }
        }

        public void moveZeroes2(int[] nums) {
            if (nums.length > 1) {
                for (int i = 0; i < nums.length; i++) {
                    int left = 0;
                    int right = 1;

                    if (nums[i] != 0) continue;

                    while (left <= right) {
                        if (nums[left] == 0) {
                            int temp = nums[left];
                            nums[left] = nums[right];
                            nums[right] = temp;
                        }

                        left++;
                        right++;

                        if (right == nums.length) {
                            break;
                        }
                    }
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}