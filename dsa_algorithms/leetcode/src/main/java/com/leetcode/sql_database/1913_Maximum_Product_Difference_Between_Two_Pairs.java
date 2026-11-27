package com.leetcode.sql_database;

class Solution1913 {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n - 1] * nums[n - 2] - nums[0] * nums[1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1913 _tcSol = new Solution1913();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [5,6,2,7,4]");
        try {
            int[] nums = new int[]{5, 6, 2, 7, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProductDifference(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "34");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,2,5,9,7,4,8]");
        try {
            int[] nums = new int[]{4, 2, 5, 9, 7, 4, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProductDifference(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "64");
        System.out.println();
    }
}