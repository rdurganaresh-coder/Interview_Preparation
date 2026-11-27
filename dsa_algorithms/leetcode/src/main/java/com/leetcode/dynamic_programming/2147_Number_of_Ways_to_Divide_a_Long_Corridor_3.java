package com.leetcode.dynamic_programming;

class Solution2147_3 {
    public int numberOfWays(String corridor) {
        final int mod = (int) 1e9 + 7;
        int n = corridor.length();
        int[][] f = new int[n + 1][3];
        f[n][2] = 1;
        for (int i = n - 1; i >= 0; --i) {
            for (int k = 0; k < 3; ++k) {
                int nk = k + (corridor.charAt(i) == 'S' ? 1 : 0);
                if (nk > 2) {
                    continue;
                }
                f[i][k] = f[i + 1][nk];
                if (nk == 2) {
                    f[i][k] = (f[i][k] + f[i + 1][0]) % mod;
                }
            }
        }
        return f[0][0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2147_3 _tcSol = new Solution2147_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "corridor = \"SSPPSPS\"");
        try {
            String corridor = "SSPPSPS";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfWays(corridor)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "corridor = \"PPSPSP\"");
        try {
            String corridor = "PPSPSP";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfWays(corridor)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "corridor = \"S\"");
        try {
            String corridor = "S";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfWays(corridor)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
