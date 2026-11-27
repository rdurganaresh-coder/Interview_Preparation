package com.leetcode.dynamic_programming;

class Solution2400 {
    private Integer[][] f;
    private final int mod = (int) 1e9 + 7;

    public int numberOfWays(int startPos, int endPos, int k) {
        f = new Integer[k + 1][k + 1];
        return dfs(Math.abs(startPos - endPos), k);
    }

    private int dfs(int i, int j) {
        if (i > j || j < 0) {
            return 0;
        }
        if (j == 0) {
            return i == 0 ? 1 : 0;
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        int ans = dfs(i + 1, j - 1) + dfs(Math.abs(i - 1), j - 1);
        ans %= mod;
        return f[i][j] = ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2400 _tcSol = new Solution2400();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "startPos = 1, endPos = 2, k = 3");
        try {
            int startPos = 1;
            int endPos = 2;
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfWays(startPos, endPos, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "startPos = 2, endPos = 5, k = 10");
        try {
            int startPos = 2;
            int endPos = 5;
            int k = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfWays(startPos, endPos, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}