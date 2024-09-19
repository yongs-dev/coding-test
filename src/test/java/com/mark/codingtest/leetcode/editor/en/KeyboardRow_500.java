package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

//Given an array of strings words, return the words that can be typed using 
//letters of the alphabet on only one row of American keyboard like the image below. 
//
// In the American keyboard: 
//
// 
// the first row consists of the characters "qwertyuiop", 
// the second row consists of the characters "asdfghjkl", and 
// the third row consists of the characters "zxcvbnm". 
// 
// 
// 
// Example 1: 
//
// 
//Input: words = ["Hello","Alaska","Dad","Peace"]
//Output: ["Alaska","Dad"]
// 
//
// Example 2: 
//
// 
//Input: words = ["omk"]
//Output: []
// 
//
// Example 3: 
//
// 
//Input: words = ["adsdf","sfd"]
//Output: ["adsdf","sfd"]
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 20 
// 1 <= words[i].length <= 100 
// words[i] consists of English letters (both lowercase and uppercase). 
// 
//
// Related Topics Array Hash Table String 👍 1617 👎 1137


@Slf4j
public class KeyboardRow_500 {

    @Test
    void test() {
        log.info("result: {}", new Solution().findWords(new String[] {"Hello","Alaska","Dad","Peace"}));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findWords(String[] words) {
            List<String> result = new ArrayList<>();

            Map<String, Integer> map = new HashMap<>();
            map.put("qwertyuiop", 0);
            map.put("asdfghjkl", 0);
            map.put("zxcvbnm", 0);

            for (String word : words) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    for (char c : word.toLowerCase().toCharArray()) {
                        if (entry.getKey().contains(String.valueOf(c))) {
                            map.put(entry.getKey(), map.get(entry.getKey()) + 1);
                        }
                    }

                    if (entry.getValue() == word.length()) {
                        result.add(word);
                    }

                    map.put(entry.getKey(), 0);
                }
            }

            return result.toArray(new String[0]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}