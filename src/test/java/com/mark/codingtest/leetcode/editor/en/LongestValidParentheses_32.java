package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Stack;

//Given a string containing just the characters '(' and ')', return the length 
//of the longest valid (well-formed) parentheses substring. 
//
// 
// Example 1: 
//
// 
//Input: s = "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()".
// 
//
// Example 2: 
//
// 
//Input: s = ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()".
// 
//
// Example 3: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] is '(', or ')'. 
// 
//
// Related Topics String Dynamic Programming Stack 👍 12483 👎 417


@Slf4j
public class LongestValidParentheses_32 {

    @Test
    void test() {
//        log.info("result: {}", new Solution().longestValidParentheses("(()"));
//        log.info("result: {}", new Solution().longestValidParentheses(")()())"));
        log.info("result: {}", new Solution().longestValidParentheses("()(())"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);  // 스택 초기화, 유효한 괄호 범위를 계산하기 위해 -1을 넣음
            int maxLength = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);  // 여는 괄호일 때 현재 인덱스를 스택에 추가
                } else {
                    stack.pop();  // 닫는 괄호일 때 스택에서 하나를 pop
                    if (stack.isEmpty()) {
                        stack.push(i);  // 스택이 비었다면 현재 인덱스를 추가
                    } else {
                        maxLength = Math.max(maxLength, i - stack.peek());  // 유효한 길이를 계산
                    }
                }
            }

            return maxLength;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}