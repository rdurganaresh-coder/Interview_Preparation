package com.leetcode.arrays_hashing_greedy;

class Solution1413 {
    public int minStartValue(int[] nums) {
        int s = 0;
        int t = Integer.MAX_VALUE;
        for (int num : nums) {
            s += num;
            t = Math.min(t, s);
        }
        return Math.max(1, 1 - t);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1413 _tcSol = new Solution1413();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [-3,2,-3,4,2]");
        try {
            int[] nums = new int[]{-3, 2, -3, 4, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minStartValue(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2]");
        try {
            int[] nums = new int[]{1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minStartValue(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,-2,-3]");
        try {
            int[] nums = new int[]{1, -2, -3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minStartValue(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}