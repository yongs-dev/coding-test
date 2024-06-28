package com.mark.codingtest.leetcode.editor.en;

import org.junit.jupiter.api.Test;

//Given the head of a sorted linked list, delete all duplicates such that each 
//element appears only once. Return the linked list sorted as well. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,1,2]
//Output: [1,2]
// 
//
// Example 2: 
// 
// 
//Input: head = [1,1,2,3,3]
//Output: [1,2,3]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 300]. 
// -100 <= Node.val <= 100 
// The list is guaranteed to be sorted in ascending order. 
// 
//
// Related Topics Linked List 👍 8639 👎 301


public class RemoveDuplicatesFromSortedList_83 {

    @Test
    void test() {
//        new Solution().deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2))));
        new Solution().deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3))))));
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
        public ListNode deleteDuplicates(ListNode head) {
            // 리스트의 시작점을 유지하면서 리스트를 안전하게 순회하기 위해 선언
            ListNode current = head;

            while (current != null && current.next != null) {
                if (current.val == current.next.val) {
                    // 중복된 다음 노드를 건너뜁니다.
                    current.next = current.next.next;
                } else {
                    // 중복이 없으면 다음 노드로 이동합니다.
                    current = current.next;
                }
            }

            return head;
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