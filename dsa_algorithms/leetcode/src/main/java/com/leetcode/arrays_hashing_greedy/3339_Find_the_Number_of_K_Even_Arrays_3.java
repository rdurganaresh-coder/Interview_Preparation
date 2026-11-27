package com.leetcode.arrays_hashing_greedy;

class Solution3339_3 {
    public int countOfArrays(int n, int m, int k) {
        int[][] f = new int[k + 1][2];
        int cnt0 = m / 2;
        int cnt1 = m - cnt0;
        final int mod = (int) 1e9 + 7;
        f[0][1] = 1;
        for (int i = 0; i < n; ++i) {
            int[][] g = new int[k + 1][2];
            for (int j = 0; j <= k; ++j) {
                g[j][0] = (int) (1L * cnt0 * (f[j][1] + (j > 0 ? f[j - 1][0] : 0)) % mod);
                g[j][1] = (int) (1L * cnt1 * (f[j][0] + f[j][1]) % mod);
            }
            f = g;
        }
        return (f[k][0] + f[k][1]) % mod;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3339_3 _tcSol = new Solution3339_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, m = 4, k = 2");
        try {
            int n = 3;
            int m = 4;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.countOfArrays(n, m, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, m = 1, k = 0");
        try {
            int n = 5;
            int m = 1;
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.countOfArrays(n, m, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 7, m = 7, k = 5");
        try {
            int n = 7;
            int m = 7;
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.countOfArrays(n, m, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5832");
        System.out.println();
    }
}
