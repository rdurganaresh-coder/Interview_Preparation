package com.leetcode.arrays_hashing_greedy;

class Solution0486 {
    private int[] nums;
    private int[][] f;

    public boolean predictTheWinner(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        f = new int[n][n];
        return dfs(0, n - 1) >= 0;
    }

    private int dfs(int i, int j) {
        if (i > j) {
            return 0;
        }
        if (f[i][j] != 0) {
            return f[i][j];
        }
        return f[i][j] = Math.max(nums[i] - dfs(i + 1, j), nums[j] - dfs(i, j - 1));
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0486 _tcSol = new Solution0486();
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