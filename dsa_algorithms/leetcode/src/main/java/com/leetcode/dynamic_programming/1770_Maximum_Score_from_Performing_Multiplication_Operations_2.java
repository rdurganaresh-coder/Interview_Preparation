package com.leetcode.dynamic_programming;

class Solution1770_2 {
    public int maximumScore(int[] nums, int[] multipliers) {
        final int inf = 1 << 30;
        int n = nums.length, m = multipliers.length;
        int[][] f = new int[m + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(f[i], -inf);
        }
        f[0][0] = 0;
        int ans = -inf;
        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= m - i; ++j) {
                int k = i + j - 1;
                if (i > 0) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j] + multipliers[k] * nums[i - 1]);
                }
                if (j > 0) {
                    f[i][j] = Math.max(f[i][j], f[i][j - 1] + multipliers[k] * nums[n - j]);
                }
                if (i + j == m) {
                    ans = Math.max(ans, f[i][j]);
                }
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1770_2 _tcSol = new Solution1770_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3], multipliers = [3,2,1]");
        try {
            int[] nums = new int[]{1, 2, 3};
            int[] multipliers = new int[]{3, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumScore(nums, multipliers)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "14");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-5,-3,-3,-2,7,1], multipliers = [-10,-5,3,4,6]");
        try {
            int[] nums = new int[]{-5, -3, -3, -2, 7, 1};
            int[] multipliers = new int[]{-10, -5, 3, 4, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumScore(nums, multipliers)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "102");
        System.out.println();
    }
}