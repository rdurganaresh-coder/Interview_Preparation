package com.leetcode.bit_manipulation_math;

class Solution3226 {
    public int minChanges(int n, int k) {
        return (n & k) != k ? -1 : Integer.bitCount(n ^ k);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3226 _tcSol = new Solution3226();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 13, k = 4");
        try {
            int n = 13;
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minChanges(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 21, k = 21");
        try {
            int n = 21;
            int k = 21;
            System.out.println("  Output  : " + _tcShow(_tcSol.minChanges(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 14, k = 13");
        try {
            int n = 14;
            int k = 13;
            System.out.println("  Output  : " + _tcShow(_tcSol.minChanges(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}