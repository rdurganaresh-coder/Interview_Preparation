package com.leetcode.arrays_hashing_greedy;

class Solution0779_2 {
    public int kthGrammar(int n, int k) {
        return Integer.bitCount(k - 1) & 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0779_2 _tcSol = new Solution0779_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 1, k = 1");
        try {
            int n = 1;
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthGrammar(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2, k = 1");
        try {
            int n = 2;
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthGrammar(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 2, k = 2");
        try {
            int n = 2;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthGrammar(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}