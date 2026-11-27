package com.leetcode.arrays_hashing_greedy;

class Solution1492 {
    public int kthFactor(int n, int k) {
        for (int i = 1; i <= n; ++i) {
            if (n % i == 0 && (--k == 0)) {
                return i;
            }
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1492 _tcSol = new Solution1492();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 12, k = 3");
        try {
            int n = 12;
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthFactor(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 7, k = 2");
        try {
            int n = 7;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthFactor(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 4, k = 4");
        try {
            int n = 4;
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthFactor(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}