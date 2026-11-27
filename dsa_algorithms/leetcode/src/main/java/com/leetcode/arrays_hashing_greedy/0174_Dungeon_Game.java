package com.leetcode.arrays_hashing_greedy;

class Solution0174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (var e : dp) {
            Arrays.fill(e, 1 << 30);
        }
        dp[m][n - 1] = dp[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0174 _tcSol = new Solution0174();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]");
        try {
            int[][] dungeon = new int[][]{new int[]{-2, -3, 3}, new int[]{-5, -10, 1}, new int[]{10, 30, -5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.calculateMinimumHP(dungeon)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "dungeon = [[0]]");
        try {
            int[][] dungeon = new int[][]{new int[]{0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.calculateMinimumHP(dungeon)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}