package com.leetcode.dynamic_programming;

class Solution2407 {
    public int lengthOfLIS(int[] nums, int k) {
        int mx = nums[0];
        for (int v : nums) {
            mx = Math.max(mx, v);
        }
        SegmentTree2407 tree = new SegmentTree2407(mx);
        int ans = 0;
        for (int v : nums) {
            int t = tree.query(1, v - k, v - 1) + 1;
            ans = Math.max(ans, t);
            tree.modify(1, v, t);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2407 _tcSol = new Solution2407();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,2,1,4,3,4,5,8,15], k = 3");
        try {
            int[] nums = new int[]{4, 2, 1, 4, 3, 4, 5, 8, 15};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.lengthOfLIS(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [7,4,5,1,8,12,4,7], k = 5");
        try {
            int[] nums = new int[]{7, 4, 5, 1, 8, 12, 4, 7};
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.lengthOfLIS(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,5], k = 1");
        try {
            int[] nums = new int[]{1, 5};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.lengthOfLIS(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}

class Node2407 {
    int l;
    int r;
    int v;
}

class SegmentTree2407 {
    private Node2407[] tr;

    public SegmentTree2407(int n) {
        tr = new Node2407[4 * n];
        for (int i = 0; i < tr.length; ++i) {
            tr[i] = new Node2407();
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
        tr[u].v = Math.max(tr[u << 1].v, tr[u << 1 | 1].v);
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
}