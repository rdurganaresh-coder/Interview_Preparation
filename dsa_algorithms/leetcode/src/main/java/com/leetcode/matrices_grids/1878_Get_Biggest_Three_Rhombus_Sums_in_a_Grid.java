package com.leetcode.matrices_grids;

class Solution1878 {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] s1 = new int[m + 1][n + 2];
        int[][] s2 = new int[m + 1][n + 2];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                s1[i][j] = s1[i - 1][j - 1] + grid[i - 1][j - 1];
                s2[i][j] = s2[i - 1][j + 1] + grid[i - 1][j - 1];
            }
        }
        TreeSet<Integer> ss = new TreeSet<>();
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                int l = Math.min(Math.min(i - 1, m - i), Math.min(j - 1, n - j));
                ss.add(grid[i - 1][j - 1]);
                for (int k = 1; k <= l; ++k) {
                    int a = s1[i + k][j] - s1[i][j - k];
                    int b = s1[i][j + k] - s1[i - k][j];
                    int c = s2[i][j - k] - s2[i - k][j];
                    int d = s2[i + k][j] - s2[i][j + k];
                    ss.add(a + b + c + d - grid[i + k - 1][j - 1] + grid[i - k - 1][j - 1]);
                }
                while (ss.size() > 3) {
                    ss.pollFirst();
                }
            }
        }
        int[] ans = new int[ss.size()];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = ss.pollLast();
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1878 _tcSol = new Solution1878();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[3,4,5,1,3],[3,3,4,2,3],[20,30,200,40,10],[1,5,5,4,1],[4,3,2,2,5]]");
        try {
            int[][] grid = new int[][]{new int[]{3, 4, 5, 1, 3}, new int[]{3, 3, 4, 2, 3}, new int[]{20, 30, 200, 40, 10}, new int[]{1, 5, 5, 4, 1}, new int[]{4, 3, 2, 2, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.getBiggestThree(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[228,216,211]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,2,3],[4,5,6],[7,8,9]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
            System.out.println("  Output  : " + _tcShow(_tcSol.getBiggestThree(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[20,9,8]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[7,7,7]]");
        try {
            int[][] grid = new int[][]{new int[]{7, 7, 7}};
            System.out.println("  Output  : " + _tcShow(_tcSol.getBiggestThree(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[7]");
        System.out.println();
    }
}