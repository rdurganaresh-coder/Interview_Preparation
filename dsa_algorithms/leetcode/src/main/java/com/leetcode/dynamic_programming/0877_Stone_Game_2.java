package com.leetcode.dynamic_programming;

class Solution0877_2 {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; ++i) {
            f[i][i] = piles[i];
        }
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = Math.max(piles[i] - f[i + 1][j], piles[j] - f[i][j - 1]);
            }
        }
        return f[0][n - 1] > 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0877_2 _tcSol = new Solution0877_2();
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