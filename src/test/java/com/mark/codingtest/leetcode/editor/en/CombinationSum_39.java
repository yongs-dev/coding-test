package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

//Given an array of distinct integers candidates and a target integer target, 
//return a list of all unique combinations of candidates where the chosen numbers 
//sum to target. You may return the combinations in any order. 
//
// The same number may be chosen from candidates an unlimited number of times. 
//Two combinations are unique if the frequency of at least one of the chosen 
//numbers is different. 
//
// The test cases are generated such that the number of unique combinations 
//that sum up to target is less than 150 combinations for the given input. 
//
// 
// Example 1: 
//
// 
//Input: candidates = [2,3,6,7], target = 7
//Output: [[2,2,3],[7]]
//Explanation:
//2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple 
//times.
//7 is a candidate, and 7 = 7.
//These are the only two combinations.
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,3,5], target = 8
//Output: [[2,2,2,2],[2,3,3],[3,5]]
// 
//
// Example 3: 
//
// 
//Input: candidates = [2], target = 1
//Output: []
// 
//
// 
// Constraints: 
//
// 
// 1 <= candidates.length <= 30 
// 2 <= candidates[i] <= 40 
// All elements of candidates are distinct. 
// 1 <= target <= 40 
// 
//
// Related Topics Array Backtracking 👍 19169 👎 441


@Slf4j
public class CombinationSum_39 {

    @Test
    void test() {
        log.info("result: {}", new Solution().combinationSum(new int[] {2,3,5}, 8));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            backtrack(candidates, target, 0, new ArrayList<>(), result);
            return result;
        }

        private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
            // 만약 target이 0이 되면, 현재의 조합이 유효하다는 의미이므로 결과에 추가
            if (target == 0) {
                result.add(new ArrayList<>(current));
                return;
            }

            // 후보 숫자들을 순회하며 조합 생성
            for (int i = start; i < candidates.length; i++) {
                // 현재 숫자를 선택
                int candidate = candidates[i];
                // target이 candidate보다 작으면 탐색 종료 (가지치기)
                if (target < candidate) {
                    continue;
                }
                current.add(candidate);
                // 같은 숫자를 다시 사용할 수 있으므로, i를 그대로 전달하며 재귀 호출
                backtrack(candidates, target - candidate, i, current, result);
                // 이전 상태로 되돌아가기 위해 추가한 숫자를 제거
                current.remove(current.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}