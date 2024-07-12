package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

//Given the head of a linked list and an integer val, remove all the nodes of 
//the linked list that has Node.val == val, and return the new head. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,6,3,4,5,6], val = 6
//Output: [1,2,3,4,5]
// 
//
// Example 2: 
//
// 
//Input: head = [], val = 1
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [7,7,7,7], val = 7
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 10⁴]. 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
//
// Related Topics Linked List Recursion 👍 8291 👎 239


@Slf4j
public class RemoveLinkedListElements_203 {

    @Test
    void test() {
        log.info("result: {}", new Solution().removeElements(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(6, new ListNode(4, new ListNode(5, new ListNode(6))))))), 6));
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
        public ListNode removeElements(ListNode head, int val) {
            // 더미 노드를 사용하여 헤드 노드도 쉽게 제거할 수 있도록 함
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode current = dummy;

            while (current.next != null) {
                if (current.next.val == val) {
                    // 현재 노드의 다음 노드가 제거할 값과 일치하면, 그 노드를 건너뜀
                    current.next = current.next.next;
                } else {
                    // 그렇지 않으면 다음 노드로 이동
                    current = current.next;
                }
            }

            // 실제 헤드를 반환
            return dummy.next;
        }

        public ListNode removeElements2(ListNode head, int val) {
            if (head == null) {
                return null;
            }

            head.next = removeElements2(head.next, val);

            return head.val == val ? head.next : head;
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