package com.leetcode.arrays_hashing_greedy;

class Solution2500 {
    public int deleteGreatestValue(int[][] grid) {
        for (var row : grid) {
            Arrays.sort(row);
        }
        int ans = 0;
        for (int j = 0; j < grid[0].length; ++j) {
            int t = 0;
            for (int i = 0; i < grid.length; ++i) {
                t = Math.max(t, grid[i][j]);
            }
            ans += t;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2500 _tcSol = new Solution2500();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,2,4],[3,3,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 2, 4}, new int[]{3, 3, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.deleteGreatestValue(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[10]]");
        try {
            int[][] grid = new int[][]{new int[]{10}};
            System.out.println("  Output  : " + _tcShow(_tcSol.deleteGreatestValue(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}