package com.leetcode.sql_database;

class Solution0628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int a = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int b = nums[n - 1] * nums[0] * nums[1];
        return Math.max(a, b);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0628 _tcSol = new Solution0628();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,-3]");
        try {
            int[] nums = new int[]{1, 2, -3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumProduct(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4]");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumProduct(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "24");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [-1,-2,-3]");
        try {
            int[] nums = new int[]{-1, -2, -3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumProduct(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-6");
        System.out.println();
    }
}