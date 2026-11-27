package com.leetcode.arrays_hashing_greedy;

class Solution3125 {
    public long maxNumber(long n) {
        return (1L << (63 - Long.numberOfLeadingZeros(n))) - 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3125 _tcSol = new Solution3125();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 7");
        try {
            long n = 7L;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNumber(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 9");
        try {
            long n = 9L;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNumber(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 17");
        try {
            long n = 17L;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNumber(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();
    }
}