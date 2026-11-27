package com.leetcode.arrays_hashing_greedy;

class Solution2596 {
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }
        int n = grid.length;
        int[][] pos = new int[n * n][2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                pos[grid[i][j]] = new int[] {i, j};
            }
        }
        for (int i = 1; i < n * n; ++i) {
            int[] p1 = pos[i - 1];
            int[] p2 = pos[i];
            int dx = Math.abs(p1[0] - p2[0]);
            int dy = Math.abs(p1[1] - p2[1]);
            boolean ok = (dx == 1 && dy == 2) || (dx == 2 && dy == 1);
            if (!ok) {
                return false;
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
        Solution2596 _tcSol = new Solution2596();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[0,11,16,5,20],[17,4,19,10,15],[12,1,8,21,6],[3,18,23,14,9],[24,13,2,7,22]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 11, 16, 5, 20}, new int[]{17, 4, 19, 10, 15}, new int[]{12, 1, 8, 21, 6}, new int[]{3, 18, 23, 14, 9}, new int[]{24, 13, 2, 7, 22}};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkValidGrid(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[0,3,6],[5,8,1],[2,7,4]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 3, 6}, new int[]{5, 8, 1}, new int[]{2, 7, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkValidGrid(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}