package com.leetcode.bit_manipulation_math;

class Solution3345 {
    public int smallestNumber(int n, int t) {
        for (int i = n;; ++i) {
            int p = 1;
            for (int x = i; x > 0; x /= 10) {
                p *= (x % 10);
            }
            if (p % t == 0) {
                return i;
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3345 _tcSol = new Solution3345();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 10, t = 2");
        try {
            int n = 10;
            int t = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestNumber(n, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 15, t = 3");
        try {
            int n = 15;
            int t = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestNumber(n, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();
    }
}
