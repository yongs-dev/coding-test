package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//Given a 32-bit integer num, return a string representing its hexadecimal 
//representation. For negative integers, two’s complement method is used. 
//
// All the letters in the answer string should be lowercase characters, and 
//there should not be any leading zeros in the answer except for the zero itself. 
//
// Note: You are not allowed to use any built-in library method to directly 
//solve this problem. 
//
// 
// Example 1: 
// Input: num = 26
//Output: "1a"
// 
// Example 2: 
// Input: num = -1
//Output: "ffffffff"
// 
// 
// Constraints: 
//
// 
// -2³¹ <= num <= 2³¹ - 1 
// 
//
// Related Topics Math Bit Manipulation 👍 1314 👎 221


@Slf4j
public class ConvertANumberToHexadecimal_405 {

    @Test
    void test() {
        log.info("result: {}", new Solution().toHex(26));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String toHex(int num) {
            // 제로 처리
            if (num == 0) return "0";

            // 음수의 경우, 32비트 두의 보수 방식으로 변환
            if (num < 0) {
                num += (1L << 32); // 2^32
            }

            // 16진수 문자 배열
            char[] hexChars = "0123456789abcdef".toCharArray();
            StringBuilder sb = new StringBuilder();

            while (num > 0) {
                sb.append(hexChars[num & 0xF]); // 마지막 4비트를 추출하여 16진수 문자로 변환
                num >>>= 4; // 4비트 오른쪽 시프트
            }

            // 문자열을 역순으로 변환
            return sb.reverse().toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}