package com.leetcode.dynamic_programming;

class Solution3196_2 {
    public long maximumTotalCost(int[] nums) {
        long f = Long.MIN_VALUE / 2, g = 0;
        for (int x : nums) {
            long ff = Math.max(f, g) + x;
            long gg = f - x;
            f = ff;
            g = gg;
        }
        return Math.max(f, g);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3196_2 _tcSol = new Solution3196_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,-2,3,4]");
        try {
            int[] nums = new int[]{1, -2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumTotalCost(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,-1,1,-1]");
        try {
            int[] nums = new int[]{1, -1, 1, -1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumTotalCost(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [0]");
        try {
            int[] nums = new int[]{0};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumTotalCost(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "nums = [1,-1]");
        try {
            int[] nums = new int[]{1, -1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumTotalCost(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}