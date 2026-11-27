package com.leetcode.arrays_hashing_greedy;

class Node2158 {
    Node2158 left;
    Node2158 right;
    int l;
    int r;
    int mid;
    int v;
    int add;

    public Node2158(int l, int r) {
        this.l = l;
        this.r = r;
        this.mid = (l + r) >> 1;
    }
}

class SegmentTree2158 {
    private Node2158 root = new Node2158(1, 100010);

    public SegmentTree2158() {
    }

    public void modify(int l, int r, int v) {
        modify(l, r, v, root);
    }

    public void modify(int l, int r, int v, Node2158 node) {
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

    public int query(int l, int r, Node2158 node) {
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

    public void pushup(Node2158 node) {
        node.v = node.left.v + node.right.v;
    }

    public void pushdown(Node2158 node) {
        if (node.left == null) {
            node.left = new Node2158(node.l, node.mid);
        }
        if (node.right == null) {
            node.right = new Node2158(node.mid + 1, node.r);
        }
        if (node.add != 0) {
            Node2158 left = node.left, right = node.right;
            left.add = node.add;
            right.add = node.add;
            left.v = left.r - left.l + 1;
            right.v = right.r - right.l + 1;
            node.add = 0;
        }
    }
}

class Solution2158 {
    public int[] amountPainted(int[][] paint) {
        SegmentTree2158 tree = new SegmentTree2158();
        int n = paint.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            int l = paint[i][0] + 1;
            int r = paint[i][1];
            int v = tree.query(l, r);
            ans[i] = r - l + 1 - v;
            tree.modify(l, r, 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2158 _tcSol = new Solution2158();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "paint = [[1,4],[4,7],[5,8]]");
        try {
            int[][] paint = new int[][]{new int[]{1, 4}, new int[]{4, 7}, new int[]{5, 8}};
            System.out.println("  Output  : " + _tcShow(_tcSol.amountPainted(paint)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,3,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "paint = [[1,4],[5,8],[4,7]]");
        try {
            int[][] paint = new int[][]{new int[]{1, 4}, new int[]{5, 8}, new int[]{4, 7}};
            System.out.println("  Output  : " + _tcShow(_tcSol.amountPainted(paint)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,3,1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "paint = [[1,5],[2,4]]");
        try {
            int[][] paint = new int[][]{new int[]{1, 5}, new int[]{2, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.amountPainted(paint)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,0]");
        System.out.println();
    }
}