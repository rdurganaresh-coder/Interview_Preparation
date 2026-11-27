package com.leetcode.arrays_hashing_greedy;

class Solution0217 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0217 _tcSol = new Solution0217();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,1]");
        try {
            int[] nums = new int[]{1, 2, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.containsDuplicate(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4]");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.containsDuplicate(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,1,1,3,3,4,3,2,4,2]");
        try {
            int[] nums = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.containsDuplicate(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}