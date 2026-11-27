package com.leetcode.dynamic_programming;

class Solution2912 {
    public int numberOfWays(int n, int m, int k, int[] source, int[] dest) {
        final int mod = 1000000007;
        long[] f = new long[4];
        f[0] = 1;
        while (k-- > 0) {
            long[] g = new long[4];
            g[0] = ((n - 1) * f[1] + (m - 1) * f[2]) % mod;
            g[1] = (f[0] + (n - 2) * f[1] + (m - 1) * f[3]) % mod;
            g[2] = (f[0] + (m - 2) * f[2] + (n - 1) * f[3]) % mod;
            g[3] = (f[1] + f[2] + (n - 2) * f[3] + (m - 2) * f[3]) % mod;
            f = g;
        }
        if (source[0] == dest[0]) {
            return source[1] == dest[1] ? (int) f[0] : (int) f[2];
        }
        return source[1] == dest[1] ? (int) f[1] : (int) f[3];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2912 _tcSol = new Solution2912();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, m = 2, k = 2, source = [1,1], dest = [2,2]");
        try {
            int n = 3;
            int m = 2;
            int k = 2;
            int[] source = new int[]{1, 1};
            int[] dest = new int[]{2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfWays(n, m, k, source, dest)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, m = 4, k = 3, source = [1,2], dest = [2,3]");
        try {
            int n = 3;
            int m = 4;
            int k = 3;
            int[] source = new int[]{1, 2};
            int[] dest = new int[]{2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfWays(n, m, k, source, dest)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();
    }
}