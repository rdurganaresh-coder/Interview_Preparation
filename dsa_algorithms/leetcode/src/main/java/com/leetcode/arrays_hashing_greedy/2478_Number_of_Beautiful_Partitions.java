package com.leetcode.arrays_hashing_greedy;

class Solution2478 {
    public int beautifulPartitions(String s, int k, int minLength) {
        int n = s.length();
        if (!prime(s.charAt(0)) || prime(s.charAt(n - 1))) {
            return 0;
        }
        int[][] f = new int[n + 1][k + 1];
        int[][] g = new int[n + 1][k + 1];
        f[0][0] = 1;
        g[0][0] = 1;
        final int mod = (int) 1e9 + 7;
        for (int i = 1; i <= n; ++i) {
            if (i >= minLength && !prime(s.charAt(i - 1)) && (i == n || prime(s.charAt(i)))) {
                for (int j = 1; j <= k; ++j) {
                    f[i][j] = g[i - minLength][j - 1];
                }
            }
            for (int j = 0; j <= k; ++j) {
                g[i][j] = (g[i - 1][j] + f[i][j]) % mod;
            }
        }
        return f[n][k];
    }

    private boolean prime(char c) {
        return c == '2' || c == '3' || c == '5' || c == '7';
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2478 _tcSol = new Solution2478();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"23542185131\", k = 3, minLength = 2");
        try {
            String s = "23542185131";
            int k = 3;
            int minLength = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.beautifulPartitions(s, k, minLength)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"23542185131\", k = 3, minLength = 3");
        try {
            String s = "23542185131";
            int k = 3;
            int minLength = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.beautifulPartitions(s, k, minLength)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"3312958\", k = 3, minLength = 1");
        try {
            String s = "3312958";
            int k = 3;
            int minLength = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.beautifulPartitions(s, k, minLength)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}