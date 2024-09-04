package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//You are given row x col grid representing a map where grid[i][j] = 1 
//represents land and grid[i][j] = 0 represents water. 
//
// Grid cells are connected horizontally/vertically (not diagonally). The grid 
//is completely surrounded by water, and there is exactly one island (i.e., one or 
//more connected land cells). 
//
// The island doesn't have "lakes", meaning the water inside isn't connected to 
//the water around the island. One cell is a square with side length 1. The grid 
//is rectangular, width and height don't exceed 100. Determine the perimeter of 
//the island. 
//
// 
// Example 1: 
// 
// 
//Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
//Output: 16
//Explanation: The perimeter is the 16 yellow stripes in the image above.
// 
//
// Example 2: 
//
// 
//Input: grid = [[1]]
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: grid = [[1,0]]
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// row == grid.length 
// col == grid[i].length 
// 1 <= row, col <= 100 
// grid[i][j] is 0 or 1. 
// There is exactly one island in grid. 
// 
//
// Related Topics Array Depth-First Search Breadth-First Search Matrix 👍 6860 ?
//? 390


@Slf4j
public class IslandPerimeter_463 {

    @Test
    void test() {
        log.info("result: {}", new Solution().islandPerimeter(new int[][] {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        }));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int islandPerimeter(int[][] grid) {
            int perimeter = 0;
            int rows = grid.length;
            int cols = grid[0].length;

            // 각 셀을 순회하면서 육지(1)를 찾습니다.
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    // 육지인 경우
                    if (grid[i][j] == 1) {
                        // 상
                        if (i == 0 || grid[i - 1][j] == 0) perimeter++;
                        // 하
                        if (i == rows - 1 || grid[i + 1][j] == 0) perimeter++;
                        // 좌
                        if (j == 0 || grid[i][j - 1] == 0) perimeter++;
                        // 우
                        if (j == cols - 1 || grid[i][j + 1] == 0) perimeter++;
                    }
                }
            }

            return perimeter;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}