package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

//Given a linked list, swap every two adjacent nodes and return its head. You 
//must solve the problem without modifying the values in the list's nodes (i.e., 
//only nodes themselves may be changed.) 
//
// 
// Example 1: 
//
// 
// Input: head = [1,2,3,4] 
// 
//
// Output: [2,1,4,3] 
//
// Explanation: 
//
// 
//
// Example 2: 
//
// 
// Input: head = [] 
// 
//
// Output: [] 
//
// Example 3: 
//
// 
// Input: head = [1] 
// 
//
// Output: [1] 
//
// Example 4: 
//
// 
// Input: head = [1,2,3] 
// 
//
// Output: [2,1,3] 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 100]. 
// 0 <= Node.val <= 100 
// 
//
// Related Topics Linked List Recursion 👍 12082 👎 455


@Slf4j
public class SwapNodesInPairs_24 {

    @Test
    void test() {
        log.info("result: {}", new Solution().swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))));
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
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(0, head);
            ListNode current = dummy;

            while (current.next != null && current.next.next != null) {
                ListNode first = current.next;
                ListNode second = current.next.next;

                first.next = second.next;
                second.next = first;
                current.next = second;

                current = first;
            }

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