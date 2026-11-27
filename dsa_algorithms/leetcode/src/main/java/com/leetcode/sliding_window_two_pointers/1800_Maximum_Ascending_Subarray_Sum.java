package com.leetcode.sliding_window_two_pointers;

class Solution1800 {
    public int maxAscendingSum(int[] nums) {
        int ans = 0, t = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                t += nums[i];
                ans = Math.max(ans, t);
            } else {
                t = nums[i];
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1800 _tcSol = new Solution1800();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [10,20,30,5,10,50]");
        try {
            int[] nums = new int[]{10, 20, 30, 5, 10, 50};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxAscendingSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "65");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [10,20,30,40,50]");
        try {
            int[] nums = new int[]{10, 20, 30, 40, 50};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxAscendingSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "150");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [12,17,15,13,10,11,12]");
        try {
            int[] nums = new int[]{12, 17, 15, 13, 10, 11, 12};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxAscendingSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "33");
        System.out.println();
    }
}