package com.leetcode.bit_manipulation_math;

class Solution2310_2 {
    public int minimumNumbers(int num, int k) {
        if (num == 0) {
            return 0;
        }
        for (int i = 1; i <= 10; ++i) {
            if ((k * i) % 10 == num % 10 && k * i <= num) {
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
        Solution2310_2 _tcSol = new Solution2310_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = 58, k = 9");
        try {
            int num = 58;
            int k = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumNumbers(num, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = 37, k = 2");
        try {
            int num = 37;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumNumbers(num, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "num = 0, k = 7");
        try {
            int num = 0;
            int k = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumNumbers(num, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}