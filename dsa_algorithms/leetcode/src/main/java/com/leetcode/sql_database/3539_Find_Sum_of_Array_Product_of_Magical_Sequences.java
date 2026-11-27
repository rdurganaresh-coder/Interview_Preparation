package com.leetcode.sql_database;

class Solution3539 {
    static final int N = 31;
    static final long MOD = 1_000_000_007L;
    private static final long[] f = new long[N];
    private static final long[] g = new long[N];
    private Long[][][][] dp;

    static {
        f[0] = 1;
        g[0] = 1;
        for (int i = 1; i < N; ++i) {
            f[i] = f[i - 1] * i % MOD;
            g[i] = qpow(f[i], MOD - 2);
        }
    }

    public static long qpow(long a, long k) {
        long res = 1;
        while (k != 0) {
            if ((k & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            k >>= 1;
        }
        return res;
    }

    public static long comb(int m, int n) {
        return f[m] * g[n] % MOD * g[m - n] % MOD;
    }

    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length;
        dp = new Long[n + 1][m + 1][k + 1][N];
        long ans = dfs(0, m, k, 0, nums);
        return (int) ans;
    }

    private long dfs(int i, int j, int k, int st, int[] nums) {
        if (k < 0 || (i == nums.length && j > 0)) {
            return 0;
        }
        if (i == nums.length) {
            while (st > 0) {
                k -= (st & 1);
                st >>= 1;
            }
            return k == 0 ? 1 : 0;
        }

        if (dp[i][j][k][st] != null) {
            return dp[i][j][k][st];
        }

        long res = 0;
        for (int t = 0; t <= j; t++) {
            int nt = t + st;
            int nk = k - (nt & 1);
            long p = qpow(nums[i], t);
            long tmp = comb(j, t) * p % MOD * dfs(i + 1, j - t, nk, nt >> 1, nums) % MOD;
            res = (res + tmp) % MOD;
        }

        return dp[i][j][k][st] = res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3539 _tcSol = new Solution3539();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "m = 5, k = 5, nums = [1,10,100,10000,1000000]");
        try {
            int m = 5;
            int k = 5;
            int[] nums = new int[]{1, 10, 100, 10000, 1000000};
            System.out.println("  Output  : " + _tcShow(_tcSol.magicalSum(m, k, nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "991600007");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "m = 2, k = 2, nums = [5,4,3,2,1]");
        try {
            int m = 2;
            int k = 2;
            int[] nums = new int[]{5, 4, 3, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.magicalSum(m, k, nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "170");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "m = 1, k = 1, nums = [28]");
        try {
            int m = 1;
            int k = 1;
            int[] nums = new int[]{28};
            System.out.println("  Output  : " + _tcShow(_tcSol.magicalSum(m, k, nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "28");
        System.out.println();
    }
}
