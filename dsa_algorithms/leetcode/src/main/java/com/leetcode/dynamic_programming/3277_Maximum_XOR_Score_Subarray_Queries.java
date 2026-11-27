package com.leetcode.dynamic_programming;

class Solution3277 {
    public int[] maximumSubarrayXor(int[] nums, int[][] queries) {
        int n = nums.length;
        int[][] f = new int[n][n];
        int[][] g = new int[n][n];
        for (int i = n - 1; i >= 0; --i) {
            f[i][i] = nums[i];
            g[i][i] = nums[i];
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = f[i][j - 1] ^ f[i + 1][j];
                g[i][j] = Math.max(f[i][j], Math.max(g[i][j - 1], g[i + 1][j]));
            }
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; ++i) {
            int l = queries[i][0], r = queries[i][1];
            ans[i] = g[l][r];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3277 _tcSol = new Solution3277();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,8,4,32,16,1], queries = [[0,2],[1,4],[0,5]]");
        try {
            int[] nums = new int[]{2, 8, 4, 32, 16, 1};
            int[][] queries = new int[][]{new int[]{0, 2}, new int[]{1, 4}, new int[]{0, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSubarrayXor(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[12,60,60]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,7,3,2,8,5,1], queries = [[0,3],[1,5],[2,4],[2,6],[5,6]]");
        try {
            int[] nums = new int[]{0, 7, 3, 2, 8, 5, 1};
            int[][] queries = new int[][]{new int[]{0, 3}, new int[]{1, 5}, new int[]{2, 4}, new int[]{2, 6}, new int[]{5, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSubarrayXor(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[7,14,11,14,5]");
        System.out.println();
    }
}
