package com.leetcode.matrices_grids;

class Solution2906 {
    public int[][] constructProductMatrix(int[][] grid) {
        final int mod = 12345;
        int n = grid.length, m = grid[0].length;
        int[][] p = new int[n][m];
        long suf = 1;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                p[i][j] = (int) suf;
                suf = suf * grid[i][j] % mod;
            }
        }
        long pre = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                p[i][j] = (int) (p[i][j] * pre % mod);
                pre = pre * grid[i][j] % mod;
            }
        }
        return p;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2906 _tcSol = new Solution2906();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,2],[3,4]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 2}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.constructProductMatrix(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[24,12],[8,6]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[12345],[2],[1]]");
        try {
            int[][] grid = new int[][]{new int[]{12345}, new int[]{2}, new int[]{1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.constructProductMatrix(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[2],[0],[0]]");
        System.out.println();
    }
}