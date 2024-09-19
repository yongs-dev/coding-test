package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Given the root of a binary search tree (BST) with duplicates, return all the 
//mode(s) (i.e., the most frequently occurred element) in it. 
//
// If the tree has more than one mode, return them in any order. 
//
// Assume a BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than or equal 
//to the node's key. 
// The right subtree of a node contains only nodes with keys greater than or 
//equal to the node's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,null,2,2]
//Output: [2]
// 
//
// Example 2: 
//
// 
//Input: root = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//Follow up: Could you do that without using any extra space? (Assume that the 
//implicit stack space incurred due to recursion does not count).
//
// Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 👍 3908
// 👎 787


@Slf4j
public class FindModeInBinarySearchTree_501 {

    @Test
    void test() {
        log.info("result: {}", new Solution().findMode(new TreeNode(1, null, new TreeNode(2, new TreeNode(2), null))));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {

        /**
         * <b>DFS(Queue)</b>
         */
        public int[] findMode(TreeNode root) {
            if (root == null) return new int[0];

            Stack<TreeNode> stack = new Stack<>();
            TreeNode current = root;
            Integer prev = null;
            int maxCount = 0;
            int count = 0;
            List<Integer> modes = new ArrayList<>();

            while (!stack.isEmpty() || current != null) {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }

                current = stack.pop();

                if (prev != null && current.val == prev) {
                    count++;
                } else {
                    count = 1;
                }

                if (count > maxCount) {
                    maxCount = count;
                    modes.clear();
                    modes.add(current.val);
                } else if (count == maxCount) {
                    modes.add(current.val);
                }

                prev = current.val;
                current = current.right;
            }

            return modes.stream().mapToInt(i -> i).toArray();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}