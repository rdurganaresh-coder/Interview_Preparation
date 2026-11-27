package com.leetcode.bit_manipulation_math;

class Solution0633_2 {
    public boolean judgeSquareSum(int c) {
        int n = (int) Math.sqrt(c);
        for (int i = 2; i <= n; ++i) {
            if (c % i == 0) {
                int exp = 0;
                while (c % i == 0) {
                    c /= i;
                    ++exp;
                }
                if (i % 4 == 3 && exp % 2 != 0) {
                    return false;
                }
            }
        }
        return c % 4 != 3;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0633_2 _tcSol = new Solution0633_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "c = 5");
        try {
            int c = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.judgeSquareSum(c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "c = 3");
        try {
            int c = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.judgeSquareSum(c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
