package com.leetcode.graphs_shortest_path;

class Solution0576 {
    private int m, n;
    private Integer[][][] f;
    private final int mod = (int) 1e9 + 7;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m;
        this.n = n;
        f = new Integer[m][n][maxMove + 1];
        return dfs(startRow, startColumn, maxMove);
    }

    private int dfs(int i, int j, int k) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return k >= 0 ? 1 : 0;
        }
        if (k <= 0) {
            return 0;
        }
        if (f[i][j][k] != null) {
            return f[i][j][k];
        }
        int ans = 0;
        final int[] dirs = {-1, 0, 1, 0, -1};
        for (int d = 0; d < 4; ++d) {
            int x = i + dirs[d], y = j + dirs[d + 1];
            ans = (ans + dfs(x, y, k - 1)) % mod;
        }
        return f[i][j][k] = ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0576 _tcSol = new Solution0576();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0");
        try {
            int m = 2;
            int n = 2;
            int maxMove = 2;
            int startRow = 0;
            int startColumn = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.findPaths(m, n, maxMove, startRow, startColumn)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1");
        try {
            int m = 1;
            int n = 3;
            int maxMove = 3;
            int startRow = 0;
            int startColumn = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findPaths(m, n, maxMove, startRow, startColumn)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();
    }
}
