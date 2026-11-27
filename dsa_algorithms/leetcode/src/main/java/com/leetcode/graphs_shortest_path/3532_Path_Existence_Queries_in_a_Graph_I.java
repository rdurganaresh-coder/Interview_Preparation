package com.leetcode.graphs_shortest_path;

class Solution3532 {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] g = new int[n];
        int cnt = 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                cnt++;
            }
            g[i] = cnt;
        }

        int m = queries.length;
        boolean[] ans = new boolean[m];
        for (int i = 0; i < m; ++i) {
            int u = queries[i][0];
            int v = queries[i][1];
            ans[i] = g[u] == g[v];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3532 _tcSol = new Solution3532();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 2, nums = [1,3], maxDiff = 1, queries = [[0,0],[0,1]]");
        try {
            int n = 2;
            int[] nums = new int[]{1, 3};
            int maxDiff = 1;
            int[][] queries = new int[][]{new int[]{0, 0}, new int[]{0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.pathExistenceQueries(n, nums, maxDiff, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[true,false]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, nums = [2,5,6,8], maxDiff = 2, queries = [[0,1],[0,2],[1,3],[2,3]]");
        try {
            int n = 4;
            int[] nums = new int[]{2, 5, 6, 8};
            int maxDiff = 2;
            int[][] queries = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 3}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.pathExistenceQueries(n, nums, maxDiff, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[false,false,true,true]");
        System.out.println();
    }
}
