package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

//Given the root of a binary tree, return the preorder traversal of its nodes' 
//values. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,null,2,3]
//Output: [1,2,3]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// 
// Follow up: Recursive solution is trivial, could you do it iteratively? 
//
// Related Topics Stack Tree Depth-First Search Binary Tree 👍 7967 👎 211


@Slf4j
public class BinaryTreePreorderTraversal_144 {

    @Test
    void test() {
        log.info("result: {}", new Solution().preorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))));
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
         * <b>전위 순회(Preorder Traversal)</b><br>
         * DFS의 한 종류로 노드를 방문하는 순서는 다음과 같다.
         * <ol>
         *     <li>루트 노드를 방문</li>
         *     <li>왼쪽 서브 트리를 순회</li>
         *     <li>오른쪽 서브 트리를 순회</li>
         * </ol>
         *
         */
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            if (root == null) {
                return result;
            }

            dfs(root, result);

            return result;
        }

        private void dfs(TreeNode node, List<Integer> result) {
            if (node == null) {
                return ;
            }

            result.add(node.val);
            dfs(node.left, result);
            dfs(node.right, result);
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