package com.leetcode.sql_database;

class Solution0552 {
    public int checkRecord(int n) {
        final int mod = (int) 1e9 + 7;
        int[][] f = {{1, 1, 1}, {1, 1, 1}};
        for (int i = 0; i < n; ++i) {
            int[][] g = new int[2][3];
            for (int j = 0; j < 2; ++j) {
                for (int k = 0; k < 3; ++k) {
                    int ans = f[j][0];
                    if (j == 0) {
                        ans = (ans + f[1][0]) % mod;
                    }
                    if (k < 2) {
                        ans = (ans + f[j][k + 1]) % mod;
                    }
                    g[j][k] = ans % mod;
                }
            }
            f = g;
        }
        return f[0][0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0552 _tcSol = new Solution0552();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 2");
        try {
            int n = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.checkRecord(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 1");
        try {
            int n = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.checkRecord(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 10101");
        try {
            int n = 10101;
            System.out.println("  Output  : " + _tcShow(_tcSol.checkRecord(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "183236316");
        System.out.println();
    }
}
