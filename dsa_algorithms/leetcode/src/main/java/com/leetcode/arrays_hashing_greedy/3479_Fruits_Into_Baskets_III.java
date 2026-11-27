package com.leetcode.arrays_hashing_greedy;

class SegmentTree3479 {
    int[] nums;
    int[] tr;

    public SegmentTree3479(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        this.tr = new int[n << 2];
        build(1, 1, n);
    }

    public void build(int u, int l, int r) {
        if (l == r) {
            tr[u] = nums[l - 1];
            return;
        }
        int mid = (l + r) >> 1;
        build(u << 1, l, mid);
        build(u << 1 | 1, mid + 1, r);
        pushup(u);
    }

    public void modify(int u, int l, int r, int i, int v) {
        if (l == r) {
            tr[u] = v;
            return;
        }
        int mid = (l + r) >> 1;
        if (i <= mid) {
            modify(u << 1, l, mid, i, v);
        } else {
            modify(u << 1 | 1, mid + 1, r, i, v);
        }
        pushup(u);
    }

    public int query(int u, int l, int r, int v) {
        if (tr[u] < v) {
            return -1;
        }
        if (l == r) {
            return l;
        }
        int mid = (l + r) >> 1;
        if (tr[u << 1] >= v) {
            return query(u << 1, l, mid, v);
        }
        return query(u << 1 | 1, mid + 1, r, v);
    }

    public void pushup(int u) {
        tr[u] = Math.max(tr[u << 1], tr[u << 1 | 1]);
    }
}

class Solution3479 {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        SegmentTree3479 tree = new SegmentTree3479(baskets);
        int n = baskets.length;
        int ans = 0;
        for (int x : fruits) {
            int i = tree.query(1, 1, n, x);
            if (i < 0) {
                ans++;
            } else {
                tree.modify(1, 1, n, i, 0);
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3479 _tcSol = new Solution3479();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "fruits = [4,2,5], baskets = [3,5,4]");
        try {
            int[] fruits = new int[]{4, 2, 5};
            int[] baskets = new int[]{3, 5, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.numOfUnplacedFruits(fruits, baskets)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "fruits = [3,6,1], baskets = [6,4,7]");
        try {
            int[] fruits = new int[]{3, 6, 1};
            int[] baskets = new int[]{6, 4, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.numOfUnplacedFruits(fruits, baskets)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
