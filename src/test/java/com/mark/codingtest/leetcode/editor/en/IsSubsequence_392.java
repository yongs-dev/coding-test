package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given two strings s and t, return true if s is a subsequence of t, or false 
//otherwise. 
//
// A subsequence of a string is a new string that is formed from the original 
//string by deleting some (can be none) of the characters without disturbing the 
//relative positions of the remaining characters. (i.e., "ace" is a subsequence of 
//"abcde" while "aec" is not). 
//
// 
// Example 1: 
// Input: s = "abc", t = "ahbgdc"
//Output: true
// 
// Example 2: 
// Input: s = "axc", t = "ahbgdc"
//Output: false
// 
// 
// Constraints: 
//
// 
// 0 <= s.length <= 100 
// 0 <= t.length <= 10⁴ 
// s and t consist only of lowercase English letters. 
// 
//
// 
//Follow up: Suppose there are lots of incoming 
//s, say 
//s1, s2, ..., sk where 
//k >= 10⁹, and you want to check one by one to see if 
//t has its subsequence. In this scenario, how would you change your code?
//
// Related Topics Two Pointers String Dynamic Programming 👍 9695 👎 541


@Slf4j
public class IsSubsequence_392 {

    @Test
    void test() {
        log.info("result: {}", new Solution().isSubsequence("abc", "ahbgdc"));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isSubsequence(String s, String t) {
            int sIndex = 0; // s의 현재 문자를 가리키는 인덱스
            int tIndex = 0; // t의 현재 문자를 가리키는 인덱스

            // s와 t를 모두 순회할 때까지 반복
            while (sIndex < s.length() && tIndex < t.length()) {
                // 현재 t의 문자가 s의 현재 문자와 일치하면 s의 다음 문자로 이동
                if (s.charAt(sIndex) == t.charAt(tIndex)) {
                    sIndex++;
                }
                // t의 다음 문자로 이동
                tIndex++;
            }

            // s의 모든 문자를 순회했으면 s는 t의 subsequence
            return sIndex == s.length();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}