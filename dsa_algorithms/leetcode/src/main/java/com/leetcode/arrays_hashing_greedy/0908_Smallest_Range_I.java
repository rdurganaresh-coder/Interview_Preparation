package com.leetcode.arrays_hashing_greedy;

class Solution0908 {
    public int smallestRangeI(int[] nums, int k) {
        int mx = 0;
        int mi = 10000;
        for (int v : nums) {
            mx = Math.max(mx, v);
            mi = Math.min(mi, v);
        }
        return Math.max(0, mx - mi - k * 2);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0908 _tcSol = new Solution0908();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1], k = 0");
        try {
            int[] nums = new int[]{1};
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestRangeI(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,10], k = 2");
        try {
            int[] nums = new int[]{0, 10};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestRangeI(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,3,6], k = 3");
        try {
            int[] nums = new int[]{1, 3, 6};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestRangeI(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}