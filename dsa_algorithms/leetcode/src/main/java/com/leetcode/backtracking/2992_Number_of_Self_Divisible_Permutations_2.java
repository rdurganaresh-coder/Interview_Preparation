package com.leetcode.backtracking;

class Solution2992_2 {
    public int selfDivisiblePermutationCount(int n) {
        int[] f = new int[1 << n];
        f[0] = 1;
        for (int mask = 0; mask < 1 << n; ++mask) {
            int i = Integer.bitCount(mask);
            for (int j = 1; j <= n; ++j) {
                if (((mask >> (j - 1)) & 1) == 1 && gcd(i, j) == 1) {
                    f[mask] += f[mask ^ (1 << (j - 1))];
                }
            }
        }
        return f[(1 << n) - 1];
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
        Solution2992_2 _tcSol = new Solution2992_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 1");
        try {
            int n = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.selfDivisiblePermutationCount(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2");
        try {
            int n = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.selfDivisiblePermutationCount(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 3");
        try {
            int n = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.selfDivisiblePermutationCount(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}