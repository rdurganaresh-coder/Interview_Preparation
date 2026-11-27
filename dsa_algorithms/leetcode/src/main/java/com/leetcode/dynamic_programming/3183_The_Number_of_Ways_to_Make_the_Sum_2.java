package com.leetcode.dynamic_programming;

class Solution3183_2 {
    private static final int MOD = 1000000007;
    private static final int M = 100001;
    private static final int[] COINS = {1, 2, 6};
    private static final int[] f = new int[M];

    static {
        f[0] = 1;
        for (int x : COINS) {
            for (int j = x; j < M; ++j) {
                f[j] = (f[j] + f[j - x]) % MOD;
            }
        }
    }

    public int numberOfWays(int n) {
        int ans = f[n];
        if (n >= 4) {
            ans = (ans + f[n - 4]) % MOD;
        }
        if (n >= 8) {
            ans = (ans + f[n - 8]) % MOD;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3183_2 _tcSol = new Solution3183_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4");
        try {
            int n = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfWays(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 12");
        try {
            int n = 12;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfWays(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "22");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 5");
        try {
            int n = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfWays(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}