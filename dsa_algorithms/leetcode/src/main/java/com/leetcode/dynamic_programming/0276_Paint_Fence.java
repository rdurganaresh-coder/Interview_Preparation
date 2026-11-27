package com.leetcode.dynamic_programming;

class Solution0276 {
    public int numWays(int n, int k) {
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = k;
        for (int i = 1; i < n; ++i) {
            f[i] = (f[i - 1] + g[i - 1]) * (k - 1);
            g[i] = f[i - 1];
        }
        return f[n - 1] + g[n - 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0276 _tcSol = new Solution0276();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, k = 2");
        try {
            int n = 3;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.numWays(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 1, k = 1");
        try {
            int n = 1;
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.numWays(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 7, k = 2");
        try {
            int n = 7;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.numWays(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "42");
        System.out.println();
    }
}