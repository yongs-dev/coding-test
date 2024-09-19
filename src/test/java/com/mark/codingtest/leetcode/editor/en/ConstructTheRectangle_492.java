package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//A web developer needs to know how to design a web page's size. So, given a 
//specific rectangular web page’s area, your job by now is to design a rectangular 
//web page, whose length L and width W satisfy the following requirements: 
//
// 
// The area of the rectangular web page you designed must equal to the given 
//target area. 
// The width W should not be larger than the length L, which means L >= W. 
// The difference between length L and width W should be as small as possible. 
// 
//
// Return an array [L, W] where L and W are the length and width of the web 
//page you designed in sequence. 
//
// 
// Example 1: 
//
// 
//Input: area = 4
//Output: [2,2]
//Explanation: The target area is 4, and all the possible ways to construct it 
//are [1,4], [2,2], [4,1]. 
//But according to requirement 2, [1,4] is illegal; according to requirement 3, 
// [4,1] is not optimal compared to [2,2]. So the length L is 2, and the width W 
//is 2.
// 
//
// Example 2: 
//
// 
//Input: area = 37
//Output: [37,1]
// 
//
// Example 3: 
//
// 
//Input: area = 122122
//Output: [427,286]
// 
//
// 
// Constraints: 
//
// 
// 1 <= area <= 10⁷ 
// 
//
// Related Topics Math 👍 705 👎 392


@Slf4j
public class ConstructTheRectangle_492 {

    @Test
    void test() {
        log.info("result: {}", new Solution().constructRectangle(4));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] constructRectangle(int area) {
            // 가능한 최대 너비는 √area부터 시작
            int W = (int) Math.sqrt(area);

            // 너비 W를 감소시키면서 나눠 떨어지는 값을 찾음
            while (area % W != 0) {
                W--;
            }

            // 나눠 떨어졌을 때 L을 계산
            int L = area / W;

            // L ≥ W를 만족하는 값 반환
            return new int[]{L, W};
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}