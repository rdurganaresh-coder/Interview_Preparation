package com.leetcode.bit_manipulation_math;

class Solution3130_2 {
    public int numberOfStableArrays(int zero, int one, int limit) {
        final int mod = (int) 1e9 + 7;
        long[][][] f = new long[zero + 1][one + 1][2];
        for (int i = 1; i <= Math.min(zero, limit); ++i) {
            f[i][0][0] = 1;
        }
        for (int j = 1; j <= Math.min(one, limit); ++j) {
            f[0][j][1] = 1;
        }
        for (int i = 1; i <= zero; ++i) {
            for (int j = 1; j <= one; ++j) {
                long x = i - limit - 1 < 0 ? 0 : f[i - limit - 1][j][1];
                long y = j - limit - 1 < 0 ? 0 : f[i][j - limit - 1][0];
                f[i][j][0] = (f[i - 1][j][0] + f[i - 1][j][1] - x + mod) % mod;
                f[i][j][1] = (f[i][j - 1][0] + f[i][j - 1][1] - y + mod) % mod;
            }
        }
        return (int) ((f[zero][one][0] + f[zero][one][1]) % mod);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3130_2 _tcSol = new Solution3130_2();
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
