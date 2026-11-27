package com.leetcode.arrays_hashing_greedy;

class Node0308_2 {
    int l;
    int r;
    int v;
}

class SegmentTree0308_2 {
    private Node0308_2[] tr;
    private int[] nums;

    public SegmentTree0308_2(int[] nums) {
        int n = nums.length;
        tr = new Node0308_2[n << 2];
        this.nums = nums;
        for (int i = 0; i < tr.length; ++i) {
            tr[i] = new Node0308_2();
        }
        build(1, 1, n);
    }

    public void build(int u, int l, int r) {
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

    public void modify(int u, int x, int v) {
        if (tr[u].l == x && tr[u].r == x) {
            tr[u].v = v;
            return;
        }
        int mid = (tr[u].l + tr[u].r) >> 1;
        if (x <= mid) {
            modify(u << 1, x, v);
        } else {
            modify(u << 1 | 1, x, v);
        }
        pushup(u);
    }

    public void pushup(int u) {
        tr[u].v = tr[u << 1].v + tr[u << 1 | 1].v;
    }

    public int query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) {
            return tr[u].v;
        }
        int mid = (tr[u].l + tr[u].r) >> 1;
        int v = 0;
        if (l <= mid) {
            v += query(u << 1, l, r);
        }
        if (r > mid) {
            v += query(u << 1 | 1, l, r);
        }
        return v;
    }
}

class NumMatrix0308_2 {
    private SegmentTree0308_2[] trees;

    public NumMatrix0308_2(int[][] matrix) {
        int m = matrix.length;
        trees = new SegmentTree0308_2[m];
        for (int i = 0; i < m; ++i) {
            trees[i] = new SegmentTree0308_2(matrix[i]);
        }
    }

    public void update(int row, int col, int val) {
        SegmentTree0308_2 tree = trees[row];
        tree.modify(1, col + 1, val);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int s = 0;
        for (int row = row1; row <= row2; ++row) {
            SegmentTree0308_2 tree = trees[row];
            s += tree.query(1, col1 + 1, col2 + 1);
        }
        return s;
    }
}

/**
 * Your NumMatrix0308_2 object will be instantiated and called as such:
 * NumMatrix0308_2 obj = new NumMatrix0308_2(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */