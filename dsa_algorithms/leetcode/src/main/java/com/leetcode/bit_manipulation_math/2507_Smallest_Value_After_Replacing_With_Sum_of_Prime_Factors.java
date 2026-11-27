package com.leetcode.bit_manipulation_math;

class Solution2507 {
    public int smallestValue(int n) {
        while (true) {
            int t = n, s = 0;
            for (int i = 2; i <= n / i; ++i) {
                while (n % i == 0) {
                    s += i;
                    n /= i;
                }
            }
            if (n > 1) {
                s += n;
            }
            if (s == t) {
                return s;
            }
            n = s;
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2507 _tcSol = new Solution2507();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 15");
        try {
            int n = 15;
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestValue(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3");
        try {
            int n = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestValue(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}