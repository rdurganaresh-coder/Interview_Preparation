package com.leetcode.matrices_grids;

class Solution2132 {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int m = grid.length, n = grid[0].length;
        int[][] s = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        int[][] d = new int[m + 2][n + 2];
        for (int i = 1; i + stampHeight - 1 <= m; ++i) {
            for (int j = 1; j + stampWidth - 1 <= n; ++j) {
                int x = i + stampHeight - 1, y = j + stampWidth - 1;
                if (s[x][y] - s[x][j - 1] - s[i - 1][y] + s[i - 1][j - 1] == 0) {
                    d[i][j]++;
                    d[i][y + 1]--;
                    d[x + 1][j]--;
                    d[x + 1][y + 1]++;
                }
            }
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                d[i][j] += d[i - 1][j] + d[i][j - 1] - d[i - 1][j - 1];
                if (grid[i - 1][j - 1] == 0 && d[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2132 _tcSol = new Solution2132();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,0,0,0],[1,0,0,0],[1,0,0,0],[1,0,0,0],[1,0,0,0]], stampHeight = 4, stampWidth = 3");
        try {
            int[][] grid = new int[][]{new int[]{1, 0, 0, 0}, new int[]{1, 0, 0, 0}, new int[]{1, 0, 0, 0}, new int[]{1, 0, 0, 0}, new int[]{1, 0, 0, 0}};
            int stampHeight = 4;
            int stampWidth = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.possibleToStamp(grid, stampHeight, stampWidth)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,0,0,0],[0,1,0,0],[0,0,1,0],[0,0,0,1]], stampHeight = 2, stampWidth = 2");
        try {
            int[][] grid = new int[][]{new int[]{1, 0, 0, 0}, new int[]{0, 1, 0, 0}, new int[]{0, 0, 1, 0}, new int[]{0, 0, 0, 1}};
            int stampHeight = 2;
            int stampWidth = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.possibleToStamp(grid, stampHeight, stampWidth)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}