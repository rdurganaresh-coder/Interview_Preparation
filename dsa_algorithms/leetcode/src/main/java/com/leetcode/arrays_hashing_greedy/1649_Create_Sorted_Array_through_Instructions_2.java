package com.leetcode.arrays_hashing_greedy;

class Solution1649_2 {
    public int createSortedArray(int[] instructions) {
        int n = 100010;
        int mod = (int) 1e9 + 7;
        SegmentTree1649_2 tree = new SegmentTree1649_2(n);
        int ans = 0;
        for (int num : instructions) {
            int a = tree.query(1, 1, num - 1);
            int b = tree.query(1, 1, n) - tree.query(1, 1, num);
            ans += Math.min(a, b);
            ans %= mod;
            tree.modify(1, num, 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1649_2 _tcSol = new Solution1649_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "instructions = [1,5,6,2]");
        try {
            int[] instructions = new int[]{1, 5, 6, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.createSortedArray(instructions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "instructions = [1,2,3,6,5,4]");
        try {
            int[] instructions = new int[]{1, 2, 3, 6, 5, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.createSortedArray(instructions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "instructions = [1,3,3,3,2,4,2,1,2]");
        try {
            int[] instructions = new int[]{1, 3, 3, 3, 2, 4, 2, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.createSortedArray(instructions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}

class Node1649_2 {
    int l;
    int r;
    int v;
}

class SegmentTree1649_2 {
    private Node1649_2[] tr;

    public SegmentTree1649_2(int n) {
        tr = new Node1649_2[4 * n];
        for (int i = 0; i < tr.length; ++i) {
            tr[i] = new Node1649_2();
        }
        build(1, 1, n);
    }

    public void build(int u, int l, int r) {
        tr[u].l = l;
        tr[u].r = r;
        if (l == r) {
            return;
        }
        int mid = (l + r) >> 1;
        build(u << 1, l, mid);
        build(u << 1 | 1, mid + 1, r);
    }

    public void modify(int u, int x, int v) {
        if (tr[u].l == x && tr[u].r == x) {
            tr[u].v += v;
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