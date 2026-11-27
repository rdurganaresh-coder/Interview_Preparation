package com.leetcode.arrays_hashing_greedy;

class Solution2664 {
    private int[][] g;
    private int m;
    private int n;
    private boolean ok;

    public int[][] tourOfKnight(int m, int n, int r, int c) {
        this.m = m;
        this.n = n;
        this.g = new int[m][n];
        for (var row : g) {
            Arrays.fill(row, -1);
        }
        g[r][c] = 0;
        dfs(r, c);
        return g;
    }

    private void dfs(int i, int j) {
        if (g[i][j] == m * n - 1) {
            ok = true;
            return;
        }
        int[] dirs = {-2, -1, 2, 1, -2, 1, 2, -1, -2};
        for (int k = 0; k < 8; ++k) {
            int x = i + dirs[k], y = j + dirs[k + 1];
            if (x >= 0 && x < m && y >= 0 && y < n && g[x][y] == -1) {
                g[x][y] = g[i][j] + 1;
                dfs(x, y);
                if (ok) {
                    return;
                }
                g[x][y] = -1;
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2664 _tcSol = new Solution2664();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "m = 1, n = 1, r = 0, c = 0");
        try {
            int m = 1;
            int n = 1;
            int r = 0;
            int c = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.tourOfKnight(m, n, r, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "m = 3, n = 4, r = 0, c = 0");
        try {
            int m = 3;
            int n = 4;
            int r = 0;
            int c = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.tourOfKnight(m, n, r, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,3,6,9],[11,8,1,4],[2,5,10,7]]");
        System.out.println();
    }
}