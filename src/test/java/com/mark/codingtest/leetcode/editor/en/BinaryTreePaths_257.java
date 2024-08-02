package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Given the root of a binary tree, return all root-to-leaf paths in any order. 
//
// A leaf is a node with no children. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,3,null,5]
//Output: ["1->2->5","1->3"]
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: ["1"]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 100]. 
// -100 <= Node.val <= 100 
// 
//
// Related Topics String Backtracking Tree Depth-First Search Binary Tree 👍 657
//8 👎 298


@Slf4j
public class BinaryTreePaths_257 {

    @Test
    void test() {
        log.info("result: {}", new Solution().binaryTreePaths(new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3))));
//        log.info("result: {}", new Solution().binaryTreePaths(new TreeNode(1)));
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
         * <b>Recursion</b>
         */
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new ArrayList<>();

            if (root != null) {
                findPaths(root, "", paths);
            }

            return paths;
        }

        private void findPaths(TreeNode node, String path, List<String> paths) {
            if (node.left == null && node.right == null) {
                paths.add(path + node.val);
                return;
            }

            if (node.left != null) {
                findPaths(node.left, path + node.val + "->", paths);
            }

            if (node.right != null) {
                findPaths(node.right, path + node.val + "->", paths);
            }
        }

        /**
         * <b>Stack</b>
         */
        public List<String> binaryTreePathWithStack(TreeNode root) {
            List<String> paths = new ArrayList<>();
            if (root == null) {
                return paths;
            }

            Stack<Object[]> stack = new Stack<>();
            stack.push(new Object[] {root, String.valueOf(root.val)});

            while (!stack.isEmpty()) {
                Object[] current = stack.pop();
                TreeNode node = (TreeNode) current[0];
                String path = (String) current[1];

                if (node.left == null && node.right == null) {
                    paths.add(path);
                }

                if (node.left != null) {
                    stack.push(new Object[] {node.left, path + "->" + node.left.val});
                }

                if (node.right != null) {
                    stack.push(new Object[] {node.right, path + "->" + node.right.val});
                }
            }

            return paths;
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