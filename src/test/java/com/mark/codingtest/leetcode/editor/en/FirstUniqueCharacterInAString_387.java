package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

//Given a string s, find the first non-repeating character in it and return its 
//index. If it does not exist, return -1. 
//
// 
// Example 1: 
// Input: s = "leetcode"
//Output: 0
// 
// Example 2: 
// Input: s = "loveleetcode"
//Output: 2
// 
// Example 3: 
// Input: s = "aabb"
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists of only lowercase English letters. 
// 
//
// Related Topics Hash Table String Queue Counting 👍 8992 👎 298


@Slf4j
public class FirstUniqueCharacterInAString_387 {

    @Test
    void test() {
        log.info("result: {}", new Solution().firstUniqChar("aabb"));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * <b>String Index</b>
         */
        public int firstUniqChar(String s) {
            if (s == null || s.isEmpty()) return -1;

            for (int i = 0; i < s.length(); i++) {
                if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                    return i;
                }
            }

            return -1;
        }

        /**
         * <b>Hash Table</b>
         */
        public int firstUniqCharUsingHashTable(String s) {
            if (s == null || s.isEmpty()) return -1;

            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }

            for (int i = 0; i < s.length(); i++) {
                if (map.get(s.charAt(i)) == 1) {
                    return i;
                }
            }

            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}