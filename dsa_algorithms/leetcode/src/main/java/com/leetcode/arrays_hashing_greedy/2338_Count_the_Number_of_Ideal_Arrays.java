package com.leetcode.arrays_hashing_greedy;

class Solution2338 {
    public int idealArrays(int n, int maxValue) {
        final int mod = (int) 1e9 + 7;
        int[][] c = new int[n][16];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i && j < 16; ++j) {
                c[i][j] = j == 0 ? 1 : (c[i - 1][j] + c[i - 1][j - 1]) % mod;
            }
        }
        long[][] f = new long[maxValue + 1][16];
        for (int i = 1; i <= maxValue; ++i) {
            f[i][1] = 1;
        }
        for (int j = 1; j < 15; ++j) {
            for (int i = 1; i <= maxValue; ++i) {
                int k = 2;
                for (; k * i <= maxValue; ++k) {
                    f[k * i][j + 1] = (f[k * i][j + 1] + f[i][j]) % mod;
                }
            }
        }
        long ans = 0;
        for (int i = 1; i <= maxValue; ++i) {
            for (int j = 1; j < 16; ++j) {
                ans = (ans + f[i][j] * c[n - 1][j - 1]) % mod;
            }
        }
        return (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2338 _tcSol = new Solution2338();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 2, maxValue = 5");
        try {
            int n = 2;
            int maxValue = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.idealArrays(n, maxValue)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, maxValue = 3");
        try {
            int n = 5;
            int maxValue = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.idealArrays(n, maxValue)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();
    }
}
