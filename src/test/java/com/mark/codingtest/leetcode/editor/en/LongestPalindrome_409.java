package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

//Given a string s which consists of lowercase or uppercase letters, return the 
//length of the longest palindrome that can be built with those letters. 
//
// Letters are case sensitive, for example, "Aa" is not considered a palindrome.
// 
//
// 
// Example 1: 
//
// 
//Input: s = "abccccdd"
//Output: 7
//Explanation: One longest palindrome that can be built is "dccaccd", whose 
//length is 7.
// 
//
// Example 2: 
//
// 
//Input: s = "a"
//Output: 1
//Explanation: The longest palindrome that can be built is "a", whose length is 
//1.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 2000 
// s consists of lowercase and/or uppercase English letters only. 
// 
//
// Related Topics Hash Table String Greedy 👍 5930 👎 412


@Slf4j
public class LongestPalindrome_409 {

    @Test
    void test() {
        log.info("result: {}", new Solution().longestPalindrome("aaabbbbccc"));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 짝수는 항상 사용 가능하며 홀수 개수의 문자는 중앙에 하나만 놓을 수 있고 나머지는 짝수로 만들어 대칭적으로 배치해야함
         */
        public int longestPalindrome(String s) {
            if (s.length() == 1) return 1;
            Map<Character, Integer> map = new HashMap<>();

            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            boolean hasOdd = false;
            int length = 0;

            for (int count : map.values()) {
                if (count % 2 == 0) {
                    length += count;
                } else {
                    length += count - 1;
                    hasOdd = true;
                }
            }

            if (hasOdd) {
                length++;
            }

            return length;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}