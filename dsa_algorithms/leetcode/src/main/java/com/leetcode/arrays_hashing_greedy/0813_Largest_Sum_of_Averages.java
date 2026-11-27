package com.leetcode.arrays_hashing_greedy;

class Solution0813 {
    private Double[][] f;
    private int[] s;
    private int n;

    public double largestSumOfAverages(int[] nums, int k) {
        n = nums.length;
        s = new int[n + 1];
        f = new Double[n][k + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + nums[i];
        }
        return dfs(0, k);
    }

    private double dfs(int i, int k) {
        if (i == n) {
            return 0;
        }
        if (k == 1) {
            return (s[n] - s[i]) * 1.0 / (n - i);
        }
        if (f[i][k] != null) {
            return f[i][k];
        }
        double ans = 0;
        for (int j = i + 1; j < n; ++j) {
            ans = Math.max(ans, (s[j] - s[i]) * 1.0 / (j - i) + dfs(j, k - 1));
        }
        return f[i][k] = ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0813 _tcSol = new Solution0813();
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
