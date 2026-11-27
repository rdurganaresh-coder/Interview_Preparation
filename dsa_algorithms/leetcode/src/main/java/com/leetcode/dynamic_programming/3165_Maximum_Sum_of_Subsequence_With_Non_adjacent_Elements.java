package com.leetcode.dynamic_programming;

class Node3165 {
    int l, r;
    long s00, s01, s10, s11;

    Node3165(int l, int r) {
        this.l = l;
        this.r = r;
        this.s00 = this.s01 = this.s10 = this.s11 = 0;
    }
}

class SegmentTree3165 {
    Node3165[] tr;

    SegmentTree3165(int n) {
        tr = new Node3165[n * 4];
        build(1, 1, n);
    }

    void build(int u, int l, int r) {
        tr[u] = new Node3165(l, r);
        if (l == r) {
            return;
        }
        int mid = (l + r) >> 1;
        build(u << 1, l, mid);
        build(u << 1 | 1, mid + 1, r);
    }

    long query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) {
            return tr[u].s11;
        }
        int mid = (tr[u].l + tr[u].r) >> 1;
        long ans = 0;
        if (r <= mid) {
            ans = query(u << 1, l, r);
        }
        if (l > mid) {
            ans = Math.max(ans, query(u << 1 | 1, l, r));
        }
        return ans;
    }

    void pushup(int u) {
        Node3165 left = tr[u << 1];
        Node3165 right = tr[u << 1 | 1];
        tr[u].s00 = Math.max(left.s00 + right.s10, left.s01 + right.s00);
        tr[u].s01 = Math.max(left.s00 + right.s11, left.s01 + right.s01);
        tr[u].s10 = Math.max(left.s10 + right.s10, left.s11 + right.s00);
        tr[u].s11 = Math.max(left.s10 + right.s11, left.s11 + right.s01);
    }

    void modify(int u, int x, int v) {
        if (tr[u].l == tr[u].r) {
            tr[u].s11 = Math.max(0, v);
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
}

class Solution3165 {
    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        int n = nums.length;
        SegmentTree3165 tree = new SegmentTree3165(n);
        for (int i = 0; i < n; ++i) {
            tree.modify(1, i + 1, nums[i]);
        }
        long ans = 0;
        final int mod = (int) 1e9 + 7;
        for (int[] q : queries) {
            tree.modify(1, q[0] + 1, q[1]);
            ans = (ans + tree.query(1, 1, n)) % mod;
        }
        return (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3165 _tcSol = new Solution3165();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,5,9], queries = [[1,-2],[0,-3]]");
        try {
            int[] nums = new int[]{3, 5, 9};
            int[][] queries = new int[][]{new int[]{1, -2}, new int[]{0, -3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSumSubsequence(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "21");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,-1], queries = [[0,-5]]");
        try {
            int[] nums = new int[]{0, -1};
            int[][] queries = new int[][]{new int[]{0, -5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSumSubsequence(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
