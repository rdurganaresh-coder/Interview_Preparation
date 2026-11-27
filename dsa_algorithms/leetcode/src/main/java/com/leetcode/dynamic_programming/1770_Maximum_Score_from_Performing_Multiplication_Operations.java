package com.leetcode.dynamic_programming;

class Solution1770 {
    private Integer[][] f;
    private int[] multipliers;
    private int[] nums;
    private int n;
    private int m;

    public int maximumScore(int[] nums, int[] multipliers) {
        n = nums.length;
        m = multipliers.length;
        f = new Integer[m][m];
        this.nums = nums;
        this.multipliers = multipliers;
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i >= m || j >= m || (i + j) >= m) {
            return 0;
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        int k = i + j;
        int a = dfs(i + 1, j) + nums[i] * multipliers[k];
        int b = dfs(i, j + 1) + nums[n - 1 - j] * multipliers[k];
        f[i][j] = Math.max(a, b);
        return f[i][j];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1770 _tcSol = new Solution1770();
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