package com.leetcode.arrays_hashing_greedy;

class Solution3317 {
    public int numberOfWays(int n, int x, int y) {
        final int mod = (int) 1e9 + 7;
        long[][] f = new long[n + 1][x + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= x; ++j) {
                f[i][j] = (f[i - 1][j] * j % mod + f[i - 1][j - 1] * (x - (j - 1) % mod)) % mod;
            }
        }
        long ans = 0, p = 1;
        for (int j = 1; j <= x; ++j) {
            p = p * y % mod;
            ans = (ans + f[n][j] * p) % mod;
        }
        return (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3317 _tcSol = new Solution3317();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 1, x = 2, y = 3");
        try {
            int n = 1;
            int x = 2;
            int y = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfWays(n, x, y)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, x = 2, y = 1");
        try {
            int n = 5;
            int x = 2;
            int y = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfWays(n, x, y)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "32");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 3, x = 3, y = 4");
        try {
            int n = 3;
            int x = 3;
            int y = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfWays(n, x, y)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "684");
        System.out.println();
    }
}
