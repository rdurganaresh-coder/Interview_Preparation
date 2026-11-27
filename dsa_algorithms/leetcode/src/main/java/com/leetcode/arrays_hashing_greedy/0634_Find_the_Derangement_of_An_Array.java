package com.leetcode.arrays_hashing_greedy;

class Solution0634 {
    public int findDerangement(int n) {
        long[] f = new long[n + 1];
        f[0] = 1;
        final int mod = (int) 1e9 + 7;
        for (int i = 2; i <= n; ++i) {
            f[i] = (i - 1) * (f[i - 1] + f[i - 2]) % mod;
        }
        return (int) f[n];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0634 _tcSol = new Solution0634();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3");
        try {
            int n = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.findDerangement(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2");
        try {
            int n = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.findDerangement(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}