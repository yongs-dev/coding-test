package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//Given an input string s and a pattern p, implement regular expression 
//matching with support for '.' and '*' where: 
//
// 
// '.' Matches any single character. 
// '*' Matches zero or more of the preceding element. 
// 
//
// The matching should cover the entire input string (not partial). 
//
// 
// Example 1: 
//
// 
//Input: s = "aa", p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
// 
//
// Example 2: 
//
// 
//Input: s = "aa", p = "a*"
//Output: true
//Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, 
//by repeating 'a' once, it becomes "aa".
// 
//
// Example 3: 
//
// 
//Input: s = "ab", p = ".*"
//Output: true
//Explanation: ".*" means "zero or more (*) of any character (.)".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 20 
// 1 <= p.length <= 20 
// s contains only lowercase English letters. 
// p contains only lowercase English letters, '.', and '*'. 
// It is guaranteed for each appearance of the character '*', there will be a 
//previous valid character to match. 
// 
//
// Related Topics String Dynamic Programming Recursion 👍 12271 👎 2194


@Slf4j
public class RegularExpressionMatching_10 {

    @Test
    void test() {
        log.info("result: {}", new Solution().isMatch("aa", "a"));
        log.info("result: {}", new Solution().isMatch("ab", ".*"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            int sLen = s.length();
            int pLen = p.length();

            boolean[][] dp = new boolean[sLen + 1][pLen + 1];
            dp[0][0] = true;

            // 패턴의 '*' 초기 처리
            for (int j = 2; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[0][j] = dp[0][j - 2];
                }
            }

            // DP 테이블 채우기
            for (int i = 1; i <= sLen; i++) {
                for (int j = 1; j <= pLen; j++) {
                    char currentS = s.charAt(i - 1);
                    char currentP = p.charAt(j - 1);

                    if (currentP == '.' || currentP == currentS) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (currentP == '*') {
                        // '*'를 0번 사용하는 경우
                        dp[i][j] = dp[i][j - 2];

                        // '*'를 1번 이상 사용하는 경우
                        char precedingP = p.charAt(j - 2);
                        if (precedingP == '.' || precedingP == currentS) {
                            dp[i][j] = dp[i][j] || dp[i - 1][j];
                        }
                    }
                }
            }

            return dp[sLen][pLen];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}