package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

//Given two strings s and t, return true if t is an anagram of s, and false 
//otherwise. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a 
//different word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
// Input: s = "anagram", t = "nagaram"
//Output: true
// 
// Example 2: 
// Input: s = "rat", t = "car"
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s and t consist of lowercase English letters. 
// 
//
// 
// Follow up: What if the inputs contain Unicode characters? How would you 
//adapt your solution to such a case? 
//
// Related Topics Hash Table String Sorting 👍 12165 👎 404


@Slf4j
public class ValidAnagram_242 {

    @Test
    void test() {
        log.info("result: {}", new Solution().isAnagram("anagram", "nagaram"));
        log.info("result: {}", new Solution().isAnagram("rat", "car"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * <b>Hash Table</b>
         */
        public boolean isAnagram(String s, String t) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            for (char c : t.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) - 1);
            }

            return map.entrySet().stream().noneMatch(e -> e.getValue() != 0);
        }

        /**
         * <b>Array</b>
         */
        public boolean isAnagramArray(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            int[] count = new int[26];

            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
                count[t.charAt(i) - 'a']--;
            }

            for (int c : count) {
                if (c != 0) {
                    return false;
                }
            }

            return true;
        }

        /**
         * <b>Array Sort</b>
         */
        public boolean isAnagramArraySort(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            char[] sArray = s.toCharArray();
            char[] tArray = t.toCharArray();

            Arrays.sort(sArray);
            Arrays.sort(tArray);

            return Arrays.equals(sArray, tArray);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}