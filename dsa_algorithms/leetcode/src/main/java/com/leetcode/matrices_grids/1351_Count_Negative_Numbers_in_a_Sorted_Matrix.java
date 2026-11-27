package com.leetcode.matrices_grids;

class Solution1351 {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int i = m - 1;
        int j = 0;
        int ans = 0;
        while (i >= 0 && j < n) {
            if (grid[i][j] >= 0) {
                j++;
            } else {
                ans += n - j;
                i--;
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
        Solution1351 _tcSol = new Solution1351();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]");
        try {
            int[][] grid = new int[][]{new int[]{4, 3, 2, -1}, new int[]{3, 2, 1, -1}, new int[]{1, 1, -1, -2}, new int[]{-1, -1, -2, -3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countNegatives(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[3,2],[1,0]]");
        try {
            int[][] grid = new int[][]{new int[]{3, 2}, new int[]{1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countNegatives(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
