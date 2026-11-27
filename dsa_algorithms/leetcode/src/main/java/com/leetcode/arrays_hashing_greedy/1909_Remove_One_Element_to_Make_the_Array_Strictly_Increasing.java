package com.leetcode.arrays_hashing_greedy;

class Solution1909 {
    public boolean canBeIncreasing(int[] nums) {
        int i = 0;
        while (i + 1 < nums.length && nums[i] < nums[i + 1]) {
            ++i;
        }
        return check(nums, i) || check(nums, i + 1);
    }

    private boolean check(int[] nums, int k) {
        int pre = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i == k) {
                continue;
            }
            if (pre >= nums[i]) {
                return false;
            }
            pre = nums[i];
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1909 _tcSol = new Solution1909();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,10,5,7]");
        try {
            int[] nums = new int[]{1, 2, 10, 5, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.canBeIncreasing(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,3,1,2]");
        try {
            int[] nums = new int[]{2, 3, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.canBeIncreasing(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,1,1]");
        try {
            int[] nums = new int[]{1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.canBeIncreasing(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
