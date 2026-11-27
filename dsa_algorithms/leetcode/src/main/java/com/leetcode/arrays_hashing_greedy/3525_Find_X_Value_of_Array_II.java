package com.leetcode.arrays_hashing_greedy;

class Node3525 {
    int l, r, prod;
    int[] cnt;

    Node3525(int l, int r, int k) {
        this.l = l;
        this.r = r;
        this.prod = 1;
        this.cnt = new int[k];
    }
}

class SegmentTree3525 {
    private int k;
    private Node3525[] tr;

    SegmentTree3525(int[] nums, int k) {
        this.k = k;
        int n = nums.length;
        tr = new Node3525[n << 2];
        build(1, 1, n, nums);
    }

    private Node3525 merge(Node3525 a, Node3525 b) {
        Node3525 c = new Node3525(0, 0, k);
        c.prod = a.prod * b.prod % k;
        System.arraycopy(a.cnt, 0, c.cnt, 0, k);
        for (int r = 0; r < k; ++r) {
            c.cnt[a.prod * r % k] += b.cnt[r];
        }
        return c;
    }

    private void pushup(int u) {
        Node3525 p = merge(tr[u << 1], tr[u << 1 | 1]);
        tr[u].prod = p.prod;
        tr[u].cnt = p.cnt;
    }

    private void build(int u, int l, int r, int[] nums) {
        tr[u] = new Node3525(l, r, k);
        if (l == r) {
            int v = nums[l - 1] % k;
            tr[u].prod = v;
            tr[u].cnt[v] = 1;
            return;
        }
        int mid = (l + r) >> 1;
        build(u << 1, l, mid, nums);
        build(u << 1 | 1, mid + 1, r, nums);
        pushup(u);
    }

    void modify(int u, int x, int v) {
        if (tr[u].l == tr[u].r) {
            v %= k;
            tr[u].prod = v;
            Arrays.fill(tr[u].cnt, 0);
            tr[u].cnt[v] = 1;
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

    Node3525 query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) {
            return tr[u];
        }
        int mid = (tr[u].l + tr[u].r) >> 1;
        if (r <= mid) {
            return query(u << 1, l, r);
        }
        if (l > mid) {
            return query(u << 1 | 1, l, r);
        }
        return merge(query(u << 1, l, r), query(u << 1 | 1, l, r));
    }
}

class Solution3525 {
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        SegmentTree3525 tree = new SegmentTree3525(nums, k);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            int idx = queries[i][0], val = queries[i][1], start = queries[i][2], x = queries[i][3];
            tree.modify(1, idx + 1, val);
            ans[i] = tree.query(1, start + 1, n).cnt[x];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3525 _tcSol = new Solution3525();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5], k = 3, queries = [[2,2,0,2],[3,3,3,0],[0,1,0,1]]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5};
            int k = 3;
            int[][] queries = new int[][]{new int[]{2, 2, 0, 2}, new int[]{3, 3, 3, 0}, new int[]{0, 1, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.resultArray(nums, k, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,2,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,4,8,16,32], k = 4, queries = [[0,2,0,2],[0,2,0,1]]");
        try {
            int[] nums = new int[]{1, 2, 4, 8, 16, 32};
            int k = 4;
            int[][] queries = new int[][]{new int[]{0, 2, 0, 2}, new int[]{0, 2, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.resultArray(nums, k, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,0]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,1,2,1,1], k = 2, queries = [[2,1,0,1]]");
        try {
            int[] nums = new int[]{1, 1, 2, 1, 1};
            int k = 2;
            int[][] queries = new int[][]{new int[]{2, 1, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.resultArray(nums, k, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5]");
        System.out.println();
    }
}
