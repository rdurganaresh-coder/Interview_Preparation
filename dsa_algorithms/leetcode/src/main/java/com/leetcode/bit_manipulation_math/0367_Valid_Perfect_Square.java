package com.leetcode.bit_manipulation_math;

class Solution0367 {
    public boolean isPerfectSquare(int num) {
        int l = 1, r = num;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (1L * mid * mid >= num) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l * l == num;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0367 _tcSol = new Solution0367();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = 16");
        try {
            int num = 16;
            System.out.println("  Output  : " + _tcShow(_tcSol.isPerfectSquare(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = 14");
        try {
            int num = 14;
            System.out.println("  Output  : " + _tcShow(_tcSol.isPerfectSquare(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}