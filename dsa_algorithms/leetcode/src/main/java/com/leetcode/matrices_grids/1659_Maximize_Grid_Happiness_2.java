package com.leetcode.matrices_grids;

class Solution1659_2 {
    private int m;
    private int n;
    private int p;
    private final int[][] h = {{0, 0, 0}, {0, -60, -10}, {0, -10, 40}};
    private Integer[][][][] memo;

    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        this.m = m;
        this.n = n;
        p = (int) Math.pow(3, n - 1);
        memo = new Integer[m * n][p * 3][introvertsCount + 1][extrovertsCount + 1];
        return dfs(0, 0, introvertsCount, extrovertsCount);
    }

    private int dfs(int pos, int pre, int ic, int ec) {
        if (pos == m * n || (ic == 0 && ec == 0)) {
            return 0;
        }
        if (memo[pos][pre][ic][ec] != null) {
            return memo[pos][pre][ic][ec];
        }
        int ans = 0;
        int up = pre / p;
        int left = pos % n == 0 ? 0 : pre % 3;
        for (int i = 0; i < 3; ++i) {
            if (i == 1 && (ic == 0) || (i == 2 && ec == 0)) {
                continue;
            }
            int cur = pre % p * 3 + i;
            int a = h[up][i] + h[left][i];
            int b = dfs(pos + 1, cur, ic - (i == 1 ? 1 : 0), ec - (i == 2 ? 1 : 0));
            int c = i == 1 ? 120 : (i == 2 ? 40 : 0);
            ans = Math.max(ans, a + b + c);
        }
        return memo[pos][pre][ic][ec] = ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1659_2 _tcSol = new Solution1659_2();
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