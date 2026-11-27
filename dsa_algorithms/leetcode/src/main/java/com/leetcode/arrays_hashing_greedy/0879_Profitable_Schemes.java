package com.leetcode.arrays_hashing_greedy;

class Solution0879 {
    private Integer[][][] f;
    private int m;
    private int n;
    private int minProfit;
    private int[] group;
    private int[] profit;
    private final int mod = (int) 1e9 + 7;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        m = group.length;
        this.n = n;
        f = new Integer[m][n + 1][minProfit + 1];
        this.minProfit = minProfit;
        this.group = group;
        this.profit = profit;
        return dfs(0, 0, 0);
    }

    private int dfs(int i, int j, int k) {
        if (i >= m) {
            return k == minProfit ? 1 : 0;
        }
        if (f[i][j][k] != null) {
            return f[i][j][k];
        }
        int ans = dfs(i + 1, j, k);
        if (j + group[i] <= n) {
            ans += dfs(i + 1, j + group[i], Math.min(k + profit[i], minProfit));
        }
        ans %= mod;
        return f[i][j][k] = ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0879 _tcSol = new Solution0879();
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