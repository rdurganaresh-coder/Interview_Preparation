package com.leetcode.arrays_hashing_greedy;

class Solution0837 {
    private double[] f;
    private int n, k, maxPts;

    public double new21Game(int n, int k, int maxPts) {
        f = new double[k];
        this.n = n;
        this.k = k;
        this.maxPts = maxPts;
        return dfs(0);
    }

    private double dfs(int i) {
        if (i >= k) {
            return i <= n ? 1 : 0;
        }
        if (i == k - 1) {
            return Math.min(n - k + 1, maxPts) * 1.0 / maxPts;
        }
        if (f[i] != 0) {
            return f[i];
        }
        return f[i] = dfs(i + 1) + (dfs(i + 1) - dfs(i + maxPts + 1)) / maxPts;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0837 _tcSol = new Solution0837();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 10, k = 1, maxPts = 10");
        try {
            int n = 10;
            int k = 1;
            int maxPts = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.new21Game(n, k, maxPts)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1.00000");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 6, k = 1, maxPts = 10");
        try {
            int n = 6;
            int k = 1;
            int maxPts = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.new21Game(n, k, maxPts)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0.60000");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 21, k = 17, maxPts = 10");
        try {
            int n = 21;
            int k = 17;
            int maxPts = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.new21Game(n, k, maxPts)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0.73278");
        System.out.println();
    }
}
