package com.leetcode.arrays_hashing_greedy;

class Solution0396 {
    public int maxRotateFunction(int[] nums) {
        long f = 0;
        long s = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            f += 1L * i * nums[i];
            s += nums[i];
        }
        long ans = f;
        for (int i = 1; i < n; ++i) {
            f = f + s - 1L * n * nums[n - i];
            ans = Math.max(ans, f);
        }
        return (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0396 _tcSol = new Solution0396();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,3,2,6]");
        try {
            int[] nums = new int[]{4, 3, 2, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxRotateFunction(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "26");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [100]");
        try {
            int[] nums = new int[]{100};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxRotateFunction(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}