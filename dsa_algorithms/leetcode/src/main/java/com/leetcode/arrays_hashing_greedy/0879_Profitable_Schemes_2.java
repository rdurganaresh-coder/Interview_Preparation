package com.leetcode.arrays_hashing_greedy;

class Solution0879_2 {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        final int mod = (int) 1e9 + 7;
        int m = group.length;
        int[][][] f = new int[m + 1][n + 1][minProfit + 1];
        for (int j = 0; j <= n; ++j) {
            f[0][j][0] = 1;
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                for (int k = 0; k <= minProfit; ++k) {
                    f[i][j][k] = f[i - 1][j][k];
                    if (j >= group[i - 1]) {
                        f[i][j][k]
                            = (f[i][j][k]
                                  + f[i - 1][j - group[i - 1]][Math.max(0, k - profit[i - 1])])
                            % mod;
                    }
                }
            }
        }
        return f[m][n][minProfit];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0879_2 _tcSol = new Solution0879_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, minProfit = 3, group = [2,2], profit = [2,3]");
        try {
            int n = 5;
            int minProfit = 3;
            int[] group = new int[]{2, 2};
            int[] profit = new int[]{2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.profitableSchemes(n, minProfit, group, profit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]");
        try {
            int n = 10;
            int minProfit = 5;
            int[] group = new int[]{2, 3, 5};
            int[] profit = new int[]{6, 7, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.profitableSchemes(n, minProfit, group, profit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}