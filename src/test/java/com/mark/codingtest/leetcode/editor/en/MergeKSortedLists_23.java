package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//You are given an array of k linked-lists lists, each linked-list is sorted in 
//ascending order. 
//
// Merge all the linked-lists into one sorted linked-list and return it. 
//
// 
// Example 1: 
//
// 
//Input: lists = [[1,4,5],[1,3,4],[2,6]]
//Output: [1,1,2,3,4,4,5,6]
//Explanation: The linked-lists are:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//merging them into one sorted list:
//1->1->2->3->4->4->5->6
// 
//
// Example 2: 
//
// 
//Input: lists = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: lists = [[]]
//Output: []
// 
//
// 
// Constraints: 
//
// 
// k == lists.length 
// 0 <= k <= 10⁴ 
// 0 <= lists[i].length <= 500 
// -10⁴ <= lists[i][j] <= 10⁴ 
// lists[i] is sorted in ascending order. 
// The sum of lists[i].length will not exceed 10⁴. 
// 
//
// Related Topics Linked List Divide and Conquer Heap (Priority Queue) Merge 
//Sort 👍 19675 👎 726


@Slf4j
public class MergeKSortedLists_23 {

    @Test
    void test() {
        log.info("result: {}", new Solution().mergeKLists(new ListNode[] {
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        }));
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
        public ListNode mergeKLists(ListNode[] lists) {
            // 우선순위 큐를 생성 (노드의 값을 기준으로 정렬)
            PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

            // 각 리스트의 첫 노드를 큐에 추가
            for (ListNode node : lists) {
                if (node != null) {
                    pq.add(node);
                }
            }

            // 더미 헤드 노드를 만들고, 결과 리스트를 만들기 위한 current 포인터 생성
            ListNode dummyHead = new ListNode(0);
            ListNode current = dummyHead;

            // 우선순위 큐가 빌 때까지 반복
            while (!pq.isEmpty()) {
                // 가장 작은 값을 가진 노드를 꺼냄
                ListNode minNode = pq.poll();
                current.next = minNode;  // 결과 리스트에 추가
                current = current.next;  // current 포인터를 이동

                // 꺼낸 노드의 다음 노드가 있다면 큐에 추가
                if (minNode.next != null) {
                    pq.add(minNode.next);
                }
            }

            // 더미 헤드의 next를 반환하여 실제 리스트 반환
            return dummyHead.next;
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