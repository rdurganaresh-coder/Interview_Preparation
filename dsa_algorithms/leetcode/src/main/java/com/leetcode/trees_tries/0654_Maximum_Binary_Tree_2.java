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
class Solution0654_2 {
    private SegmentTree0654_2 tree;
    private int[] nums;
    private static int[] d = new int[1010];

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        tree = new SegmentTree0654_2(nums);
        for (int i = 0; i < n; ++i) {
            d[nums[i]] = i + 1;
        }
        return dfs(1, n);
    }

    private TreeNode dfs(int l, int r) {
        if (l > r) {
            return null;
        }
        int val = tree.query(1, l, r);
        TreeNode root = new TreeNode(val);
        root.left = dfs(l, d[val] - 1);
        root.right = dfs(d[val] + 1, r);
        return root;
    }
}

class Node0654_2 {
    int l;
    int r;
    int v;
}

class SegmentTree0654_2 {
    Node0654_2[] tr;
    int[] nums;

    public SegmentTree0654_2(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        tr = new Node0654_2[n << 2];
        for (int i = 0; i < tr.length; ++i) {
            tr[i] = new Node0654_2();
        }
        build(1, 1, n);
    }

    private void build(int u, int l, int r) {
        tr[u].l = l;
        tr[u].r = r;
        if (l == r) {
            tr[u].v = nums[l - 1];
            return;
        }
        int mid = (l + r) >> 1;
        build(u << 1, l, mid);
        build(u << 1 | 1, mid + 1, r);
        pushup(u);
    }

    public int query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) {
            return tr[u].v;
        }
        int mid = (tr[u].l + tr[u].r) >> 1;
        int v = 0;
        if (l <= mid) {
            v = query(u << 1, l, r);
        }
        if (r > mid) {
            v = Math.max(v, query(u << 1 | 1, l, r));
        }
        return v;
    }

    private void pushup(int u) {
        tr[u].v = Math.max(tr[u << 1].v, tr[u << 1 | 1].v);
    }
}
