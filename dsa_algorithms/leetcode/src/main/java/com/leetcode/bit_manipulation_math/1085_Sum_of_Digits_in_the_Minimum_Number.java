package com.leetcode.bit_manipulation_math;

class Solution1085 {
    public int sumOfDigits(int[] nums) {
        int x = 100;
        for (int v : nums) {
            x = Math.min(x, v);
        }
        int s = 0;
        for (; x > 0; x /= 10) {
            s += x % 10;
        }
        return s & 1 ^ 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1085 _tcSol = new Solution1085();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [34,23,1,24,75,33,54,8]");
        try {
            int[] nums = new int[]{34, 23, 1, 24, 75, 33, 54, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfDigits(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [99,77,33,66,55]");
        try {
            int[] nums = new int[]{99, 77, 33, 66, 55};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfDigits(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}