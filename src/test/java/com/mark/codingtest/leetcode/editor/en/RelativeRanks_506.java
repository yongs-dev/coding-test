package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

//You are given an integer array score of size n, where score[i] is the score 
//of the iᵗʰ athlete in a competition. All the scores are guaranteed to be unique. 
//
// The athletes are placed based on their scores, where the 1ˢᵗ place athlete 
//has the highest score, the 2ⁿᵈ place athlete has the 2ⁿᵈ highest score, and so on.
// The placement of each athlete determines their rank: 
//
// 
// The 1ˢᵗ place athlete's rank is "Gold Medal". 
// The 2ⁿᵈ place athlete's rank is "Silver Medal". 
// The 3ʳᵈ place athlete's rank is "Bronze Medal". 
// For the 4ᵗʰ place to the nᵗʰ place athlete, their rank is their placement 
//number (i.e., the xᵗʰ place athlete's rank is "x"). 
// 
//
// Return an array answer of size n where answer[i] is the rank of the iᵗʰ 
//athlete. 
//
// 
// Example 1: 
//
// 
//Input: score = [5,4,3,2,1]
//Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
//Explanation: The placements are [1ˢᵗ, 2ⁿᵈ, 3ʳᵈ, 4ᵗʰ, 5ᵗʰ]. 
//
// Example 2: 
//
// 
//Input: score = [10,3,8,9,4]
//Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
//Explanation: The placements are [1ˢᵗ, 5ᵗʰ, 3ʳᵈ, 2ⁿᵈ, 4ᵗʰ].
//
// 
//
// 
// Constraints: 
//
// 
// n == score.length 
// 1 <= n <= 10⁴ 
// 0 <= score[i] <= 10⁶ 
// All the values in score are unique. 
// 
//
// Related Topics Array Sorting Heap (Priority Queue) 👍 1932 👎 126


@Slf4j
public class RelativeRanks_506 {

    @Test
    void test() {
//        log.info("result: {}", new Solution().findRelativeRanks(new int[] {5, 4, 3, 2, 1}));
        log.info("result: {}", new Solution().findRelativeRanks(new int[] {1, 2, 3, 4, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findRelativeRanks(int[] score) {
            Integer[] indices = new Integer[score.length];
            for (int i = 0; i < score.length; i++) {
                indices[i] = i;
            }

            // 점수를 기준으로 내림차순 정렬
            Arrays.sort(indices, (a, b) -> Integer.compare(score[b], score[a]));

            // 결과 배열 초기화
            String[] result = new String[score.length];
            for (int i = 0; i < score.length; i++) {
                int rank = i + 1;
                if (rank == 1) {
                    result[indices[i]] = "Gold Medal";
                } else if (rank == 2) {
                    result[indices[i]] = "Silver Medal";
                } else if (rank == 3) {
                    result[indices[i]] = "Bronze Medal";
                } else {
                    result[indices[i]] = String.valueOf(rank);
                }
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}