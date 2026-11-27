package com.leetcode.matrices_grids;

class Solution2017 {
    public long gridGame(int[][] grid) {
        long ans = Long.MAX_VALUE;
        long s1 = 0, s2 = 0;
        for (int v : grid[0]) {
            s1 += v;
        }
        int n = grid[0].length;
        for (int j = 0; j < n; ++j) {
            s1 -= grid[0][j];
            ans = Math.min(ans, Math.max(s1, s2));
            s2 += grid[1][j];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2017 _tcSol = new Solution2017();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[2,5,4],[1,5,1]]");
        try {
            int[][] grid = new int[][]{new int[]{2, 5, 4}, new int[]{1, 5, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.gridGame(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[3,3,1],[8,5,2]]");
        try {
            int[][] grid = new int[][]{new int[]{3, 3, 1}, new int[]{8, 5, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.gridGame(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1,3,1,15],[1,3,3,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 3, 1, 15}, new int[]{1, 3, 3, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.gridGame(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}