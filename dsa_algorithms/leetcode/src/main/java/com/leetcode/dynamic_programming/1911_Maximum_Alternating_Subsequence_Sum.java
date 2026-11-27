package com.leetcode.dynamic_programming;

class Solution1911 {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] f = new long[n + 1];
        long[] g = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            f[i] = Math.max(g[i - 1] - nums[i - 1], f[i - 1]);
            g[i] = Math.max(f[i - 1] + nums[i - 1], g[i - 1]);
        }
        return Math.max(f[n], g[n]);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1911 _tcSol = new Solution1911();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,2,5,3]");
        try {
            int[] nums = new int[]{4, 2, 5, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxAlternatingSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,6,7,8]");
        try {
            int[] nums = new int[]{5, 6, 7, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxAlternatingSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [6,2,1,2,4,5]");
        try {
            int[] nums = new int[]{6, 2, 1, 2, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxAlternatingSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}