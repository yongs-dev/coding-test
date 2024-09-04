package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//You have n coins and you want to build a staircase with these coins. The 
//staircase consists of k rows where the iᵗʰ row has exactly i coins. The last row of 
//the staircase may be incomplete. 
//
// Given the integer n, return the number of complete rows of the staircase you 
//will build. 
//
// 
// Example 1: 
// 
// 
//Input: n = 5
//Output: 2
//Explanation: Because the 3ʳᵈ row is incomplete, we return 2.
// 
//
// Example 2: 
// 
// 
//Input: n = 8
//Output: 3
//Explanation: Because the 4ᵗʰ row is incomplete, we return 3.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
//
// Related Topics Math Binary Search 👍 3894 👎 1333


@Slf4j
public class ArrangingCoins_441 {

    @Test
    void test() {
        log.info("result: {}", new Solution().arrangeCoins(5));
//        log.info("result: {}", new Solution().arrangeCoins(8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * <b>Binary Search</b>
         */
        public int arrangeCoins(int n) {
            int start = 0;
            int end = n;

            while (start <= end) {
                long mid = start + (end - start) / 2;
                long current = mid * (mid + 1) / 2;  // k번째 행을 만들려면 1 + 2 + 3 + ... + k개의 동전이 필요. 이 합은 등차수열의 합 공식을 사용하여 계산

                if (current == n) {
                    return (int) mid;         // 정확히 n개의 동전을 사용하여 계단을 만들 수 있는 경우
                } else if (current < n) {
                    start = (int) mid + 1;    // 더 많은 행을 만들 수 있는 경우
                } else {
                    end = (int) mid - 1;      // 너무 많은 동전을 사용한 경우
                }
            }

            return end;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}