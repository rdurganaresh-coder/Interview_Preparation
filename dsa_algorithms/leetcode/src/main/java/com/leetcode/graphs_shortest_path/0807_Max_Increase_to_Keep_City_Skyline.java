package com.leetcode.graphs_shortest_path;

class Solution0807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rowMax = new int[m];
        int[] colMax = new int[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ans += Math.min(rowMax[i], colMax[j]) - grid[i][j];
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
        Solution0807 _tcSol = new Solution0807();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]");
        try {
            int[][] grid = new int[][]{new int[]{3, 0, 8, 4}, new int[]{2, 4, 5, 7}, new int[]{9, 2, 6, 3}, new int[]{0, 3, 1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxIncreaseKeepingSkyline(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "35");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[0,0,0],[0,0,0],[0,0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxIncreaseKeepingSkyline(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}