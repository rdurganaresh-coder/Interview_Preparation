package com.leetcode.bit_manipulation_math;

class Solution3082 {
    public int sumOfPower(int[] nums, int k) {
        final int mod = (int) 1e9 + 7;
        int n = nums.length;
        int[][] f = new int[n + 1][k + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= k; ++j) {
                f[i][j] = (f[i - 1][j] * 2) % mod;
                if (j >= nums[i - 1]) {
                    f[i][j] = (f[i][j] + f[i - 1][j - nums[i - 1]]) % mod;
                }
            }
        }
        return f[n][k];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3082 _tcSol = new Solution3082();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3], k = 3");
        try {
            int[] nums = new int[]{1, 2, 3};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfPower(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,3,3], k = 5");
        try {
            int[] nums = new int[]{2, 3, 3};
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfPower(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3], k = 7");
        try {
            int[] nums = new int[]{1, 2, 3};
            int k = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfPower(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
