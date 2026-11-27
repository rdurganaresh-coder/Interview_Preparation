package com.leetcode.arrays_hashing_greedy;

class Solution0486_2 {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; ++i) {
            f[i][i] = nums[i];
        }
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = Math.max(nums[i] - f[i + 1][j], nums[j] - f[i][j - 1]);
            }
        }
        return f[0][n - 1] >= 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0486_2 _tcSol = new Solution0486_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,5,2]");
        try {
            int[] nums = new int[]{1, 5, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.predictTheWinner(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,5,233,7]");
        try {
            int[] nums = new int[]{1, 5, 233, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.predictTheWinner(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}