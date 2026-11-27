package com.leetcode.arrays_hashing_greedy;

class Solution2179_2 {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pos = new int[n];
        SegmentTree2179_2 tree = new SegmentTree2179_2(n);
        for (int i = 0; i < n; ++i) {
            pos[nums2[i]] = i + 1;
        }
        long ans = 0;
        for (int num : nums1) {
            int p = pos[num];
            long left = tree.query(1, 1, p);
            long right = n - p - (tree.query(1, 1, n) - tree.query(1, 1, p));
            ans += left * right;
            tree.modify(1, p, 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2179_2 _tcSol = new Solution2179_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [2,0,1,3], nums2 = [0,1,2,3]");
        try {
            int[] nums1 = new int[]{2, 0, 1, 3};
            int[] nums2 = new int[]{0, 1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.goodTriplets(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [4,0,1,3,2], nums2 = [4,1,0,2,3]");
        try {
            int[] nums1 = new int[]{4, 0, 1, 3, 2};
            int[] nums2 = new int[]{4, 1, 0, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.goodTriplets(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}

class Node2179_2 {
    int l;
    int r;
    int v;
}

class SegmentTree2179_2 {
    private Node2179_2[] tr;

    public SegmentTree2179_2(int n) {
        tr = new Node2179_2[4 * n];
        for (int i = 0; i < tr.length; ++i) {
            tr[i] = new Node2179_2();
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