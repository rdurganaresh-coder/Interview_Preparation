package com.leetcode.arrays_hashing_greedy;

class Solution2428 {
    public int maxSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int i = 1; i < m - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                int s = -grid[i][j - 1] - grid[i][j + 1];
                for (int x = i - 1; x <= i + 1; ++x) {
                    for (int y = j - 1; y <= j + 1; ++y) {
                        s += grid[x][y];
                    }
                }
                ans = Math.max(ans, s);
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
        Solution2428 _tcSol = new Solution2428();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[6,2,1,3],[4,2,1,5],[9,2,8,7],[4,1,2,9]]");
        try {
            int[][] grid = new int[][]{new int[]{6, 2, 1, 3}, new int[]{4, 2, 1, 5}, new int[]{9, 2, 8, 7}, new int[]{4, 1, 2, 9}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSum(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "30");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,2,3],[4,5,6],[7,8,9]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSum(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "35");
        System.out.println();
    }
}