package com.leetcode.dynamic_programming;

class Solution1269 {
    private Integer[][] f;
    private int n;

    public int numWays(int steps, int arrLen) {
        f = new Integer[steps][steps + 1];
        n = arrLen;
        return dfs(0, steps);
    }

    private int dfs(int i, int j) {
        if (i > j || i >= n || i < 0 || j < 0) {
            return 0;
        }
        if (i == 0 && j == 0) {
            return 1;
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        int ans = 0;
        final int mod = (int) 1e9 + 7;
        for (int k = -1; k <= 1; ++k) {
            ans = (ans + dfs(i + k, j - 1)) % mod;
        }
        return f[i][j] = ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1269 _tcSol = new Solution1269();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "steps = 3, arrLen = 2");
        try {
            int steps = 3;
            int arrLen = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.numWays(steps, arrLen)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "steps = 2, arrLen = 4");
        try {
            int steps = 2;
            int arrLen = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.numWays(steps, arrLen)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "steps = 4, arrLen = 2");
        try {
            int steps = 4;
            int arrLen = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.numWays(steps, arrLen)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();
    }
}