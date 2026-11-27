package com.leetcode.arrays_hashing_greedy;

class Solution3351 {
    public int sumOfGoodSubsequences(int[] nums) {
        final int mod = (int) 1e9 + 7;
        int mx = 0;
        for (int x : nums) {
            mx = Math.max(mx, x);
        }
        long[] f = new long[mx + 1];
        long[] g = new long[mx + 1];
        for (int x : nums) {
            f[x] += x;
            g[x] += 1;
            if (x > 0) {
                f[x] = (f[x] + f[x - 1] + g[x - 1] * x % mod) % mod;
                g[x] = (g[x] + g[x - 1]) % mod;
            }
            if (x + 1 <= mx) {
                f[x] = (f[x] + f[x + 1] + g[x + 1] * x % mod) % mod;
                g[x] = (g[x] + g[x + 1]) % mod;
            }
        }
        long ans = 0;
        for (long x : f) {
            ans = (ans + x) % mod;
        }
        return (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3351 _tcSol = new Solution3351();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,1]");
        try {
            int[] nums = new int[]{1, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfGoodSubsequences(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "14");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,4,5]");
        try {
            int[] nums = new int[]{3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfGoodSubsequences(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "40");
        System.out.println();
    }
}
