package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//The Hamming distance between two integers is the number of positions at which 
//the corresponding bits are different. 
//
// Given two integers x and y, return the Hamming distance between them. 
//
// 
// Example 1: 
//
// 
//Input: x = 1, y = 4
//Output: 2
//Explanation:
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//The above arrows point to positions where the corresponding bits are 
//different.
// 
//
// Example 2: 
//
// 
//Input: x = 3, y = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 0 <= x, y <= 2³¹ - 1 
// 
//
// Related Topics Bit Manipulation 👍 3849 👎 218


@Slf4j
public class HammingDistance_461 {

    @Test
    void test() {
        log.info("result: {}", new Solution().hammingDistance(1, 4));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hammingDistance(int x, int y) {
            int xor = x ^ y;    // x와 y의 XOR 연산 결과
            int count = 0;      // 해밍 거리를 저장할 변수

            // XOR 결과에서 1의 개수를 셈
            while (xor != 0) {
                count += xor & 1;  // 최하위 비트가 1인지 확인하고 count 증가
                xor >>= 1;         // 비트를 오른쪽으로 이동하여 다음 비트를 검사
            }

            return count;  // 해밍 거리 반환
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}