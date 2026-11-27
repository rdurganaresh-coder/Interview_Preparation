package com.leetcode.arrays_hashing_greedy;

class Solution1906 {
    public int[] minDifference(int[] nums, int[][] queries) {
        int m = nums.length, n = queries.length;
        int[][] preSum = new int[m + 1][101];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= 100; ++j) {
                int t = nums[i - 1] == j ? 1 : 0;
                preSum[i][j] = preSum[i - 1][j] + t;
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            int left = queries[i][0], right = queries[i][1] + 1;
            int t = Integer.MAX_VALUE;
            int last = -1;
            for (int j = 1; j <= 100; ++j) {
                if (preSum[right][j] > preSum[left][j]) {
                    if (last != -1) {
                        t = Math.min(t, j - last);
                    }
                    last = j;
                }
            }
            if (t == Integer.MAX_VALUE) {
                t = -1;
            }
            ans[i] = t;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1906 _tcSol = new Solution1906();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,4,8], queries = [[0,1],[1,2],[2,3],[0,3]]");
        try {
            int[] nums = new int[]{1, 3, 4, 8};
            int[][] queries = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{0, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minDifference(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,1,4,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,5,2,2,7,10], queries = [[2,3],[0,2],[0,5],[3,5]]");
        try {
            int[] nums = new int[]{4, 5, 2, 2, 7, 10};
            int[][] queries = new int[][]{new int[]{2, 3}, new int[]{0, 2}, new int[]{0, 5}, new int[]{3, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minDifference(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,1,1,3]");
        System.out.println();
    }
}