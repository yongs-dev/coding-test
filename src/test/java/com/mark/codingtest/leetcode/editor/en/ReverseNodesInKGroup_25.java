package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//Given the head of a linked list, reverse the nodes of the list k at a time, 
//and return the modified list. 
//
// k is a positive integer and is less than or equal to the length of the 
//linked list. If the number of nodes is not a multiple of k then left-out nodes, in 
//the end, should remain as it is. 
//
// You may not alter the values in the list's nodes, only nodes themselves may 
//be changed. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,3,4,5], k = 2
//Output: [2,1,4,3,5]
// 
//
// Example 2: 
// 
// 
//Input: head = [1,2,3,4,5], k = 3
//Output: [3,2,1,4,5]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is n. 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
// Follow-up: Can you solve the problem in O(1) extra memory space? 
//
// Related Topics Linked List Recursion 👍 13925 👎 724


@Slf4j
public class ReverseNodesInKGroup_25 {

    @Test
    void test() {
        log.info("result: {}", new Solution().reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            // 먼저 리스트의 길이가 k보다 작은 경우를 처리하기 위해
            ListNode current = head;
            int count = 0;

            // 남은 노드가 k보다 적은지 확인
            while (current != null && count < k) {
                current = current.next;
                count++;
            }

            // 만약 k개의 노드를 다 찾았다면, 뒤집기 시작
            if (count == k) {
                // k개의 노드를 뒤집은 후의 head를 저장
                ListNode reversedHead = reverse(head, k);

                // 나머지 부분도 같은 방식으로 뒤집기
                head.next = reverseKGroup(current, k);

                // 뒤집힌 리스트의 head를 반환
                return reversedHead;
            }

            // k개의 노드를 다 못 모으면, 남은 부분은 그대로 둡니다.
            return head;
        }

        private ListNode reverse(ListNode head, int k) {
            ListNode prev = null;
            ListNode current = head;
            while (k > 0) {
                ListNode nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
                k--;
            }
            return prev; // 뒤집힌 리스트의 새로운 head 반환
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}