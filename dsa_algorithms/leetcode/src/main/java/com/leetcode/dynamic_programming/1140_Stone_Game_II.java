package com.leetcode.dynamic_programming;

class Solution1140 {
    private int[] s;
    private Integer[][] f;
    private int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        s = new int[n + 1];
        f = new Integer[n][n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + piles[i];
        }
        return dfs(0, 1);
    }

    private int dfs(int i, int m) {
        if (m * 2 >= n - i) {
            return s[n] - s[i];
        }
        if (f[i][m] != null) {
            return f[i][m];
        }
        int res = 0;
        for (int x = 1; x <= m * 2; ++x) {
            res = Math.max(res, s[n] - s[i] - dfs(i + x, Math.max(m, x)));
        }
        return f[i][m] = res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1140 _tcSol = new Solution1140();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "piles = [2,7,9,4,4]");
        try {
            int[] piles = new int[]{2, 7, 9, 4, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.stoneGameII(piles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "piles = [1,2,3,4,5,100]");
        try {
            int[] piles = new int[]{1, 2, 3, 4, 5, 100};
            System.out.println("  Output  : " + _tcShow(_tcSol.stoneGameII(piles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "104");
        System.out.println();
    }
}