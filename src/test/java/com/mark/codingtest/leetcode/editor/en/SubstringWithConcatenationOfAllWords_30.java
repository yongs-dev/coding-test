package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;

//You are given a string s and an array of strings words. All the strings of 
//words are of the same length. 
//
// A concatenated string is a string that exactly contains all the strings of 
//any permutation of words concatenated. 
//
// 
// For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", 
//"cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not 
//a concatenated string because it is not the concatenation of any permutation of 
//words. 
// 
//
// Return an array of the starting indices of all the concatenated substrings 
//in s. You can return the answer in any order. 
//
// 
// Example 1: 
//
// 
// Input: s = "barfoothefoobarman", words = ["foo","bar"] 
// 
//
// Output: [0,9] 
//
// Explanation: 
//
// The substring starting at 0 is "barfoo". It is the concatenation of ["bar",
//"foo"] which is a permutation of words. The substring starting at 9 is "foobar". 
//It is the concatenation of ["foo","bar"] which is a permutation of words. 
//
// Example 2: 
//
// 
// Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"] 
//
// 
//
// Output: [] 
//
// Explanation: 
//
// There is no concatenated substring. 
//
// Example 3: 
//
// 
// Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"] 
// 
//
// Output: [6,9,12] 
//
// Explanation: 
//
// The substring starting at 6 is "foobarthe". It is the concatenation of [
//"foo","bar","the"]. The substring starting at 9 is "barthefoo". It is the 
//concatenation of ["bar","the","foo"]. The substring starting at 12 is "thefoobar". It is 
//the concatenation of ["the","foo","bar"]. 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// s and words[i] consist of lowercase English letters. 
// 
//
// Related Topics Hash Table String Sliding Window 👍 1950 👎 288


@Slf4j
public class SubstringWithConcatenationOfAllWords_30 {

    @Test
    void test() {
//        log.info("result: {}", new Solution().findSubstring("barfoothefoobarman", new String[] {"foo", "bar"}));
        log.info("result: {}", new Solution().findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","good"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * <b>Slide-Window</b>
         */
        public List<Integer> findSubstring(String s, String[] words) {
            Map<String, Integer> wordCountMap = new HashMap<>();
            for (String word : words) {
                wordCountMap.merge(word, 1, Integer::sum);
            }

            int stringLength = s.length();
            int wordCount = words.length;
            int wordLength = words[0].length();
            List<Integer> result = new ArrayList<>();

            // 슬라이딩 윈도우를 wordLength 단위로 나누어 처리
            for (int i = 0; i < wordLength; ++i) {
                Map<String, Integer> seenWordsMap = new HashMap<>();
                int left = i, right = i;
                int matchedWordCount = 0;

                while (right + wordLength <= stringLength) {
                    String currentWord = s.substring(right, right + wordLength);
                    right += wordLength;

                    // 현재 단어가 wordCountMap에 없는 경우
                    if (!wordCountMap.containsKey(currentWord)) {
                        seenWordsMap.clear();  // 일치하지 않으면 초기화
                        left = right;          // 왼쪽 포인터 이동
                        matchedWordCount = 0;  // 매칭된 단어 수 초기화
                        continue;
                    }

                    // 단어 빈도 증가
                    seenWordsMap.merge(currentWord, 1, Integer::sum);
                    matchedWordCount++;

                    // 현재 단어의 빈도가 wordCountMap에서 지정한 빈도보다 많은 경우
                    while (seenWordsMap.get(currentWord) > wordCountMap.get(currentWord)) {
                        String leftWord = s.substring(left, left + wordLength);
                        seenWordsMap.put(leftWord, seenWordsMap.get(leftWord) - 1);
                        left += wordLength;
                        matchedWordCount--;
                    }

                    // 모든 단어가 매칭된 경우 시작 인덱스를 결과 리스트에 추가
                    if (matchedWordCount == wordCount) {
                        result.add(left);
                    }
                }
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}