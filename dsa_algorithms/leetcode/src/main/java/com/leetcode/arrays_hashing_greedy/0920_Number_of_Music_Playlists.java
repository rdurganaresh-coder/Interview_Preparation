package com.leetcode.arrays_hashing_greedy;

class Solution0920 {
    public int numMusicPlaylists(int n, int goal, int k) {
        final int mod = (int) 1e9 + 7;
        long[][] f = new long[goal + 1][n + 1];
        f[0][0] = 1;
        for (int i = 1; i <= goal; ++i) {
            for (int j = 1; j <= n; ++j) {
                f[i][j] = f[i - 1][j - 1] * (n - j + 1);
                if (j > k) {
                    f[i][j] += f[i - 1][j] * (j - k);
                }
                f[i][j] %= mod;
            }
        }
        return (int) f[goal][n];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0920 _tcSol = new Solution0920();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, goal = 3, k = 1");
        try {
            int n = 3;
            int goal = 3;
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.numMusicPlaylists(n, goal, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2, goal = 3, k = 0");
        try {
            int n = 2;
            int goal = 3;
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.numMusicPlaylists(n, goal, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 2, goal = 3, k = 1");
        try {
            int n = 2;
            int goal = 3;
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.numMusicPlaylists(n, goal, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}