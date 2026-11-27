package com.leetcode.arrays_hashing_greedy;

class Solution2312_2 {
    public long sellingWood(int m, int n, int[][] prices) {
        int[][] d = new int[m + 1][n + 1];
        long[][] f = new long[m + 1][n + 1];
        for (int[] p : prices) {
            d[p[0]][p[1]] = p[2];
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                f[i][j] = d[i][j];
                for (int k = 1; k < i; ++k) {
                    f[i][j] = Math.max(f[i][j], f[k][j] + f[i - k][j]);
                }
                for (int k = 1; k < j; ++k) {
                    f[i][j] = Math.max(f[i][j], f[i][k] + f[i][j - k]);
                }
            }
        }
        return f[m][n];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2312_2 _tcSol = new Solution2312_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "m = 3, n = 5, prices = [[1,4,2],[2,2,7],[2,1,3]]");
        try {
            int m = 3;
            int n = 5;
            int[][] prices = new int[][]{new int[]{1, 4, 2}, new int[]{2, 2, 7}, new int[]{2, 1, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.sellingWood(m, n, prices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "19");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "m = 4, n = 6, prices = [[3,2,10],[1,4,2],[4,1,3]]");
        try {
            int m = 4;
            int n = 6;
            int[][] prices = new int[][]{new int[]{3, 2, 10}, new int[]{1, 4, 2}, new int[]{4, 1, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.sellingWood(m, n, prices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "32");
        System.out.println();
    }
}