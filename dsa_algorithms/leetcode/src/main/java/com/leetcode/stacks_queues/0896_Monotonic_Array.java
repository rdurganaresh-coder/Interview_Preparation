package com.leetcode.stacks_queues;

class Solution0896 {
    public boolean isMonotonic(int[] nums) {
        boolean asc = false, desc = false;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] < nums[i]) {
                asc = true;
            } else if (nums[i - 1] > nums[i]) {
                desc = true;
            }
            if (asc && desc) {
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
        Solution0896 _tcSol = new Solution0896();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,2,3]");
        try {
            int[] nums = new int[]{1, 2, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.isMonotonic(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [6,5,4,4]");
        try {
            int[] nums = new int[]{6, 5, 4, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.isMonotonic(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,3,2]");
        try {
            int[] nums = new int[]{1, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.isMonotonic(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}