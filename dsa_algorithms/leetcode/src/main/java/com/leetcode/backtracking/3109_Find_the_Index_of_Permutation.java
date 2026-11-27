package com.leetcode.backtracking;

class BinaryIndexedTree3109 {
    private int n;
    private int[] c;

    public BinaryIndexedTree3109(int n) {
        this.n = n;
        this.c = new int[n + 1];
    }

    public void update(int x, int delta) {
        for (; x <= n; x += x & -x) {
            c[x] += delta;
        }
    }

    public int query(int x) {
        int s = 0;
        for (; x > 0; x -= x & -x) {
            s += c[x];
        }
        return s;
    }
}

class Solution3109 {
    public int getPermutationIndex(int[] perm) {
        final int mod = (int) 1e9 + 7;
        long ans = 0;
        int n = perm.length;
        BinaryIndexedTree3109 tree = new BinaryIndexedTree3109(n + 1);
        long[] f = new long[n];
        f[0] = 1;
        for (int i = 1; i < n; ++i) {
            f[i] = f[i - 1] * i % mod;
        }
        for (int i = 0; i < n; ++i) {
            int cnt = perm[i] - 1 - tree.query(perm[i]);
            ans = (ans + cnt * f[n - i - 1] % mod) % mod;
            tree.update(perm[i], 1);
        }
        return (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3109 _tcSol = new Solution3109();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "perm = [1,2]");
        try {
            int[] perm = new int[]{1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.getPermutationIndex(perm)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "perm = [3,1,2]");
        try {
            int[] perm = new int[]{3, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.getPermutationIndex(perm)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}