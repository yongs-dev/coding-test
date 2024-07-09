package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

//Given an integer numRows, return the first numRows of Pascal's triangle. 
//
// In Pascal's triangle, each number is the sum of the two numbers directly 
//above it as shown: 
// 
// 
// Example 1: 
// Input: numRows = 5
//Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
// Example 2: 
// Input: numRows = 1
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= numRows <= 30 
// 
//
// Related Topics Array Dynamic Programming 👍 12802 👎 449


@Slf4j
public class PascalsTriangle_118 {

    @Test
    void test() {
        log.info("result: {}", new Solution().generate(5));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> triangle = new ArrayList<>();

            if (numRows == 0) {
                return triangle;
            }

            // 첫 번째 줄 추가
            triangle.add(new ArrayList<>());
            triangle.get(0).add(1);

            // 두 번째 줄부터 numRows 까지 계산
            for (int i = 1; i < numRows; i++) {
                List<Integer> row = new ArrayList<>();
                List<Integer> prevRow = triangle.get(i - 1);

                // 첫 번째 숫자는 항상 1
                row.add(1);

                // 두 번째부터 마지막 바로 전까지의 숫자 계산
                for (int j = 1; j < i; j++) {
                    row.add(prevRow.get(j - 1) + prevRow.get(j));
                }

                // 마지막 숫자는 항상 1
                row.add(1);

                triangle.add(row);
            }

            return triangle;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}