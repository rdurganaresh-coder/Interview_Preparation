package com.leetcode.arrays_hashing_greedy;

class Node2569 {
    int l, r;
    int s, lazy;
}

class SegmentTree2569 {
    private Node2569[] tr;
    private int[] nums;

    public SegmentTree2569(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        tr = new Node2569[n << 2];
        for (int i = 0; i < tr.length; ++i) {
            tr[i] = new Node2569();
        }
        build(1, 1, n);
    }

    private void build(int u, int l, int r) {
        tr[u].l = l;
        tr[u].r = r;
        if (l == r) {
            tr[u].s = nums[l - 1];
            return;
        }
        int mid = (l + r) >> 1;
        build(u << 1, l, mid);
        build(u << 1 | 1, mid + 1, r);
        pushup(u);
    }

    public void modify(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) {
            tr[u].lazy ^= 1;
            tr[u].s = tr[u].r - tr[u].l + 1 - tr[u].s;
            return;
        }
        pushdown(u);
        int mid = (tr[u].l + tr[u].r) >> 1;
        if (l <= mid) {
            modify(u << 1, l, r);
        }
        if (r > mid) {
            modify(u << 1 | 1, l, r);
        }
        pushup(u);
    }

    public int query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) {
            return tr[u].s;
        }
        pushdown(u);
        int mid = (tr[u].l + tr[u].r) >> 1;
        int res = 0;
        if (l <= mid) {
            res += query(u << 1, l, r);
        }
        if (r > mid) {
            res += query(u << 1 | 1, l, r);
        }
        return res;
    }

    private void pushup(int u) {
        tr[u].s = tr[u << 1].s + tr[u << 1 | 1].s;
    }

    private void pushdown(int u) {
        if (tr[u].lazy == 1) {
            int mid = (tr[u].l + tr[u].r) >> 1;
            tr[u << 1].s = mid - tr[u].l + 1 - tr[u << 1].s;
            tr[u << 1].lazy ^= 1;
            tr[u << 1 | 1].s = tr[u].r - mid - tr[u << 1 | 1].s;
            tr[u << 1 | 1].lazy ^= 1;
            tr[u].lazy ^= 1;
        }
    }
}

class Solution2569 {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        SegmentTree2569 tree = new SegmentTree2569(nums1);
        long s = 0;
        for (int x : nums2) {
            s += x;
        }
        int m = 0;
        for (var q : queries) {
            if (q[0] == 3) {
                ++m;
            }
        }
        long[] ans = new long[m];
        int i = 0;
        for (var q : queries) {
            if (q[0] == 1) {
                tree.modify(1, q[1] + 1, q[2] + 1);
            } else if (q[0] == 2) {
                s += 1L * q[1] * tree.query(1, 1, nums2.length);
            } else {
                ans[i++] = s;
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
        Solution2569 _tcSol = new Solution2569();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [1,0,1], nums2 = [0,0,0], queries = [[1,1,1],[2,1,0],[3,0,0]]");
        try {
            int[] nums1 = new int[]{1, 0, 1};
            int[] nums2 = new int[]{0, 0, 0};
            int[][] queries = new int[][]{new int[]{1, 1, 1}, new int[]{2, 1, 0}, new int[]{3, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.handleQuery(nums1, nums2, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [1], nums2 = [5], queries = [[2,0,0],[3,0,0]]");
        try {
            int[] nums1 = new int[]{1};
            int[] nums2 = new int[]{5};
            int[][] queries = new int[][]{new int[]{2, 0, 0}, new int[]{3, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.handleQuery(nums1, nums2, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5]");
        System.out.println();
    }
}