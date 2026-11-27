package com.leetcode.bit_manipulation_math;

class Solution3129 {
    private final int mod = (int) 1e9 + 7;
    private Long[][][] f;
    private int limit;

    public int numberOfStableArrays(int zero, int one, int limit) {
        f = new Long[zero + 1][one + 1][2];
        this.limit = limit;
        return (int) ((dfs(zero, one, 0) + dfs(zero, one, 1)) % mod);
    }

    private long dfs(int i, int j, int k) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (i == 0) {
            return k == 1 && j <= limit ? 1 : 0;
        }
        if (j == 0) {
            return k == 0 && i <= limit ? 1 : 0;
        }
        if (f[i][j][k] != null) {
            return f[i][j][k];
        }
        if (k == 0) {
            f[i][j][k]
                = (dfs(i - 1, j, 0) + dfs(i - 1, j, 1) - dfs(i - limit - 1, j, 1) + mod) % mod;
        } else {
            f[i][j][k]
                = (dfs(i, j - 1, 0) + dfs(i, j - 1, 1) - dfs(i, j - limit - 1, 0) + mod) % mod;
        }
        return f[i][j][k];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3129 _tcSol = new Solution3129();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "zero = 1, one = 1, limit = 2");
        try {
            int zero = 1;
            int one = 1;
            int limit = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfStableArrays(zero, one, limit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "zero = 1, one = 2, limit = 1");
        try {
            int zero = 1;
            int one = 2;
            int limit = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfStableArrays(zero, one, limit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "zero = 3, one = 3, limit = 2");
        try {
            int zero = 3;
            int one = 3;
            int limit = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfStableArrays(zero, one, limit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "14");
        System.out.println();
    }
}