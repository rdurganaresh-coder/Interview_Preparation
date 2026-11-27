package com.leetcode.bit_manipulation_math;

class Solution2595_2 {
    public int[] evenOddBit(int n) {
        int mask = 0x5555;
        int even = Integer.bitCount(n & mask);
        int odd = Integer.bitCount(n & ~mask);
        return new int[] {even, odd};
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2595_2 _tcSol = new Solution2595_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 50");
        try {
            int n = 50;
            System.out.println("  Output  : " + _tcShow(_tcSol.evenOddBit(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2");
        try {
            int n = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.evenOddBit(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1]");
        System.out.println();
    }
}