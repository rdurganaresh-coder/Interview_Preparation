package com.leetcode.arrays_hashing_greedy;

class Solution1267 {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                row[i] += grid[i][j];
                col[j] += grid[i][j];
            }
        }
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1 && (row[i] > 1 || col[j] > 1)) {
                    ++ans;
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
        Solution1267 _tcSol = new Solution1267();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,0],[0,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 0}, new int[]{0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countServers(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,0],[1,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 0}, new int[]{1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countServers(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 0, 0}, new int[]{0, 0, 1, 0}, new int[]{0, 0, 1, 0}, new int[]{0, 0, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countServers(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}
