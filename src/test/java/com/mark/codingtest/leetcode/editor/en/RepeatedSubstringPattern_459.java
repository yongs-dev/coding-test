package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//Given a string s, check if it can be constructed by taking a substring of it 
//and appending multiple copies of the substring together. 
//
// 
// Example 1: 
//
// 
//Input: s = "abab"
//Output: true
//Explanation: It is the substring "ab" twice.
// 
//
// Example 2: 
//
// 
//Input: s = "aba"
//Output: false
// 
//
// Example 3: 
//
// 
//Input: s = "abcabcabcabc"
//Output: true
//Explanation: It is the substring "abc" four times or the substring "abcabc" 
//twice.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of lowercase English letters. 
// 
//
// Related Topics String String Matching 👍 6420 👎 524


@Slf4j
public class RepeatedSubstringPattern_459 {

    @Test
    void test() {
        log.info("result: {}", new Solution().repeatedSubstringPattern("abab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 주어진 문자열 s가 반복되는 하위 문자열로 구성된 경우, 그 하위 문자열이 반복되면 두 번 연결된 문자열 s + s는 <br>
         * 그 하위 문자열이 적어도 두 번 이상 나타나는 구조를 갖는다.
         */
        public boolean repeatedSubstringPattern(String s) {
            String ss = s + s;
            String modifiedSS = ss.substring(1, ss.length() - 1);

            return modifiedSS.contains(s);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}