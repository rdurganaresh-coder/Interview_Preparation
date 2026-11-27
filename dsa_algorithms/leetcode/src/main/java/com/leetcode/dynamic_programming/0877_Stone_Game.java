package com.leetcode.dynamic_programming;

class Solution0877 {
    private int[] piles;
    private int[][] f;

    public boolean stoneGame(int[] piles) {
        this.piles = piles;
        int n = piles.length;
        f = new int[n][n];
        return dfs(0, n - 1) > 0;
    }

    private int dfs(int i, int j) {
        if (i > j) {
            return 0;
        }
        if (f[i][j] != 0) {
            return f[i][j];
        }
        return f[i][j] = Math.max(piles[i] - dfs(i + 1, j), piles[j] - dfs(i, j - 1));
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0877 _tcSol = new Solution0877();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "piles = [5,3,4,5]");
        try {
            int[] piles = new int[]{5, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.stoneGame(piles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "piles = [3,7,2,3]");
        try {
            int[] piles = new int[]{3, 7, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.stoneGame(piles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}