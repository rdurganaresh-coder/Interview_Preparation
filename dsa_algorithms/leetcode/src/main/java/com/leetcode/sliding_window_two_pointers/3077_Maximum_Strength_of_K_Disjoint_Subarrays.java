package com.leetcode.sliding_window_two_pointers;

class Solution3077 {
    public long maximumStrength(int[] nums, int k) {
        int n = nums.length;
        long[][][] f = new long[n + 1][k + 1][2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                Arrays.fill(f[i][j], Long.MIN_VALUE / 2);
            }
        }
        f[0][0][0] = 0;
        for (int i = 1; i <= n; i++) {
            int x = nums[i - 1];
            for (int j = 0; j <= k; j++) {
                long sign = (j & 1) == 1 ? 1 : -1;
                long val = sign * x * (k - j + 1);
                f[i][j][0] = Math.max(f[i - 1][j][0], f[i - 1][j][1]);
                f[i][j][1] = Math.max(f[i][j][1], f[i - 1][j][1] + val);
                if (j > 0) {
                    long t = Math.max(f[i - 1][j - 1][0], f[i - 1][j - 1][1]) + val;
                    f[i][j][1] = Math.max(f[i][j][1], t);
                }
            }
        }
        return Math.max(f[n][k][0], f[n][k][1]);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3077 _tcSol = new Solution3077();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,-1,2], k = 3");
        try {
            int[] nums = new int[]{1, 2, 3, -1, 2};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumStrength(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "22");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [12,-2,-2,-2,-2], k = 5");
        try {
            int[] nums = new int[]{12, -2, -2, -2, -2};
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumStrength(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "64");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [-1,-2,-3], k = 1");
        try {
            int[] nums = new int[]{-1, -2, -3};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumStrength(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
