package com.leetcode.dynamic_programming;

class Solution3010 {
    public int minimumCost(int[] nums) {
        int a = nums[0], b = 100, c = 100;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < b) {
                c = b;
                b = nums[i];
            } else if (nums[i] < c) {
                c = nums[i];
            }
        }
        return a + b + c;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3010 _tcSol = new Solution3010();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,12]");
        try {
            int[] nums = new int[]{1, 2, 3, 12};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,4,3]");
        try {
            int[] nums = new int[]{5, 4, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [10,3,1,1]");
        try {
            int[] nums = new int[]{10, 3, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();
    }
}