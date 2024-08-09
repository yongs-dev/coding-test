package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//Given an integer array nums, handle multiple queries of the following type: 
//
// 
// Calculate the sum of the elements of nums between indices left and right 
//inclusive where left <= right. 
// 
//
// Implement the NumArray class: 
//
// 
// NumArray(int[] nums) Initializes the object with the integer array nums. 
// int sumRange(int left, int right) Returns the sum of the elements of nums 
//between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + 
//nums[right]). 
// 
//
// 
// Example 1: 
//
// 
//Input
//["NumArray", "sumRange", "sumRange", "sumRange"]
//[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
//Output
//[null, 1, -1, -3]
//
//Explanation
//NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
//numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
//numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
//numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 0 <= left <= right < nums.length 
// At most 10⁴ calls will be made to sumRange. 
// 
//
// Related Topics Array Design Prefix Sum 👍 3247 👎 1909


@Slf4j
public class RangeSumQueryImmutable_303 {

    @Test
    void test() {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        log.info("result: {}", numArray.sumRange(0, 2));
        log.info("result: {}", numArray.sumRange(2, 5));
        log.info("result: {}", numArray.sumRange(0, 5));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {
        private int[] prefixSums;

        public NumArray(int[] nums) {
            prefixSums = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                prefixSums[i + 1] = prefixSums[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return prefixSums[right + 1] - prefixSums[left];
        }
    }

//    class NumArray {
//        int[] array;
//
//        public NumArray(int[] nums) {
//            array = nums;
//        }
//
//        public int sumRange(int left, int right) {
//            int sum = 0;
//            for (int i = left; i <= right; i++) {
//                sum += array[i];
//            }
//
//            return sum;
//        }
//    }
    
    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(left,right);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}