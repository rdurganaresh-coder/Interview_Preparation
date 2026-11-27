package com.leetcode.matrices_grids;

class Solution3071 {
    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int[] cnt1 = new int[3];
        int[] cnt2 = new int[3];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                boolean a = i == j && i <= n / 2;
                boolean b = i + j == n - 1 && i <= n / 2;
                boolean c = j == n / 2 && i >= n / 2;
                if (a || b || c) {
                    ++cnt1[grid[i][j]];
                } else {
                    ++cnt2[grid[i][j]];
                }
            }
        }
        int ans = n * n;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (i != j) {
                    ans = Math.min(ans, n * n - cnt1[i] - cnt2[j]);
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
        Solution3071 _tcSol = new Solution3071();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,2,2],[1,1,0],[0,1,0]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 2, 2}, new int[]{1, 1, 0}, new int[]{0, 1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperationsToWriteY(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[0,1,0,1,0],[2,1,0,1,2],[2,2,2,0,1],[2,2,2,2,2],[2,1,2,2,2]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 1, 0, 1, 0}, new int[]{2, 1, 0, 1, 2}, new int[]{2, 2, 2, 0, 1}, new int[]{2, 2, 2, 2, 2}, new int[]{2, 1, 2, 2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperationsToWriteY(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();
    }
}