package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

//Given a string s, find the length of the longest substring without repeating 
//characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s consists of English letters, digits, symbols and spaces. 
// 
//
// Related Topics Hash Table String Sliding Window 👍 40212 👎 1927


@Slf4j
public class LongestSubstringWithoutRepeatingCharacters_3 {

    @Test
    void test() {
        log.info("result: {}", new Solution().lengthOfLongestSubstring("abcabcbb"));
//        log.info("result: {}", new Solution().lengthOfLongestSubstring("pwwkew"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> charIndexMap = new HashMap<>();
            int maxLength = 0;
            int left = 0;

            for (int right = 0; right < s.length(); right++) {
                char currentChar = s.charAt(right);

                // 중복된 문자가 있는 경우, 왼쪽 포인터를 이동하여 중복을 제거합니다.
                if (charIndexMap.containsKey(currentChar)) {
                    // 중복된 문자 위치가 현재 왼쪽 포인터보다 오른쪽에 있을 때만 이동합니다.
                    left = Math.max(left, charIndexMap.get(currentChar) + 1);
                }

                // 현재 문자의 위치를 업데이트합니다.
                charIndexMap.put(currentChar, right);

                // 현재 부분 문자열의 길이를 계산하고 최대 길이를 갱신합니다.
                maxLength = Math.max(maxLength, right - left + 1);
            }

            return maxLength;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}