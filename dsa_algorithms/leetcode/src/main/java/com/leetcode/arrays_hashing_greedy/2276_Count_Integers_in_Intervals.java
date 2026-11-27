package com.leetcode.arrays_hashing_greedy;

class Node2276 {
    Node2276 left;
    Node2276 right;
    int l;
    int r;
    int mid;
    int v;
    int add;

    public Node2276(int l, int r) {
        this.l = l;
        this.r = r;
        this.mid = (l + r) >> 1;
    }
}

class SegmentTree2276 {
    private Node2276 root = new Node2276(1, (int) 1e9 + 1);

    public SegmentTree2276() {
    }

    public void modify(int l, int r, int v) {
        modify(l, r, v, root);
    }

    public void modify(int l, int r, int v, Node2276 node) {
        if (l > r) {
            return;
        }
        if (node.l >= l && node.r <= r) {
            node.v = node.r - node.l + 1;
            node.add = v;
            return;
        }
        pushdown(node);
        if (l <= node.mid) {
            modify(l, r, v, node.left);
        }
        if (r > node.mid) {
            modify(l, r, v, node.right);
        }
        pushup(node);
    }

    public int query(int l, int r) {
        return query(l, r, root);
    }

    public int query(int l, int r, Node2276 node) {
        if (l > r) {
            return 0;
        }
        if (node.l >= l && node.r <= r) {
            return node.v;
        }
        pushdown(node);
        int v = 0;
        if (l <= node.mid) {
            v += query(l, r, node.left);
        }
        if (r > node.mid) {
            v += query(l, r, node.right);
        }
        return v;
    }

    public void pushup(Node2276 node) {
        node.v = node.left.v + node.right.v;
    }

    public void pushdown(Node2276 node) {
        if (node.left == null) {
            node.left = new Node2276(node.l, node.mid);
        }
        if (node.right == null) {
            node.right = new Node2276(node.mid + 1, node.r);
        }
        if (node.add != 0) {
            Node2276 left = node.left, right = node.right;
            left.add = node.add;
            right.add = node.add;
            left.v = left.r - left.l + 1;
            right.v = right.r - right.l + 1;
            node.add = 0;
        }
    }
}

class CountIntervals2276 {
    private SegmentTree2276 tree = new SegmentTree2276();

    public CountIntervals2276() {
    }

    public void add(int left, int right) {
        tree.modify(left, right, 1);
    }

    public int count() {
        return tree.query(1, (int) 1e9);
    }
}

/**
 * Your CountIntervals2276 object will be instantiated and called as such:
 * CountIntervals2276 obj = new CountIntervals2276();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */