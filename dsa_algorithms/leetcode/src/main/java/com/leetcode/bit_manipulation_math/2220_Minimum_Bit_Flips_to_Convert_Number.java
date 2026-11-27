package com.leetcode.bit_manipulation_math;

class Solution2220 {
    public int minBitFlips(int start, int goal) {
        return Integer.bitCount(start ^ goal);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2220 _tcSol = new Solution2220();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "start = 10, goal = 7");
        try {
            int start = 10;
            int goal = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.minBitFlips(start, goal)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "start = 3, goal = 4");
        try {
            int start = 3;
            int goal = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minBitFlips(start, goal)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
