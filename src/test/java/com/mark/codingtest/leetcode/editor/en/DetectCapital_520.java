package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//We define the usage of capitals in a word to be right when one of the 
//following cases holds: 
//
// 
// All letters in this word are capitals, like "USA". 
// All letters in this word are not capitals, like "leetcode". 
// Only the first letter in this word is capital, like "Google". 
// 
//
// Given a string word, return true if the usage of capitals in it is right. 
//
// 
// Example 1: 
// Input: word = "USA"
//Output: true
// 
// Example 2: 
// Input: word = "FlaG"
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= word.length <= 100 
// word consists of lowercase and uppercase English letters. 
// 
//
// Related Topics String 👍 3414 👎 462


@Slf4j
public class DetectCapital_520 {

    @Test
    void test() {
        log.info("result: {}", new Solution().detectCapitalUse("USA"));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean detectCapitalUse(String word) {
            if (word.equals(word.toUpperCase())) {
                return true;
            }

            if (word.equals(word.toLowerCase())) {
                return true;
            }

            return Character.isUpperCase(word.charAt(0)) && word.substring(1).equals(word.substring(1).toLowerCase());
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}