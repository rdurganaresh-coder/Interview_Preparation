package com.leetcode.arrays_hashing_greedy;

class Solution0813_2 {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[][] f = new double[n + 1][k + 1];
        int[] s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + nums[i];
        }
        for (int i = 1; i <= n; ++i) {
            f[i][1] = s[i] * 1.0 / i;
            for (int j = 2; j <= Math.min(i, k); ++j) {
                for (int h = 0; h < i; ++h) {
                    f[i][j] = Math.max(f[i][j], f[h][j - 1] + (s[i] - s[h]) * 1.0 / (i - h));
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
        Solution0813_2 _tcSol = new Solution0813_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [9,1,2,3,9], k = 3");
        try {
            int[] nums = new int[]{9, 1, 2, 3, 9};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.largestSumOfAverages(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20.00000");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5,6,7], k = 4");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.largestSumOfAverages(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20.50000");
        System.out.println();
    }
}
