package com.leetcode.arrays_hashing_greedy;

class Solution3339 {
    private Integer[][][] f;
    private long cnt0, cnt1;
    private final int mod = (int) 1e9 + 7;

    public int countOfArrays(int n, int m, int k) {
        f = new Integer[n][k + 1][2];
        cnt0 = m / 2;
        cnt1 = m - cnt0;
        return dfs(0, k, 1);
    }

    private int dfs(int i, int j, int k) {
        if (j < 0) {
            return 0;
        }
        if (i >= f.length) {
            return j == 0 ? 1 : 0;
        }
        if (f[i][j][k] != null) {
            return f[i][j][k];
        }
        int a = (int) (cnt1 * dfs(i + 1, j, 1) % mod);
        int b = (int) (cnt0 * dfs(i + 1, j - (k & 1 ^ 1), 0) % mod);
        return f[i][j][k] = (a + b) % mod;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3339 _tcSol = new Solution3339();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, m = 4, k = 2");
        try {
            int n = 3;
            int m = 4;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.countOfArrays(n, m, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, m = 1, k = 0");
        try {
            int n = 5;
            int m = 1;
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.countOfArrays(n, m, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 7, m = 7, k = 5");
        try {
            int n = 7;
            int m = 7;
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.countOfArrays(n, m, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5832");
        System.out.println();
    }
}
