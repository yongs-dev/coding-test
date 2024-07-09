package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//A phrase is a palindrome if, after converting all uppercase letters into 
//lowercase letters and removing all non-alphanumeric characters, it reads the same 
//forward and backward. Alphanumeric characters include letters and numbers. 
//
// Given a string s, return true if it is a palindrome, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
// 
//
// Example 2: 
//
// 
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric 
//characters.
//Since an empty string reads the same forward and backward, it is a palindrome.
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// s consists only of printable ASCII characters. 
// 
//
// Related Topics Two Pointers String 👍 9322 👎 8349


@Slf4j
public class ValidPalindrome_125 {

    @Test
    void test() {
        log.info("result: {}", new Solution().isPalindrome("A man, a plan, a canal: Panama"));
        log.info("result: {}", new Solution().isPalindrome("race a car"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            if (s == null || s.isEmpty()) return true;
            s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

            int left = 0, right = s.length() - 1;

            while (left < right) {
                if (s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }

            return true;
        }

        public boolean isPalindrome2(String s) {
            // 1. 문자열을 소문자로 변환하고 알파벳과 숫자 이외의 문자를 제거합니다.
            StringBuilder cleanedString = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (Character.isLetterOrDigit(c)) {
                    cleanedString.append(Character.toLowerCase(c));
                }
            }

            // 2. 정방향과 역방향 문자열을 비교합니다.
            String cleaned = cleanedString.toString();
            String reversed = cleanedString.reverse().toString();

            return cleaned.equals(reversed);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}