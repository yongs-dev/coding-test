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
            // 16진수로 변환할 때 사용할 문자들
            char[] hexChars = "0123456789abcdef".toCharArray();

            // 예외 처리: 숫자가 0인 경우, 결과는 "0"
            if (num == 0) {
                return "0";
            }

            // 결과를 담을 StringBuilder
            StringBuilder hexString = new StringBuilder();

            // 32비트 정수의 모든 비트를 처리
            while (num != 0) {
                // 마지막 4비트를 얻기 위해 num & 0xF를 사용
                hexString.append(hexChars[num & 0xF]);
                // 오른쪽으로 4비트 시프트하여 다음 4비트를 준비
                num >>>= 4; // 부호 없는 시프트 연산자
            }

            // 16진수 문자열이 거꾸로 생성되었으므로, 뒤집기
            return hexString.reverse().toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}