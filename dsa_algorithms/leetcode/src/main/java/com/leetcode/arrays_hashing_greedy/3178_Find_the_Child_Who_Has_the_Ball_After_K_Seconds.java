package com.leetcode.arrays_hashing_greedy;

class Solution3178 {
    public int numberOfChild(int n, int k) {
        int mod = k % (n - 1);
        k /= (n - 1);
        return k % 2 == 1 ? n - mod - 1 : mod;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3178 _tcSol = new Solution3178();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, k = 5");
        try {
            int n = 3;
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfChild(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, k = 6");
        try {
            int n = 5;
            int k = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfChild(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 4, k = 2");
        try {
            int n = 4;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfChild(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}