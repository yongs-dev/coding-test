package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

//A binary watch has 4 LEDs on the top to represent the hours (0-11), and 6 
//LEDs on the bottom to represent the minutes (0-59). Each LED represents a zero or 
//one, with the least significant bit on the right. 
//
// 
// For example, the below binary watch reads "4:51". 
// 
//
// 
//
// Given an integer turnedOn which represents the number of LEDs that are 
//currently on (ignoring the PM), return all possible times the watch could represent. 
//You may return the answer in any order. 
//
// The hour must not contain a leading zero. 
//
// 
// For example, "01:00" is not valid. It should be "1:00". 
// 
//
// The minute must consist of two digits and may contain a leading zero. 
//
// 
// For example, "10:2" is not valid. It should be "10:02". 
// 
//
// 
// Example 1: 
// Input: turnedOn = 1
//Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00
//"]
// 
// Example 2: 
// Input: turnedOn = 9
//Output: []
// 
// 
// Constraints: 
//
// 
// 0 <= turnedOn <= 10 
// 
//
// Related Topics Backtracking Bit Manipulation 👍 1403 👎 2578


@Slf4j
public class BinaryWatch_401 {

    @Test
    void test() {
        log.info("result: {}", new Solution().readBinaryWatch(1));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * <b>Brute Force</b>
         */
        public List<String> readBinaryWatch(int turnedOn) {
            List<String> result = new ArrayList<>();

            // 시(hour)는 0부터 11까지 가능 (4비트)
            // 분(minute)은 0부터 59까지 가능 (6비트)
            for (int hour = 0; hour < 12; hour++) {
                for (int minute = 0; minute < 60; minute++) {
                    // 현재 시간(hour)와 분(minute)의 켜진 LED 수를 확인
                    if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                        // 유효한 시간 포맷으로 추가
                        result.add(String.format("%d:%02d", hour, minute));
                    }
                }
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}