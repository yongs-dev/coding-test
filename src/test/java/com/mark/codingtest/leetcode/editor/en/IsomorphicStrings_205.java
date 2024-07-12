package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

//Given two strings s and t, determine if they are isomorphic. 
//
// Two strings s and t are isomorphic if the characters in s can be replaced to 
//get t. 
//
// All occurrences of a character must be replaced with another character while 
//preserving the order of characters. No two characters may map to the same 
//character, but a character may map to itself. 
//
// 
// Example 1: 
// Input: s = "egg", t = "add"
//Output: true
// 
// Example 2: 
// Input: s = "foo", t = "bar"
//Output: false
// 
// Example 3: 
// Input: s = "paper", t = "title"
//Output: true
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// t.length == s.length 
// s and t consist of any valid ascii character. 
// 
//
// Related Topics Hash Table String 👍 8987 👎 2093


@Slf4j
public class IsomorphicStrings_205 {

    @Test
    void test() {
//        log.info("result: {}", new Solution().isIsomorphic("egg", "add"));
//        log.info("result: {}", new Solution().isIsomorphic("foo", "bar"));
//        log.info("result: {}", new Solution().isIsomorphic("paper", "title"));
        log.info("result: {}", new Solution().isIsomorphic("badc", "baba"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            Map<Character, Character> sToT = new HashMap<>();
            Map<Character, Character> tToS = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                char sChar = s.charAt(i);
                char tChar = t.charAt(i);

                // Check s -> t mapping
                if (sToT.containsKey(sChar)) {
                    if (sToT.get(sChar) != tChar) {
                        return false; // Conflict found
                    }
                } else {
                    sToT.put(sChar, tChar);
                }

                // Check t -> s mapping
                if (tToS.containsKey(tChar)) {
                    if (tToS.get(tChar) != sChar) {
                        return false; // Conflict found
                    }
                } else {
                    tToS.put(tChar, sChar);
                }
            }

            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}