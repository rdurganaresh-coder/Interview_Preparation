package com.leetcode.arrays_hashing_greedy;

class Node1622 {
    Node1622 left;
    Node1622 right;
    int l, r, mid;
    long v, add, mul = 1;

    Node1622(int l, int r) {
        this.l = l;
        this.r = r;
        this.mid = (l + r) >> 1;
    }
}

class SegmentTree1622 {
    private static final int MOD = (int) 1e9 + 7;
    private Node1622 root = new Node1622(1, (int) 1e5 + 1);

    void modify(int l, int r, int mul, int add) {
        modify(l, r, mul, add, root);
    }

    void modify(int l, int r, int mul, int add, Node1622 node) {
        if (l > r) {
            return;
        }
        if (node.l >= l && node.r <= r) {
            apply(node, mul, add);
            return;
        }
        pushdown(node);
        if (l <= node.mid) {
            modify(l, r, mul, add, node.left);
        }
        if (r > node.mid) {
            modify(l, r, mul, add, node.right);
        }
        pushup(node);
    }

    int query(int l, int r) {
        return query(l, r, root);
    }

    int query(int l, int r, Node1622 node) {
        if (l > r) {
            return 0;
        }
        if (node.l >= l && node.r <= r) {
            return (int) node.v;
        }
        pushdown(node);
        int v = 0;
        if (l <= node.mid) {
            v = (v + query(l, r, node.left)) % MOD;
        }
        if (r > node.mid) {
            v = (v + query(l, r, node.right)) % MOD;
        }
        return v;
    }

    void apply(Node1622 node, long mul, long add) {
        node.v = (node.v * mul + (node.r - node.l + 1) * add) % MOD;
        node.add = (node.add * mul + add) % MOD;
        node.mul = node.mul * mul % MOD;
    }

    void pushup(Node1622 node) {
        node.v = (node.left.v + node.right.v) % MOD;
    }

    void pushdown(Node1622 node) {
        if (node.left == null) {
            node.left = new Node1622(node.l, node.mid);
        }
        if (node.right == null) {
            node.right = new Node1622(node.mid + 1, node.r);
        }
        if (node.add != 0 || node.mul != 1) {
            apply(node.left, node.mul, node.add);
            apply(node.right, node.mul, node.add);
            node.add = 0;
            node.mul = 1;
        }
    }
}

class Fancy1622 {
    private int n;
    private SegmentTree1622 tree = new SegmentTree1622();

    public void append(int val) {
        ++n;
        tree.modify(n, n, 1, val);
    }

    public void addAll(int inc) {
        tree.modify(1, n, 1, inc);
    }

    public void multAll(int m) {
        tree.modify(1, n, m, 0);
    }

    public int getIndex(int idx) {
        return idx >= n ? -1 : tree.query(idx + 1, idx + 1);
    }
}
