package com.leetcode.bit_manipulation_math;

class Solution3550 {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int s = 0;
            while (nums[i] != 0) {
                s += nums[i] % 10;
                nums[i] /= 10;
            }
            if (s == i) {
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
        Solution3550 _tcSol = new Solution3550();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,2]");
        try {
            int[] nums = new int[]{1, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestIndex(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,10,11]");
        try {
            int[] nums = new int[]{1, 10, 11};
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestIndex(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3]");
        try {
            int[] nums = new int[]{1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestIndex(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}