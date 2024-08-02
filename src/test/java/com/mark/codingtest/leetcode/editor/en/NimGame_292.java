package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//You are playing the following Nim Game with your friend: 
//
// 
// Initially, there is a heap of stones on the table. 
// You and your friend will alternate taking turns, and you go first. 
// On each turn, the person whose turn it is will remove 1 to 3 stones from the 
//heap. 
// The one who removes the last stone is the winner. 
// 
//
// Given n, the number of stones in the heap, return true if you can win the 
//game assuming both you and your friend play optimally, otherwise return false. 
//
// 
// Example 1: 
//
// 
//Input: n = 4
//Output: false
//Explanation: These are the possible outcomes:
//1. You remove 1 stone. Your friend removes 3 stones, including the last stone.
// Your friend wins.
//2. You remove 2 stones. Your friend removes 2 stones, including the last 
//stone. Your friend wins.
//3. You remove 3 stones. Your friend removes the last stone. Your friend wins.
//In all outcomes, your friend wins.
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: true
// 
//
// Example 3: 
//
// 
//Input: n = 2
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
//
// Related Topics Math Brainteaser Game Theory 👍 1721 👎 2694


@Slf4j
public class NimGame_292 {

    @Test
    void test() {
        log.info("result: {}", new Solution().canWinNim(5));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * n이 4의 배수이면, 상대방이 항상 최적의 방법으로 돌을 가져가게 되어 당신은 이길 수 없습니다.
         * n이 4의 배수가 아니면, 당신이 최적의 방법으로 돌을 가져가게 되어 상대방을 이기게 됩니다.
         */
        public boolean canWinNim(int n) {
            return n % 4 != 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}