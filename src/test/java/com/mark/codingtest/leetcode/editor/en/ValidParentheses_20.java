package com.mark.codingtest.leetcode.editor.en;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// Every close bracket has a corresponding open bracket of the same type. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: s = "(]"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of parentheses only '()[]{}'. 
// 
//
// Related Topics String Stack 👍 23872 👎 1744


public class ValidParentheses_20 {

    @Test
    void test() {
        new Solution().isValid("(]");
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            // 스택을 사용하여 여는 괄호를 추적
            Stack<Character> stack = new Stack<>();

            // 문자열을 순회하면서 괄호를 처리
            for (char c : s.toCharArray()) {
                // 여는 괄호를 만나면 스택에 푸시
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                }
                // 닫는 괄호를 만나면 매칭 여부 확인
                else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char top = stack.pop();
                    if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                        return false;
                    }
                }
            }

            // 모든 괄호가 매칭되었는지 확인
            return stack.isEmpty();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}