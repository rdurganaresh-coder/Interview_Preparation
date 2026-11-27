package com.leetcode.arrays_hashing_greedy;

class Solution3018 {
    public int maximumProcessableQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int[][] f = new int[n][n];
        int m = queries.length;
        for (int i = 0; i < n; ++i) {
            for (int j = n - 1; j >= i; --j) {
                if (i > 0) {
                    f[i][j] = Math.max(
                        f[i][j], f[i - 1][j] + (nums[i - 1] >= queries[f[i - 1][j]] ? 1 : 0));
                }
                if (j + 1 < n) {
                    f[i][j] = Math.max(
                        f[i][j], f[i][j + 1] + (nums[j + 1] >= queries[f[i][j + 1]] ? 1 : 0));
                }
                if (f[i][j] == m) {
                    return m;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, f[i][i] + (nums[i] >= queries[f[i][i]] ? 1 : 0));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3018 _tcSol = new Solution3018();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5], queries = [1,2,3,4,6]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5};
            int[] queries = new int[]{1, 2, 3, 4, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumProcessableQueries(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,3,2], queries = [2,2,3]");
        try {
            int[] nums = new int[]{2, 3, 2};
            int[] queries = new int[]{2, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumProcessableQueries(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [3,4,3], queries = [4,3,2]");
        try {
            int[] nums = new int[]{3, 4, 3};
            int[] queries = new int[]{4, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumProcessableQueries(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}