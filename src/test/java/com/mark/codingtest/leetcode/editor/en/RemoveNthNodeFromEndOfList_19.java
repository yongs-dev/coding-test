package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

//Given the head of a linked list, remove the nᵗʰ node from the end of the list 
//and return its head. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1], n = 1
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1,2], n = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is sz. 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
// Follow up: Could you do this in one pass? 
//
// Related Topics Linked List Two Pointers 👍 19098 👎 818


@Slf4j
public class RemoveNthNodeFromEndOfList_19 {

    @Test
    void test() {
        log.info("result: {}", new Solution().removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3))), 2));
//        log.info("result: {}", new Solution().removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // Dummy node to handle edge cases like removing the first node
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            // Initialize two pointers, both starting at the dummy node
            ListNode fast = dummy;
            ListNode slow = dummy;

            // Move the fast pointer 'n' steps ahead
            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }

            // Move both fast and slow pointers until fast reaches the end
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }

            // Skip the node that is the nth from the end
            slow.next = slow.next.next;

            // Return the head of the modified list
            return dummy.next;
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