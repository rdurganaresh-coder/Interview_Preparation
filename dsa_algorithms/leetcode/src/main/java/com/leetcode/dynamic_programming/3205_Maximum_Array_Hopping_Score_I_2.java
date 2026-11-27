package com.leetcode.dynamic_programming;

class Solution3205_2 {
    public int maxScore(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        for (int j = 1; j < n; ++j) {
            for (int i = 0; i < j; ++i) {
                f[j] = Math.max(f[j], f[i] + (j - i) * nums[j]);
            }
        }
        return f[n - 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3205_2 _tcSol = new Solution3205_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,5,8]");
        try {
            int[] nums = new int[]{1, 5, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,5,2,8,9,1,3]");
        try {
            int[] nums = new int[]{4, 5, 2, 8, 9, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "42");
        System.out.println();
    }
}