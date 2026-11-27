package com.leetcode.arrays_hashing_greedy;

class Solution0066 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            ++digits[i];
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0066 _tcSol = new Solution0066();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "digits = [1,2,3]");
        try {
            int[] digits = new int[]{1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.plusOne(digits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "digits = [4,3,2,1]");
        try {
            int[] digits = new int[]{4, 3, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.plusOne(digits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,3,2,2]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "digits = [9]");
        try {
            int[] digits = new int[]{9};
            System.out.println("  Output  : " + _tcShow(_tcSol.plusOne(digits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,0]");
        System.out.println();
    }
}