package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//Write a function that takes the binary representation of a positive integer 
//and returns the number of set bits it has (also known as the Hamming weight). 
//
// 
// Example 1: 
//
// 
// Input: n = 11 
// 
//
// Output: 3 
//
// Explanation: 
//
// The input binary string 1011 has a total of three set bits. 
//
// Example 2: 
//
// 
// Input: n = 128 
// 
//
// Output: 1 
//
// Explanation: 
//
// The input binary string 10000000 has a total of one set bit. 
//
// Example 3: 
//
// 
// Input: n = 2147483645 
// 
//
// Output: 30 
//
// Explanation: 
//
// The input binary string 1111111111111111111111111111101 has a total of 
//thirty set bits. 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
//
// 
//Follow up: If this function is called many times, how would you optimize it?
//
// Related Topics Divide and Conquer Bit Manipulation 👍 6502 👎 1338


@Slf4j
public class NumberOf1Bits_191 {

    @Test
    void test() {
        log.info("result: {}", new Solution().hammingWeight(11));
        log.info("result: {}", new Solution().hammingWeight(128));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0) {
                count += n & 1;
                n = n >>> 1; // 논리 우측 시프트로 오른쪽으로 비트 이동
            }
            return count;
        }

        public int hammingWeight2(int n) {
            int positive = 0;

            String binaryString = Integer.toBinaryString(n);
            for (char c : binaryString.toCharArray()) {
                if (c == '1') {
                    positive++;
                }
            }

            return positive;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}