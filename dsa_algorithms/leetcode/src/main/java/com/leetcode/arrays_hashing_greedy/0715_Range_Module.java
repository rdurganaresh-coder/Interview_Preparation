package com.leetcode.arrays_hashing_greedy;

class Node0715 {
    Node0715 left;
    Node0715 right;
    int add;
    boolean v;
}

class SegmentTree0715 {
    private Node0715 root = new Node0715();

    public SegmentTree0715() {
    }

    public void modify(int left, int right, int v) {
        modify(left, right, v, 1, (int) 1e9, root);
    }

    public void modify(int left, int right, int v, int l, int r, Node0715 node) {
        if (l >= left && r <= right) {
            node.v = v == 1;
            node.add = v;
            return;
        }
        pushdown(node);
        int mid = (l + r) >> 1;
        if (left <= mid) {
            modify(left, right, v, l, mid, node.left);
        }
        if (right > mid) {
            modify(left, right, v, mid + 1, r, node.right);
        }
        pushup(node);
    }

    public boolean query(int left, int right) {
        return query(left, right, 1, (int) 1e9, root);
    }

    public boolean query(int left, int right, int l, int r, Node0715 node) {
        if (l >= left && r <= right) {
            return node.v;
        }
        pushdown(node);
        int mid = (l + r) >> 1;
        boolean v = true;
        if (left <= mid) {
            v = v && query(left, right, l, mid, node.left);
        }
        if (right > mid) {
            v = v && query(left, right, mid + 1, r, node.right);
        }
        return v;
    }

    public void pushup(Node0715 node) {
        node.v = node.left != null && node.left.v && node.right != null && node.right.v;
    }

    public void pushdown(Node0715 node) {
        if (node.left == null) {
            node.left = new Node0715();
        }
        if (node.right == null) {
            node.right = new Node0715();
        }
        if (node.add != 0) {
            node.left.add = node.add;
            node.right.add = node.add;
            node.left.v = node.add == 1;
            node.right.v = node.add == 1;
            node.add = 0;
        }
    }
}

class RangeModule0715 {
    private SegmentTree0715 tree = new SegmentTree0715();

    public RangeModule0715() {
    }

    public void addRange(int left, int right) {
        tree.modify(left, right - 1, 1);
    }

    public boolean queryRange(int left, int right) {
        return tree.query(left, right - 1);
    }

    public void removeRange(int left, int right) {
        tree.modify(left, right - 1, -1);
    }
}

/**
 * Your RangeModule0715 object will be instantiated and called as such:
 * RangeModule0715 obj = new RangeModule0715();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */