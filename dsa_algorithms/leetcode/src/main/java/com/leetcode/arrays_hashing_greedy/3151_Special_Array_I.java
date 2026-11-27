package com.leetcode.arrays_hashing_greedy;

class Solution3151 {
    public boolean isArraySpecial(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] % 2 == nums[i - 1] % 2) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3151 _tcSol = new Solution3151();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1]");
        try {
            int[] nums = new int[]{1};
            System.out.println("  Output  : " + _tcShow(_tcSol.isArraySpecial(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,1,4]");
        try {
            int[] nums = new int[]{2, 1, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.isArraySpecial(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [4,3,1,6]");
        try {
            int[] nums = new int[]{4, 3, 1, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.isArraySpecial(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}