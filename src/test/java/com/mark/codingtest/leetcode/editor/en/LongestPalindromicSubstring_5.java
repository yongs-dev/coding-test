package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
//
// Related Topics Two Pointers String Dynamic Programming 👍 29653 👎 1812


@Slf4j
public class LongestPalindromicSubstring_5 {

    @Test
    void test() {
        log.info("result: {}", new Solution().longestPalindrome("babad"));
//        log.info("result: {}", new Solution().longestPalindrome("cbbd"));
//        log.info("result: {}", new Solution().longestPalindrome("abb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s.length() == 1) return s;

            int start = 0, end = 0;

            for (int i = 0; i < s.length(); i++) {
                // 회문의 길이가 홀수인 경우
                int len1 = expandFromCenter(s, i, i);

                // 회문의 길이가 짝수인 경우
                int len2 = expandFromCenter(s, i, i + 1);

                // 현재 위치에서 가장 긴 회문 길이
                int len = Math.max(len1, len2);

                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }

            return s.substring(start, end + 1);
        }

        private int expandFromCenter(String s, int left, int right) {
            if (s == null || left > right) return 0;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            return right - left - 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}