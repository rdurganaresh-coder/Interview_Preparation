package com.leetcode.arrays_hashing_greedy;

class Solution0837_3 {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0) {
            return 1.0;
        }
        double[] f = new double[k + maxPts];
        for (int i = k; i < Math.min(n + 1, k + maxPts); ++i) {
            f[i] = 1;
        }
        f[k - 1] = Math.min(n - k + 1, maxPts) * 1.0 / maxPts;
        for (int i = k - 2; i >= 0; --i) {
            f[i] = f[i + 1] + (f[i + 1] - f[i + maxPts + 1]) / maxPts;
        }
        return f[0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0837_3 _tcSol = new Solution0837_3();
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
