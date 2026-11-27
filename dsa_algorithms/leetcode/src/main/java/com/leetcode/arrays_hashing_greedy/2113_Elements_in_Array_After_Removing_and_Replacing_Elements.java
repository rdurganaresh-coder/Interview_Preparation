package com.leetcode.arrays_hashing_greedy;

class Solution2113 {
    public int[] elementInNums(int[] nums, int[][] queries) {
        int n = nums.length, m = queries.length;
        int[] ans = new int[m];
        for (int j = 0; j < m; ++j) {
            ans[j] = -1;
            int t = queries[j][0], i = queries[j][1];
            t %= (2 * n);
            if (t < n && i < n - t) {
                ans[j] = nums[i + t];
            } else if (t > n && i < t - n) {
                ans[j] = nums[i];
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
        Solution2113 _tcSol = new Solution2113();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [0,1,2], queries = [[0,2],[2,0],[3,2],[5,0]]");
        try {
            int[] nums = new int[]{0, 1, 2};
            int[][] queries = new int[][]{new int[]{0, 2}, new int[]{2, 0}, new int[]{3, 2}, new int[]{5, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.elementInNums(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,2,-1,0]");
        System.out.println();
    }
}