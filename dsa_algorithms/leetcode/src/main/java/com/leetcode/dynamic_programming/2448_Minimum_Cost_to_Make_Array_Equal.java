package com.leetcode.dynamic_programming;

class Solution2448 {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; ++i) {
            arr[i] = new int[] {nums[i], cost[i]};
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        long[] f = new long[n + 1];
        long[] g = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            long a = arr[i - 1][0], b = arr[i - 1][1];
            f[i] = f[i - 1] + a * b;
            g[i] = g[i - 1] + b;
        }
        long ans = Long.MAX_VALUE;
        for (int i = 1; i <= n; ++i) {
            long a = arr[i - 1][0];
            long l = a * g[i - 1] - f[i - 1];
            long r = f[n] - f[i] - a * (g[n] - g[i]);
            ans = Math.min(ans, l + r);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2448 _tcSol = new Solution2448();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,5,2], cost = [2,3,1,14]");
        try {
            int[] nums = new int[]{1, 3, 5, 2};
            int[] cost = new int[]{2, 3, 1, 14};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(nums, cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,2,2,2,2], cost = [4,2,8,1,3]");
        try {
            int[] nums = new int[]{2, 2, 2, 2, 2};
            int[] cost = new int[]{4, 2, 8, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(nums, cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}