package com.leetcode.bit_manipulation_math;

class Solution1015 {
    public int smallestRepunitDivByK(int k) {
        int n = 1 % k;
        for (int i = 1; i <= k; ++i) {
            if (n == 0) {
                return i;
            }
            n = (n * 10 + 1) % k;
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1015 _tcSol = new Solution1015();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "k = 1");
        try {
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestRepunitDivByK(k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "k = 2");
        try {
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestRepunitDivByK(k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "k = 3");
        try {
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestRepunitDivByK(k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}