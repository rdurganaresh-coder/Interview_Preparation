package com.leetcode.arrays_hashing_greedy;

class Solution2919 {
    public long minIncrementOperations(int[] nums, int k) {
        long f = 0, g = 0, h = 0;
        for (int x : nums) {
            long hh = Math.min(Math.min(f, g), h) + Math.max(k - x, 0);
            f = g;
            g = h;
            h = hh;
        }
        return Math.min(Math.min(f, g), h);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2919 _tcSol = new Solution2919();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,3,0,0,2], k = 4");
        try {
            int[] nums = new int[]{2, 3, 0, 0, 2};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minIncrementOperations(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,1,3,3], k = 5");
        try {
            int[] nums = new int[]{0, 1, 3, 3};
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.minIncrementOperations(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,1,2], k = 1");
        try {
            int[] nums = new int[]{1, 1, 2};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minIncrementOperations(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}