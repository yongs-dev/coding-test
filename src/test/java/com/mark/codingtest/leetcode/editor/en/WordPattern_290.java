package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

//Given a pattern and a string s, find if s follows the same pattern. 
//
// Here follow means a full match, such that there is a bijection between a 
//letter in pattern and a non-empty word in s. 
//
// 
// Example 1: 
//
// 
//Input: pattern = "abba", s = "dog cat cat dog"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: pattern = "abba", s = "dog cat cat fish"
//Output: false
// 
//
// Example 3: 
//
// 
//Input: pattern = "aaaa", s = "dog cat cat dog"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= pattern.length <= 300 
// pattern contains only lower-case English letters. 
// 1 <= s.length <= 3000 
// s contains only lowercase English letters and spaces ' '. 
// s does not contain any leading or trailing spaces. 
// All the words in s are separated by a single space. 
// 
//
// Related Topics Hash Table String 👍 7261 👎 1029


@Slf4j
public class WordPattern_290 {

    @Test
    void test() {
        log.info("result: {}", new Solution().wordPattern("abba", "dog cat cat dog"));
//        log.info("result: {}", new Solution().wordPattern("abba", "dog cat cat fish"));
//        log.info("result: {}", new Solution().wordPattern("abba", "dog dog dog dog"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] words = s.split(" ");

            if (pattern.length() != words.length) {
                return false;
            }

            Map<Character, String> charToWordMap = new HashMap<>();
            Map<String, Character> wordToCharMap = new HashMap<>();

            for (int i = 0; i < words.length; i++) {
                if (charToWordMap.containsKey(pattern.charAt(i))) {
                    if (!charToWordMap.get(pattern.charAt(i)).equals(words[i])) {
                        return false;
                    }
                } else {
                    charToWordMap.put(pattern.charAt(i), words[i]);
                }

                if (wordToCharMap.containsKey(words[i])) {
                    if (wordToCharMap.get(words[i]) != pattern.charAt(i)) {
                        return false;
                    }
                } else {
                    wordToCharMap.put(words[i], pattern.charAt(i));
                }
            }

            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}