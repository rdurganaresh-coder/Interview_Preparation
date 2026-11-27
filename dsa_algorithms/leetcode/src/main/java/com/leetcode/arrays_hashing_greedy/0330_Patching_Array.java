package com.leetcode.arrays_hashing_greedy;

class Solution0330 {
    public int minPatches(int[] nums, int n) {
        long x = 1;
        int ans = 0;
        for (int i = 0; x <= n;) {
            if (i < nums.length && nums[i] <= x) {
                x += nums[i++];
            } else {
                ++ans;
                x <<= 1;
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
        Solution0330 _tcSol = new Solution0330();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3], n = 6");
        try {
            int[] nums = new int[]{1, 3};
            int n = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.minPatches(nums, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,5,10], n = 20");
        try {
            int[] nums = new int[]{1, 5, 10};
            int n = 20;
            System.out.println("  Output  : " + _tcShow(_tcSol.minPatches(nums, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,2], n = 5");
        try {
            int[] nums = new int[]{1, 2, 2};
            int n = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.minPatches(nums, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}