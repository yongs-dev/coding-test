package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

//Given an integer rowIndex, return the rowIndexᵗʰ (0-indexed) row of the 
//Pascal's triangle. 
//
// In Pascal's triangle, each number is the sum of the two numbers directly 
//above it as shown: 
// 
// 
// Example 1: 
// Input: rowIndex = 3
//Output: [1,3,3,1]
// 
// Example 2: 
// Input: rowIndex = 0
//Output: [1]
//
// Example 3:
// Input: rowIndex = 1
//Output: [1,1]
// 
// 
// Constraints: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
// Follow up: Could you optimize your algorithm to use only O(rowIndex) extra 
//space? 
//
// Related Topics Array Dynamic Programming 👍 4808 👎 340


@Slf4j
public class PascalsTriangleIi_119 {

    @Test
    void test() {
        log.info("result: {}", new Solution().getRow(30));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> row = new ArrayList<>();
            row.add(1);

            for (int i = 1; i <= rowIndex; i++) {
                // 새 행을 채우기 위해 이전 행을 거꾸로 탐색
                for (int j = i - 1; j > 0; j--) {
                    row.set(j, row.get(j) + row.get(j - 1));
                }
                row.add(1);
            }

            return row;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}