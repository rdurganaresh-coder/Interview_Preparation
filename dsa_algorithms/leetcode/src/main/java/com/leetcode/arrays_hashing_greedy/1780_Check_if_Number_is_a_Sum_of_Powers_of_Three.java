package com.leetcode.arrays_hashing_greedy;

class Solution1780 {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 > 1) {
                return false;
            }
            n /= 3;
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1780 _tcSol = new Solution1780();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 12");
        try {
            int n = 12;
            System.out.println("  Output  : " + _tcShow(_tcSol.checkPowersOfThree(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 91");
        try {
            int n = 91;
            System.out.println("  Output  : " + _tcShow(_tcSol.checkPowersOfThree(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 21");
        try {
            int n = 21;
            System.out.println("  Output  : " + _tcShow(_tcSol.checkPowersOfThree(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}