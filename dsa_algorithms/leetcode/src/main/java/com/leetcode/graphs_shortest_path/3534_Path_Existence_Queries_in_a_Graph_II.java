package com.leetcode.graphs_shortest_path;

class Solution3534 {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        int m = 20;
        int[][] f = new int[n][m];
        int r = n - 1;
        for (int l = n - 1; l >= 0; l--) {
            while (pairs[r][0] - pairs[l][0] > maxDiff) {
                r--;
            }
            int i = pairs[l][1], j = pairs[r][1];
            f[i][0] = j;
            for (int k = 1; k < m; k++) {
                f[i][k] = f[f[i][k - 1]][k - 1];
            }
        }

        int[] ans = new int[queries.length];
        for (int t = 0; t < queries.length; t++) {
            int i = queries[t][0], j = queries[t][1];
            if (nums[i] > nums[j]) {
                int tmp = i;
                i = j;
                j = tmp;
            }
            if (i == j) {
                ans[t] = 0;
                continue;
            }
            if (nums[i] == nums[j]) {
                ans[t] = 1;
                continue;
            }
            int d = 0;
            for (int k = m - 1; k >= 0; k--) {
                if (nums[f[i][k]] < nums[j]) {
                    d |= 1 << k;
                    i = f[i][k];
                }
            }
            if (nums[f[i][0]] < nums[j]) {
                ans[t] = -1;
            } else {
                ans[t] = d + 1;
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
        Solution3534 _tcSol = new Solution3534();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, nums = [1,8,3,4,2], maxDiff = 3, queries = [[0,3],[2,4]]");
        try {
            int n = 5;
            int[] nums = new int[]{1, 8, 3, 4, 2};
            int maxDiff = 3;
            int[][] queries = new int[][]{new int[]{0, 3}, new int[]{2, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.pathExistenceQueries(n, nums, maxDiff, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, nums = [5,3,1,9,10], maxDiff = 2, queries = [[0,1],[0,2],[2,3],[4,3]]");
        try {
            int n = 5;
            int[] nums = new int[]{5, 3, 1, 9, 10};
            int maxDiff = 2;
            int[][] queries = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{2, 3}, new int[]{4, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.pathExistenceQueries(n, nums, maxDiff, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,-1,1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 3, nums = [3,6,1], maxDiff = 1, queries = [[0,0],[0,1],[1,2]]");
        try {
            int n = 3;
            int[] nums = new int[]{3, 6, 1};
            int maxDiff = 1;
            int[][] queries = new int[][]{new int[]{0, 0}, new int[]{0, 1}, new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.pathExistenceQueries(n, nums, maxDiff, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,-1,-1]");
        System.out.println();
    }
}