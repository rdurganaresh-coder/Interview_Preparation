package com.leetcode.trees_tries;

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
class Solution2773 {
    private int ans;

    public int heightOfTree(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int d) {
        ans = Math.max(ans, d++);
        if (root.left != null && root.left.right != root) {
            dfs(root.left, d);
        }
        if (root.right != null && root.right.left != root) {
            dfs(root.right, d);
        }
    }
}