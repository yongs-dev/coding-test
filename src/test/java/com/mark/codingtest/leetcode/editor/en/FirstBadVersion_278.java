package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//You are a product manager and currently leading a team to develop a new 
//product. Unfortunately, the latest version of your product fails the quality check. 
//Since each version is developed based on the previous version, all the versions 
//after a bad version are also bad. 
//
// Suppose you have n versions [1, 2, ..., n] and you want to find out the 
//first bad one, which causes all the following ones to be bad. 
//
// You are given an API bool isBadVersion(version) which returns whether 
//version is bad. Implement a function to find the first bad version. You should 
//minimize the number of calls to the API. 
//
// 
// Example 1: 
//
// 
//Input: n = 5, bad = 4
//Output: 4
//Explanation:
//call isBadVersion(3) -> false
//call isBadVersion(5) -> true
//call isBadVersion(4) -> true
//Then 4 is the first bad version.
// 
//
// Example 2: 
//
// 
//Input: n = 1, bad = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= bad <= n <= 2³¹ - 1 
// 
//
// Related Topics Binary Search Interactive 👍 8377 👎 3309


@Slf4j
public class FirstBadVersion_278 {

//    @Test
//    void test() {
//        log.info("result: {}", new Solution());
//    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /* The isBadVersion API is defined in the parent class VersionControl.
          boolean isBadVersion(int version); */
//    public class Solution extends VersionControl {
//        public int firstBadVersion(int n) {
//            int left = 1;
//            int right = n;
//
//            while (left < right) {
//                int mid = left + (right - left) / 2; // (left + right) / 2 하면 오버플로우 발생 가능
//                if (isBadVersion(mid)) {
//                    right = mid; // mid가 불량이면 첫 불량 버전은 mid 이하에 있음
//                } else {
//                    left = mid + 1; // mid가 불량이 아니면 첫 불량 버전은 mid보다 큰 값에 있음
//                }
//            }
//
//            return left; // left == right일 때, 첫 번째 불량 버전을 찾음
//        }
//    }
    //leetcode submit region end(Prohibit modification and deletion)

}