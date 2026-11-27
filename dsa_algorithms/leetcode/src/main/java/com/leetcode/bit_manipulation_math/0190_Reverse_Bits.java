package com.leetcode.bit_manipulation_math;

class Solution0190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            ans |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0190 _tcSol = new Solution0190();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 43261596");
        try {
            int n = 43261596;
            System.out.println("  Output  : " + _tcShow(_tcSol.reverseBits(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "964176192");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2147483644");
        try {
            int n = 2147483644;
            System.out.println("  Output  : " + _tcShow(_tcSol.reverseBits(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1073741822");
        System.out.println();
    }
}