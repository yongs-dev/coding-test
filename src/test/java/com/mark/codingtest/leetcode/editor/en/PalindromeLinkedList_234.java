package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Stack;

//Given the head of a singly linked list, return true if it is a palindrome or 
//false otherwise. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,2,1]
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: head = [1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 10⁵]. 
// 0 <= Node.val <= 9 
// 
//
// 
//Follow up: Could you do it in 
//O(n) time and 
//O(1) space?
//
// Related Topics Linked List Two Pointers Stack Recursion 👍 16500 👎 883


@Slf4j
public class PalindromeLinkedList_234 {

    @Test
    void test() {
        log.info("result: {}", new Solution().isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));
        log.info("result: {}", new Solution().isPalindromeTwoPointers(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));
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
        /**
         * <b>스택 (Stack)</b><br>
         * 리스트의 절반을 저정한 후 리스트 후반부와 비교
         */
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }

            Stack<Integer> stack = new Stack<>();
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                stack.push(slow.val);
                slow = slow.next;
                fast = fast.next.next;
            }

            if (fast != null) {
                slow = slow.next;   // 리스트의 길이가 홀수일 때 중간 요소 건너뜀
            }

            while (slow != null) {
                if (stack.pop() != slow.val) {
                    return false;
                }

                slow = slow.next;
            }

            return true;
        }

        /**
         * <b>Two Pointers</b><br>
         * 투 포인터를 사용하여 리스트의 중간을 찾고 후반부를 역순으로 만든 후 비교
         */
        public boolean isPalindromeTwoPointers(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }

            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode firstHalfStart = head;
            ListNode secondHalfStart = reverse(slow);

            while (secondHalfStart != null) {
                if (firstHalfStart.val != secondHalfStart.val) {
                    return false;
                }

                firstHalfStart = firstHalfStart.next;
                secondHalfStart = secondHalfStart.next;
            }

            return true;
        }

        private ListNode reverse(ListNode head) {
            ListNode prev = null;
            while (head != null) {
                ListNode nextNode = head.next;
                head.next = prev;
                prev = head;
                head = nextNode;
            }
            return prev;
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