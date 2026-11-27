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
class BSTIterator0173 {
    private int cur = 0;
    private List<Integer> vals = new ArrayList<>();

    public BSTIterator0173(TreeNode root) {
        inorder(root);
    }

    public int next() {
        return vals.get(cur++);
    }

    public boolean hasNext() {
        return cur < vals.size();
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            vals.add(root.val);
            inorder(root.right);
        }
    }
}

/**
 * Your BSTIterator0173 object will be instantiated and called as such:
 * BSTIterator0173 obj = new BSTIterator0173(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */