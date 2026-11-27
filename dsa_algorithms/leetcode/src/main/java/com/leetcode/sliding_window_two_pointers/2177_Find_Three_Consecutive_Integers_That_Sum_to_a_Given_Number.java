package com.leetcode.sliding_window_two_pointers;

class Solution2177 {
    public long[] sumOfThree(long num) {
        if (num % 3 != 0) {
            return new long[] {};
        }
        long x = num / 3;
        return new long[] {x - 1, x, x + 1};
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2177 _tcSol = new Solution2177();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = 33");
        try {
            long num = 33L;
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfThree(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[10,11,12]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = 4");
        try {
            long num = 4L;
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfThree(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}