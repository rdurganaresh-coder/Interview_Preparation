package com.leetcode.dynamic_programming;

class Solution1866_2 {
    public int rearrangeSticks(int n, int k) {
        final int mod = (int) 1e9 + 7;
        int[] f = new int[k + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = k; j > 0; --j) {
                f[j] = (int) ((f[j] * (i - 1L) + f[j - 1]) % mod);
            }
            f[0] = 0;
        }
        return f[k];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1866_2 _tcSol = new Solution1866_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, k = 2");
        try {
            int n = 3;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.rearrangeSticks(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, k = 5");
        try {
            int n = 5;
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.rearrangeSticks(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 20, k = 11");
        try {
            int n = 20;
            int k = 11;
            System.out.println("  Output  : " + _tcShow(_tcSol.rearrangeSticks(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "647427950");
        System.out.println();
    }
}