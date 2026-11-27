package com.leetcode.dynamic_programming;

class Solution3239 {
    public int minFlips(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int cnt1 = 0, cnt2 = 0;
        for (var row : grid) {
            for (int j = 0; j < n / 2; ++j) {
                if (row[j] != row[n - j - 1]) {
                    ++cnt1;
                }
            }
        }
        for (int j = 0; j < n; ++j) {
            for (int i = 0; i < m / 2; ++i) {
                if (grid[i][j] != grid[m - i - 1][j]) {
                    ++cnt2;
                }
            }
        }
        return Math.min(cnt1, cnt2);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3239 _tcSol = new Solution3239();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,0,0],[0,0,0],[0,0,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minFlips(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[0,1],[0,1],[0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 1}, new int[]{0, 1}, new int[]{0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minFlips(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1],[0]]");
        try {
            int[][] grid = new int[][]{new int[]{1}, new int[]{0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minFlips(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
