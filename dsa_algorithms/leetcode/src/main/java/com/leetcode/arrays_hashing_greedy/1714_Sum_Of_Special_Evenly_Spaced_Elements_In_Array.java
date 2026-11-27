package com.leetcode.arrays_hashing_greedy;

class Solution1714 {
    public int[] solve(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = (int) Math.sqrt(n);
        final int mod = (int) 1e9 + 7;
        int[][] suf = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = n - 1; j >= 0; --j) {
                suf[i][j] = (suf[i][Math.min(n, j + i)] + nums[j]) % mod;
            }
        }
        int k = queries.length;
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            int x = queries[i][0];
            int y = queries[i][1];
            if (y <= m) {
                ans[i] = suf[y][x];
            } else {
                int s = 0;
                for (int j = x; j < n; j += y) {
                    s = (s + nums[j]) % mod;
                }
                ans[i] = s;
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
        Solution1714 _tcSol = new Solution1714();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [0,1,2,3,4,5,6,7], queries = [[0,3],[5,1],[4,2]]");
        try {
            int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
            int[][] queries = new int[][]{new int[]{0, 3}, new int[]{5, 1}, new int[]{4, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.solve(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[9,18,10]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [100,200,101,201,102,202,103,203], queries = [[0,7]]");
        try {
            int[] nums = new int[]{100, 200, 101, 201, 102, 202, 103, 203};
            int[][] queries = new int[][]{new int[]{0, 7}};
            System.out.println("  Output  : " + _tcShow(_tcSol.solve(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[303]");
        System.out.println();
    }
}