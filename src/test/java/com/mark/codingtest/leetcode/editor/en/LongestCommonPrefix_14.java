package com.mark.codingtest.leetcode.editor.en;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//Write a function to find the longest common prefix string amongst an array of 
//strings. 
//
// If there is no common prefix, return an empty string "". 
//
// 
// Example 1: 
//
// 
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
// 
//
// Example 2: 
//
// 
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
// 
//
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] consists of only lowercase English letters. 
// 
//
// Related Topics String Trie 👍 17414 👎 4527


public class LongestCommonPrefix_14 {

    @Test
    void test() {
        new Solution().longestCommonPrefix(new String[] {"flower", "flow", "flight"});
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }

            // 첫 번째 문자열을 기준으로 설정
            String prefix = strs[0];

            // 나머지 문자열들과 비교
            for (int i = 1; i < strs.length; i++) {
                // 공통 접두사가 더 이상 접두사가 아닐 때까지 줄임
                while (strs[i].indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                    // 공통 접두사가 없을 경우 빈 문자열 반환
                    if (prefix.isEmpty()) {
                        return "";
                    }
                }
            }

            return prefix;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}