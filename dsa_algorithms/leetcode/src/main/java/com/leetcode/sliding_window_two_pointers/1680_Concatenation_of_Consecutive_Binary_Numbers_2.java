package com.leetcode.sliding_window_two_pointers;

class Solution1680_2 {
    public int concatenatedBinary(int n) {
        final int mod = (int) 1e9 + 7;
        long ans = 0;
        int shift = 0;
        for (int i = 1; i <= n; ++i) {
            if ((i & (i - 1)) == 0) {
                ++shift;
            }
            ans = (ans << shift | i) % mod;
        }
        return (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1680_2 _tcSol = new Solution1680_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 1");
        try {
            int n = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.concatenatedBinary(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3");
        try {
            int n = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.concatenatedBinary(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "27");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 12");
        try {
            int n = 12;
            System.out.println("  Output  : " + _tcShow(_tcSol.concatenatedBinary(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "505379714");
        System.out.println();
    }
}