package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

//Given a string s, return the number of segments in the string. 
//
// A segment is defined to be a contiguous sequence of non-space characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "Hello, my name is John"
//Output: 5
//Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]
// 
//
// Example 2: 
//
// 
//Input: s = "Hello"
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 300 
// s consists of lowercase and uppercase English letters, digits, or one of the 
//following characters "!@#$%^&*()_+-=',.:". 
// The only space character in s is ' '. 
// 
//
// Related Topics String 👍 793 👎 1266


@Slf4j
public class NumberOfSegmentsInAString_434 {

    @Test
    void test() {
        log.info("result: {}", new Solution().countSegments(", , , ,        a, eaefa"));
//        log.info("result: {}", new Solution().countSegments("Hello, my name is John"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSegments(String s) {
            if (s == null || s.isEmpty()) return 0;

            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                // 새로운 세그먼트의 시작을 발견했을 때
                if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                    count++;
                }
            }

            return count;
        }

        public int countSegmentsUsingSplit(String s) {
            if (s == null || s.isEmpty()) return 0;

            String[] array = s.split(" ");
            List<String> result = new ArrayList<>();

            for (String str : array) {
                if (!str.isEmpty()) {
                    result.add(str);
                }
            }

            return result.size();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}