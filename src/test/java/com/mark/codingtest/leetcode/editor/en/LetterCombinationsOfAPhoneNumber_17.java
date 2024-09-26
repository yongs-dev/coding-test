package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given a string containing digits from 2-9 inclusive, return all possible 
//letter combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digits to letters (just like on the telephone buttons) is given 
//below. Note that 1 does not map to any letters. 
// 
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = ""
//Output: []
// 
//
// Example 3: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// 
//
// Related Topics Hash Table String Backtracking 👍 18859 👎 1017


@Slf4j
public class LetterCombinationsOfAPhoneNumber_17 {

    @Test
    void test() {
        log.info("result: {}", new Solution().letterCombinations("23"));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final String[] MAPPINGS = {
                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        /**
         * <b>back tracking</b>
         */
        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();

            if (digits == null || digits.isEmpty()) {
                return result;
            }

            backTrack(result, new StringBuilder(), digits, 0);
            return result;
        }

        private void backTrack(List<String> result, StringBuilder combination, String digits, int index) {
            // 조합이 완성되었을 때
            if (index == digits.length()) {
                result.add(combination.toString());
            } else {
                String letters = MAPPINGS[digits.charAt(index) - '0'];

                for (char letter : letters.toCharArray()) {
                    combination.append(letter);
                    backTrack(result, combination, digits, index + 1);
                    combination.deleteCharAt(combination.length() - 1);
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}