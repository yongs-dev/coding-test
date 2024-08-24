package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

//Given the root of a binary tree, return the sum of all left leaves. 
//
// A leaf is a node with no children. A left leaf is a leaf that is the left 
//child of another node. 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: 24
//Explanation: There are two left leaves in the binary tree, with values 9 and 1
//5 respectively.
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 1000]. 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 54
//92 👎 310


@Slf4j
public class SumOfLeftLeaves_404 {

    @Test
    void test() {
//        log.info("result: {}", new Solution().sumOfLeftLeaves(new TreeNode(1, null, new TreeNode(2))));
        log.info("result: {}", new Solution().sumOfLeftLeaves(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
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
        public int sumOfLeftLeaves(TreeNode root) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            int sum = 0;

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);

                    if (node.left.left == null && node.left.right == null) {
                        sum += node.left.val;
                    }
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            return sum;
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