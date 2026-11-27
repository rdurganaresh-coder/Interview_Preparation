package com.leetcode.arrays_hashing_greedy;

class Solution3070 {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] s = new int[m + 1][n + 1];
        int ans = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + grid[i - 1][j - 1];
                if (s[i][j] <= k) {
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
        Solution3070 _tcSol = new Solution3070();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[7,6,3],[6,6,1]], k = 18");
        try {
            int[][] grid = new int[][]{new int[]{7, 6, 3}, new int[]{6, 6, 1}};
            int k = 18;
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubmatrices(grid, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[7,2,9],[1,5,0],[2,6,6]], k = 20");
        try {
            int[][] grid = new int[][]{new int[]{7, 2, 9}, new int[]{1, 5, 0}, new int[]{2, 6, 6}};
            int k = 20;
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubmatrices(grid, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}