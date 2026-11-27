package com.leetcode.bit_manipulation_math;

class Solution0007 {
    public int reverse(int x) {
        int ans = 0;
        for (; x != 0; x /= 10) {
            if (ans < Integer.MIN_VALUE / 10 || ans > Integer.MAX_VALUE / 10) {
                return 0;
            }
            ans = ans * 10 + x % 10;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0007 _tcSol = new Solution0007();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "x = 123");
        try {
            int x = 123;
            System.out.println("  Output  : " + _tcShow(_tcSol.reverse(x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "321");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "x = -123");
        try {
            int x = -123;
            System.out.println("  Output  : " + _tcShow(_tcSol.reverse(x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-321");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "x = 120");
        try {
            int x = 120;
            System.out.println("  Output  : " + _tcShow(_tcSol.reverse(x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "21");
        System.out.println();
    }
}