package com.leetcode.arrays_hashing_greedy;

class Solution3418 {
    private Integer[][][] f;
    private int[][] coins;
    private int m;
    private int n;

    public int maximumAmount(int[][] coins) {
        m = coins.length;
        n = coins[0].length;
        this.coins = coins;
        f = new Integer[m][n][3];
        return dfs(0, 0, 2);
    }

    private int dfs(int i, int j, int k) {
        if (i >= m || j >= n) {
            return Integer.MIN_VALUE / 2;
        }
        if (f[i][j][k] != null) {
            return f[i][j][k];
        }
        if (i == m - 1 && j == n - 1) {
            return k > 0 ? Math.max(0, coins[i][j]) : coins[i][j];
        }
        int ans = coins[i][j] + Math.max(dfs(i + 1, j, k), dfs(i, j + 1, k));
        if (coins[i][j] < 0 && k > 0) {
            ans = Math.max(ans, Math.max(dfs(i + 1, j, k - 1), dfs(i, j + 1, k - 1)));
        }
        return f[i][j][k] = ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3418 _tcSol = new Solution3418();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "coins = [[0,1,-1],[1,-2,3],[2,-3,4]]");
        try {
            int[][] coins = new int[][]{new int[]{0, 1, -1}, new int[]{1, -2, 3}, new int[]{2, -3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumAmount(coins)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "coins = [[10,10,10],[10,10,10]]");
        try {
            int[][] coins = new int[][]{new int[]{10, 10, 10}, new int[]{10, 10, 10}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumAmount(coins)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "40");
        System.out.println();
    }
}
