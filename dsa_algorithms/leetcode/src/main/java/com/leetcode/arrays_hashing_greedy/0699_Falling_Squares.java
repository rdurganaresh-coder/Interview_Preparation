package com.leetcode.arrays_hashing_greedy;

class Node0699 {
    Node0699 left;
    Node0699 right;
    int l;
    int r;
    int mid;
    int v;
    int add;
    public Node0699(int l, int r) {
        this.l = l;
        this.r = r;
        this.mid = (l + r) >> 1;
    }
}

class SegmentTree0699 {
    private Node0699 root = new Node0699(1, (int) 1e9);

    public SegmentTree0699() {
    }

    public void modify(int l, int r, int v) {
        modify(l, r, v, root);
    }

    public void modify(int l, int r, int v, Node0699 node) {
        if (l > r) {
            return;
        }
        if (node.l >= l && node.r <= r) {
            node.v = v;
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

    public int query(int l, int r, Node0699 node) {
        if (l > r) {
            return 0;
        }
        if (node.l >= l && node.r <= r) {
            return node.v;
        }
        pushdown(node);
        int v = 0;
        if (l <= node.mid) {
            v = Math.max(v, query(l, r, node.left));
        }
        if (r > node.mid) {
            v = Math.max(v, query(l, r, node.right));
        }
        return v;
    }

    public void pushup(Node0699 node) {
        node.v = Math.max(node.left.v, node.right.v);
    }

    public void pushdown(Node0699 node) {
        if (node.left == null) {
            node.left = new Node0699(node.l, node.mid);
        }
        if (node.right == null) {
            node.right = new Node0699(node.mid + 1, node.r);
        }
        if (node.add != 0) {
            Node0699 left = node.left, right = node.right;
            left.add = node.add;
            right.add = node.add;
            left.v = node.add;
            right.v = node.add;
            node.add = 0;
        }
    }
}

class Solution0699 {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        SegmentTree0699 tree = new SegmentTree0699();
        int mx = 0;
        for (int[] p : positions) {
            int l = p[0], w = p[1], r = l + w - 1;
            int h = tree.query(l, r) + w;
            mx = Math.max(mx, h);
            ans.add(mx);
            tree.modify(l, r, h);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0699 _tcSol = new Solution0699();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "positions = [[1,2],[2,3],[6,1]]");
        try {
            int[][] positions = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{6, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.fallingSquares(positions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,5,5]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "positions = [[100,100],[200,100]]");
        try {
            int[][] positions = new int[][]{new int[]{100, 100}, new int[]{200, 100}};
            System.out.println("  Output  : " + _tcShow(_tcSol.fallingSquares(positions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[100,100]");
        System.out.println();
    }
}