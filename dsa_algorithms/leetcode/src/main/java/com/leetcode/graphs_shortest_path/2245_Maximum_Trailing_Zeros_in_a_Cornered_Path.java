package com.leetcode.graphs_shortest_path;

class Solution2245 {
    public int maxTrailingZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] r2 = new int[m + 1][n + 1];
        int[][] c2 = new int[m + 1][n + 1];
        int[][] r5 = new int[m + 1][n + 1];
        int[][] c5 = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                int x = grid[i - 1][j - 1];
                int s2 = 0, s5 = 0;
                for (; x % 2 == 0; x /= 2) {
                    ++s2;
                }
                for (; x % 5 == 0; x /= 5) {
                    ++s5;
                }
                r2[i][j] = r2[i][j - 1] + s2;
                c2[i][j] = c2[i - 1][j] + s2;
                r5[i][j] = r5[i][j - 1] + s5;
                c5[i][j] = c5[i - 1][j] + s5;
            }
        }
        int ans = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                int a = Math.min(r2[i][j] + c2[i - 1][j], r5[i][j] + c5[i - 1][j]);
                int b = Math.min(r2[i][j] + c2[m][j] - c2[i][j], r5[i][j] + c5[m][j] - c5[i][j]);
                int c = Math.min(r2[i][n] - r2[i][j] + c2[i][j], r5[i][n] - r5[i][j] + c5[i][j]);
                int d = Math.min(r2[i][n] - r2[i][j - 1] + c2[m][j] - c2[i][j],
                    r5[i][n] - r5[i][j - 1] + c5[m][j] - c5[i][j]);
                ans = Math.max(ans, Math.max(a, Math.max(b, Math.max(c, d))));
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2245 _tcSol = new Solution2245();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[23,17,15,3,20],[8,1,20,27,11],[9,4,6,2,21],[40,9,1,10,6],[22,7,4,5,3]]");
        try {
            int[][] grid = new int[][]{new int[]{23, 17, 15, 3, 20}, new int[]{8, 1, 20, 27, 11}, new int[]{9, 4, 6, 2, 21}, new int[]{40, 9, 1, 10, 6}, new int[]{22, 7, 4, 5, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxTrailingZeros(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[4,3,2],[7,6,1],[8,8,8]]");
        try {
            int[][] grid = new int[][]{new int[]{4, 3, 2}, new int[]{7, 6, 1}, new int[]{8, 8, 8}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxTrailingZeros(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}