package com.leetcode.matrices_grids;

class Solution2373 {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; ++i) {
            for (int j = 0; j < n - 2; ++j) {
                for (int x = i; x <= i + 2; ++x) {
                    for (int y = j; y <= j + 2; ++y) {
                        ans[i][j] = Math.max(ans[i][j], grid[x][y]);
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
        Solution2373 _tcSol = new Solution2373();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]");
        try {
            int[][] grid = new int[][]{new int[]{9, 9, 8, 1}, new int[]{5, 6, 2, 6}, new int[]{8, 2, 6, 4}, new int[]{6, 2, 2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestLocal(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[9,9],[8,6]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1}, new int[]{1, 1, 2, 1, 1}, new int[]{1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestLocal(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[2,2,2],[2,2,2],[2,2,2]]");
        System.out.println();
    }
}