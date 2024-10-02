package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//Given two integers dividend and divisor, divide two integers without using 
//multiplication, division, and mod operator. 
//
// The integer division should truncate toward zero, which means losing its 
//fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be 
//truncated to -2. 
//
// Return the quotient after dividing dividend by divisor. 
//
// Note: Assume we are dealing with an environment that could only store 
//integers within the 32-bit signed integer range: [−2³¹, 2³¹ − 1]. For this problem, if 
//the quotient is strictly greater than 2³¹ - 1, then return 2³¹ - 1, and if the 
//quotient is strictly less than -2³¹, then return -2³¹. 
//
// 
// Example 1: 
//
// 
//Input: dividend = 10, divisor = 3
//Output: 3
//Explanation: 10/3 = 3.33333.. which is truncated to 3.
// 
//
// Example 2: 
//
// 
//Input: dividend = 7, divisor = -3
//Output: -2
//Explanation: 7/-3 = -2.33333.. which is truncated to -2.
// 
//
// 
// Constraints: 
//
// 
// -2³¹ <= dividend, divisor <= 2³¹ - 1 
// divisor != 0 
// 
//
// Related Topics Math Bit Manipulation 👍 5293 👎 14892


@Slf4j
public class DivideTwoIntegers_29 {

    @Test
    void test() {
        log.info("result: {}", new Solution().divide(10, 3));
        log.info("result: {}", new Solution().divide(7, -3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int dividend, int divisor) {
            // 32비트 정수 범위 처리
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE; // 오버플로우를 방지하기 위해 최대값 반환
            }

            // 부호 계산: 결과가 음수인지 양수인지
            boolean isNegative = (dividend < 0) != (divisor < 0);

            // 양수로 계산하기 위해 절댓값으로 변환
            long absDividend = Math.abs((long) dividend);
            long absDivisor = Math.abs((long) divisor);

            // 결과값을 저장할 변수
            int result = 0;

            // divisor를 왼쪽으로 시프트하며 몫을 계산
            while (absDividend >= absDivisor) {
                long tempDivisor = absDivisor;
                int multiple = 1;
                while (absDividend >= (tempDivisor << 1)) {
                    tempDivisor <<= 1;
                    multiple <<= 1;
                }
                // 나눗셈 진행
                absDividend -= tempDivisor;
                result += multiple;
            }

            // 부호 처리
            return isNegative ? -result : result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}