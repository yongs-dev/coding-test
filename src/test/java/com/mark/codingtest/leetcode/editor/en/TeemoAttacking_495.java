package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//Our hero Teemo is attacking an enemy Ashe with poison attacks! When Teemo 
//attacks Ashe, Ashe gets poisoned for a exactly duration seconds. More formally, an 
//attack at second t will mean Ashe is poisoned during the inclusive time interval 
//[t, t + duration - 1]. If Teemo attacks again before the poison effect ends, 
//the timer for it is reset, and the poison effect will end duration seconds after 
//the new attack. 
//
// You are given a non-decreasing integer array timeSeries, where timeSeries[i] 
//denotes that Teemo attacks Ashe at second timeSeries[i], and an integer 
//duration. 
//
// Return the total number of seconds that Ashe is poisoned. 
//
// 
// Example 1: 
//
// 
//Input: timeSeries = [1,4], duration = 2
//Output: 4
//Explanation: Teemo's attacks on Ashe go as follows:
//- At second 1, Teemo attacks, and Ashe is poisoned for seconds 1 and 2.
//- At second 4, Teemo attacks, and Ashe is poisoned for seconds 4 and 5.
//Ashe is poisoned for seconds 1, 2, 4, and 5, which is 4 seconds in total.
// 
//
// Example 2: 
//
// 
//Input: timeSeries = [1,2], duration = 2
//Output: 3
//Explanation: Teemo's attacks on Ashe go as follows:
//- At second 1, Teemo attacks, and Ashe is poisoned for seconds 1 and 2.
//- At second 2 however, Teemo attacks again and resets the poison timer. Ashe 
//is poisoned for seconds 2 and 3.
//Ashe is poisoned for seconds 1, 2, and 3, which is 3 seconds in total. 
//
// 
// Constraints: 
//
// 
// 1 <= timeSeries.length <= 10⁴ 
// 0 <= timeSeries[i], duration <= 10⁷ 
// timeSeries is sorted in non-decreasing order. 
// 
//
// Related Topics Array Simulation 👍 1161 👎 129


@Slf4j
public class TeemoAttacking_495 {

    @Test
    void test() {
//        log.info("result: {}", new Solution().findPoisonedDuration(new int[] {1, 4}, 2));
        log.info("result: {}", new Solution().findPoisonedDuration(new int[] {1,3,5,7,9,11,13,15}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPoisonedDuration(int[] timeSeries, int duration) {
            int poisoning = 0;

            for (int i = 0; i < timeSeries.length - 1; i++) {
                poisoning += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
            }

            return poisoning + duration;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}