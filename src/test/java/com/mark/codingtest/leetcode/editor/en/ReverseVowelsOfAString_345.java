package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

//Given a string s, reverse only all the vowels in the string and return it. 
//
// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both 
//lower and upper cases, more than once. 
//
// 
// Example 1: 
// Input: s = "hello"
//Output: "holle"
// 
// Example 2: 
// Input: s = "leetcode"
//Output: "leotcede"
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s consist of printable ASCII characters. 
// 
//
// Related Topics Two Pointers String 👍 4588 👎 2790


@Slf4j
public class ReverseVowelsOfAString_345 {

    @Test
    void test() {
        log.info("result: {}", new Solution().reverseVowels("hello"));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            char[] chars = s.toCharArray();
            int left = 0;
            int right = s.length() - 1;

            while (left < right) {
                while (left < right && !isVowel(s.charAt(left))) {
                    left++;
                }

                while (left < right && !isVowel(s.charAt(right))) {
                    right--;
                }

                if (left < right) {
                    char temp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = temp;

                    left++;
                    right--;
                }
            }

            return new String(chars);
        }

        private boolean isVowel(char c) {
            return "AEIOUaeiou".indexOf(c) > -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}