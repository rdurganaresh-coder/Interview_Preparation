package com.leetcode.arrays_hashing_greedy;

class UnionFind0952 {
    int[] p;

    UnionFind0952(int n) {
        p = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
    }

    void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa != pb) {
            p[pa] = pb;
        }
    }

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}

class Solution0952 {
    public int largestComponentSize(int[] nums) {
        int m = 0;
        for (int v : nums) {
            m = Math.max(m, v);
        }
        UnionFind0952 uf = new UnionFind0952(m + 1);
        for (int v : nums) {
            int i = 2;
            while (i <= v / i) {
                if (v % i == 0) {
                    uf.union(v, i);
                    uf.union(v, v / i);
                }
                ++i;
            }
        }
        int[] cnt = new int[m + 1];
        int ans = 0;
        for (int v : nums) {
            int t = uf.find(v);
            ++cnt[t];
            ans = Math.max(ans, cnt[t]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0952 _tcSol = new Solution0952();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,6,15,35]");
        try {
            int[] nums = new int[]{4, 6, 15, 35};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestComponentSize(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [20,50,9,63]");
        try {
            int[] nums = new int[]{20, 50, 9, 63};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestComponentSize(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [2,3,6,7,4,12,21,39]");
        try {
            int[] nums = new int[]{2, 3, 6, 7, 4, 12, 21, 39};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestComponentSize(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();
    }
}