package com.mark.codingtest.leetcode.editor.en;

import org.junit.jupiter.api.Test;

//Given two strings needle and haystack, return the index of the first 
//occurrence of needle in haystack, or -1 if needle is not part of haystack. 
//
// 
// Example 1: 
//
// 
//Input: haystack = "sadbutsad", needle = "sad"
//Output: 0
//Explanation: "sad" occurs at index 0 and 6.
//The first occurrence is at index 0, so we return 0.
// 
//
// Example 2: 
//
// 
//Input: haystack = "leetcode", needle = "leeto"
//Output: -1
//Explanation: "leeto" did not occur in "leetcode", so we return -1.
// 
//
// 
// Constraints: 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack and needle consist of only lowercase English characters. 
// 
//
// Related Topics Two Pointers String String Matching 👍 5751 👎 403


public class FindTheIndexOfTheFirstOccurrenceInAString_28 {

    @Test
    void test() {
        new Solution().strStr("sadbutsad", "sad");
        new Solution().strStr("leetcode", "leeto");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            return haystack.indexOf(needle);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}