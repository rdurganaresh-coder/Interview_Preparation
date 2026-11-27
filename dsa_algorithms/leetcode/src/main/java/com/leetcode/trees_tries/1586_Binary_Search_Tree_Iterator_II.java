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
class BSTIterator1586 {
    private List<Integer> nums = new ArrayList<>();
    private int i = -1;

    public BSTIterator1586(TreeNode root) {
        dfs(root);
    }

    public boolean hasNext() {
        return i < nums.size() - 1;
    }

    public int next() {
        return nums.get(++i);
    }

    public boolean hasPrev() {
        return i > 0;
    }

    public int prev() {
        return nums.get(--i);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        nums.add(root.val);
        dfs(root.right);
    }
}

/**
 * Your BSTIterator1586 object will be instantiated and called as such:
 * BSTIterator1586 obj = new BSTIterator1586(root);
 * boolean param_1 = obj.hasNext();
 * int param_2 = obj.next();
 * boolean param_3 = obj.hasPrev();
 * int param_4 = obj.prev();
 */