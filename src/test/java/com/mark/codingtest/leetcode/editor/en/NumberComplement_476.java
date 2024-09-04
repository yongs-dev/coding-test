package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//The complement of an integer is the integer you get when you flip all the 0's 
//to 1's and all the 1's to 0's in its binary representation. 
//
// 
// For example, The integer 5 is "101" in binary and its complement is "010" 
//which is the integer 2. 
// 
//
// Given an integer num, return its complement. 
//
// 
// Example 1: 
//
// 
//Input: num = 5
//Output: 2
//Explanation: The binary representation of 5 is 101 (no leading zero bits), 
//and its complement is 010. So you need to output 2.
// 
//
// Example 2: 
//
// 
//Input: num = 1
//Output: 0
//Explanation: The binary representation of 1 is 1 (no leading zero bits), and 
//its complement is 0. So you need to output 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= num < 2³¹ 
// 
//
// 
// Note: This question is the same as 1009: https://leetcode.com/problems/
//complement-of-base-10-integer/ 
//
// Related Topics Bit Manipulation 👍 3072 👎 135


@Slf4j
public class NumberComplement_476 {

    @Test
    void test() {
        log.info("result: {}", new Solution().findComplement(5));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findComplement(int num) {
            // 이진수 비트 수 결정
            int numBits = Integer.toBinaryString(num).length();

            // 모든 비트를 1로 설정한 마스크 생성
            int mask = (1 << numBits) - 1;

            // 보수 계산
            return mask - num;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}