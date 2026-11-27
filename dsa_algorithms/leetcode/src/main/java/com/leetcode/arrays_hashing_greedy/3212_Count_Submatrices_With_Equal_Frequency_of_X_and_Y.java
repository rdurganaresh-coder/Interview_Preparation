package com.leetcode.arrays_hashing_greedy;

class Solution3212 {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] s = new int[m + 1][n + 1][2];
        int ans = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                s[i][j][0] = s[i - 1][j][0] + s[i][j - 1][0] - s[i - 1][j - 1][0]
                    + (grid[i - 1][j - 1] == 'X' ? 1 : 0);
                s[i][j][1] = s[i - 1][j][1] + s[i][j - 1][1] - s[i - 1][j - 1][1]
                    + (grid[i - 1][j - 1] == 'Y' ? 1 : 0);
                if (s[i][j][0] > 0 && s[i][j][0] == s[i][j][1]) {
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
        Solution3212 _tcSol = new Solution3212();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[\"X\",\"Y\",\".\"],[\"Y\",\".\",\".\"]]");
        try {
            char[][] grid = new char[][]{new char[]{'X', 'Y', '.'}, new char[]{'Y', '.', '.'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSubmatrices(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[\"X\",\"X\"],[\"X\",\"Y\"]]");
        try {
            char[][] grid = new char[][]{new char[]{'X', 'X'}, new char[]{'X', 'Y'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSubmatrices(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[\".\",\".\"],[\".\",\".\"]]");
        try {
            char[][] grid = new char[][]{new char[]{'.', '.'}, new char[]{'.', '.'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSubmatrices(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}