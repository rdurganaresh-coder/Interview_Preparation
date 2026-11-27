package com.leetcode.arrays_hashing_greedy;

class Solution0461 {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0461 _tcSol = new Solution0461();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "x = 1, y = 4");
        try {
            int x = 1;
            int y = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.hammingDistance(x, y)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "x = 3, y = 1");
        try {
            int x = 3;
            int y = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.hammingDistance(x, y)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}