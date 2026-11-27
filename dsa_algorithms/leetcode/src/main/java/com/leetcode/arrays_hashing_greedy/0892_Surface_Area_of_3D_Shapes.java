package com.leetcode.arrays_hashing_greedy;

class Solution0892 {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) {
                    ans += 2 + grid[i][j] * 4;
                    if (i > 0) {
                        ans -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
                    }
                    if (j > 0) {
                        ans -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
                    }
                }
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
        Solution0892 _tcSol = new Solution0892();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,2],[3,4]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 2}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.surfaceArea(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "34");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,1,1],[1,0,1],[1,1,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 1}, new int[]{1, 0, 1}, new int[]{1, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.surfaceArea(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "32");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[2,2,2],[2,1,2],[2,2,2]]");
        try {
            int[][] grid = new int[][]{new int[]{2, 2, 2}, new int[]{2, 1, 2}, new int[]{2, 2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.surfaceArea(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "46");
        System.out.println();
    }
}