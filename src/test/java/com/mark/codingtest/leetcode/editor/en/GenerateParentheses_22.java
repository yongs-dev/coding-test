package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given n pairs of parentheses, write a function to generate all combinations 
//of well-formed parentheses. 
//
// 
// Example 1: 
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// 
// Example 2: 
// Input: n = 1
//Output: ["()"]
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics String Dynamic Programming Backtracking 👍 21375 👎 975


@Slf4j
public class GenerateParentheses_22 {

    @Test
    void test() {
        log.info("result: {}", new Solution().generateParenthesis(2));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            backtrack(result, "", 0, 0, n);
            return result;
        }

        private void backtrack(List<String> result, String current, int open, int close, int max) {
            // 조건 : 만약 현재 괄호 초합이 최대 길이에 도달하면 결과에 추가
            if (current.length() == max * 2) {
                result.add(current);
                return;
            }

            // 열림 괄호가 max보다 작으면 여는 괄호 추가
            if (open < max) {
                backtrack(result, current + "(", open + 1, close, max);
            }

            // 닫는 괄호가 열림 괄호보다 적으면 닫는 괄호 추가
            if (close < open) {
                backtrack(result, current + ")", open, close + 1, max);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}