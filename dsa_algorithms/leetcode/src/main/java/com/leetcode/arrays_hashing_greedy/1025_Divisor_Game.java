package com.leetcode.arrays_hashing_greedy;

class Solution1025 {
    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1025 _tcSol = new Solution1025();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 2");
        try {
            int n = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.divisorGame(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3");
        try {
            int n = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.divisorGame(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}