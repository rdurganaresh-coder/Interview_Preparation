package com.leetcode.bit_manipulation_math;

class Solution3336_2 {
    public int subsequencePairCount(int[] nums) {
        final int MOD = 1_000_000_007;
        int m = 0;
        for (int x : nums) {
            m = Math.max(m, x);
        }
        int[][] f = new int[m + 1][m + 1];
        f[0][0] = 1;
        for (int x : nums) {
            int[][] g = new int[m + 1][m + 1];
            for (int j = 0; j <= m; ++j) {
                for (int k = 0; k <= m; ++k) {
                    if (f[j][k] == 0) {
                        continue;
                    }
                    int v = f[j][k];
                    g[j][k] = (g[j][k] + v) % MOD;
                    int nj = gcd(x, j);
                    g[nj][k] = (g[nj][k] + v) % MOD;
                    int nk = gcd(x, k);
                    g[j][nk] = (g[j][nk] + v) % MOD;
                }
            }
            f = g;
        }
        long ans = 0;
        for (int i = 0; i <= m; ++i) {
            ans += f[i][i];
        }
        return (int) ((ans - 1 + MOD) % MOD);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3336_2 _tcSol = new Solution3336_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4]");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.subsequencePairCount(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [10,20,30]");
        try {
            int[] nums = new int[]{10, 20, 30};
            System.out.println("  Output  : " + _tcShow(_tcSol.subsequencePairCount(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,1,1,1]");
        try {
            int[] nums = new int[]{1, 1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.subsequencePairCount(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "50");
        System.out.println();
    }
}
