package com.leetcode.bit_manipulation_math;

class Solution3232 {
    public boolean canAliceWin(int[] nums) {
        int a = 0, b = 0;
        for (int x : nums) {
            if (x < 10) {
                a += x;
            } else {
                b += x;
            }
        }
        return a != b;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3232 _tcSol = new Solution3232();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4,10]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.canAliceWin(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5,14]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5, 14};
            System.out.println("  Output  : " + _tcShow(_tcSol.canAliceWin(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [5,5,5,25]");
        try {
            int[] nums = new int[]{5, 5, 5, 25};
            System.out.println("  Output  : " + _tcShow(_tcSol.canAliceWin(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}