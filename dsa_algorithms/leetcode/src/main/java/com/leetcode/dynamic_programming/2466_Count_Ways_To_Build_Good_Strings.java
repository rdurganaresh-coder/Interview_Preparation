package com.leetcode.dynamic_programming;

class Solution2466 {
    private static final int MOD = (int) 1e9 + 7;
    private int[] f;
    private int lo;
    private int hi;
    private int zero;
    private int one;

    public int countGoodStrings(int low, int high, int zero, int one) {
        f = new int[high + 1];
        Arrays.fill(f, -1);
        lo = low;
        hi = high;
        this.zero = zero;
        this.one = one;
        return dfs(0);
    }

    private int dfs(int i) {
        if (i > hi) {
            return 0;
        }
        if (f[i] != -1) {
            return f[i];
        }
        long ans = 0;
        if (i >= lo && i <= hi) {
            ++ans;
        }
        ans += dfs(i + zero) + dfs(i + one);
        ans %= MOD;
        f[i] = (int) ans;
        return f[i];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2466 _tcSol = new Solution2466();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "low = 3, high = 3, zero = 1, one = 1");
        try {
            int low = 3;
            int high = 3;
            int zero = 1;
            int one = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.countGoodStrings(low, high, zero, one)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "low = 2, high = 3, zero = 1, one = 2");
        try {
            int low = 2;
            int high = 3;
            int zero = 1;
            int one = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.countGoodStrings(low, high, zero, one)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}
