package com.leetcode.matrices_grids;

class Solution1659 {
    private int m;
    private int mx;
    private int[] f;
    private int[][] g;
    private int[][] bits;
    private int[] ix;
    private int[] ex;
    private Integer[][][][] memo;
    private final int[][] h = {{0, 0, 0}, {0, -60, -10}, {0, -10, 40}};

    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        this.m = m;
        mx = (int) Math.pow(3, n);
        f = new int[mx];
        g = new int[mx][mx];
        bits = new int[mx][n];
        ix = new int[mx];
        ex = new int[mx];
        memo = new Integer[m][mx][introvertsCount + 1][extrovertsCount + 1];
        for (int i = 0; i < mx; ++i) {
            int mask = i;
            for (int j = 0; j < n; ++j) {
                int x = mask % 3;
                mask /= 3;
                bits[i][j] = x;
                if (x == 1) {
                    ix[i]++;
                    f[i] += 120;
                } else if (x == 2) {
                    ex[i]++;
                    f[i] += 40;
                }
                if (j > 0) {
                    f[i] += h[x][bits[i][j - 1]];
                }
            }
        }
        for (int i = 0; i < mx; ++i) {
            for (int j = 0; j < mx; ++j) {
                for (int k = 0; k < n; ++k) {
                    g[i][j] += h[bits[i][k]][bits[j][k]];
                }
            }
        }
        return dfs(0, 0, introvertsCount, extrovertsCount);
    }

    private int dfs(int i, int pre, int ic, int ec) {
        if (i == m || (ic == 0 && ec == 0)) {
            return 0;
        }
        if (memo[i][pre][ic][ec] != null) {
            return memo[i][pre][ic][ec];
        }
        int ans = 0;
        for (int cur = 0; cur < mx; ++cur) {
            if (ix[cur] <= ic && ex[cur] <= ec) {
                ans = Math.max(
                    ans, f[cur] + g[pre][cur] + dfs(i + 1, cur, ic - ix[cur], ec - ex[cur]));
            }
        }
        return memo[i][pre][ic][ec] = ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1659 _tcSol = new Solution1659();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "m = 2, n = 3, introvertsCount = 1, extrovertsCount = 2");
        try {
            int m = 2;
            int n = 3;
            int introvertsCount = 1;
            int extrovertsCount = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.getMaxGridHappiness(m, n, introvertsCount, extrovertsCount)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "240");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "m = 3, n = 1, introvertsCount = 2, extrovertsCount = 1");
        try {
            int m = 3;
            int n = 1;
            int introvertsCount = 2;
            int extrovertsCount = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.getMaxGridHappiness(m, n, introvertsCount, extrovertsCount)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "260");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "m = 2, n = 2, introvertsCount = 4, extrovertsCount = 0");
        try {
            int m = 2;
            int n = 2;
            int introvertsCount = 4;
            int extrovertsCount = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.getMaxGridHappiness(m, n, introvertsCount, extrovertsCount)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "240");
        System.out.println();
    }
}