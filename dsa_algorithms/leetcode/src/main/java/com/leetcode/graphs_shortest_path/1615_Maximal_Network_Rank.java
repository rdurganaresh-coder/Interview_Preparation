package com.leetcode.graphs_shortest_path;

class Solution1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] g = new int[n][n];
        int[] cnt = new int[n];
        for (var r : roads) {
            int a = r[0], b = r[1];
            g[a][b] = 1;
            g[b][a] = 1;
            ++cnt[a];
            ++cnt[b];
        }
        int ans = 0;
        for (int a = 0; a < n; ++a) {
            for (int b = a + 1; b < n; ++b) {
                ans = Math.max(ans, cnt[a] + cnt[b] - g[a][b]);
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
        Solution1615 _tcSol = new Solution1615();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]");
        try {
            int n = 4;
            int[][] roads = new int[][]{new int[]{0, 1}, new int[]{0, 3}, new int[]{1, 2}, new int[]{1, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximalNetworkRank(n, roads)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, roads = [[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]]");
        try {
            int n = 5;
            int[][] roads = new int[][]{new int[]{0, 1}, new int[]{0, 3}, new int[]{1, 2}, new int[]{1, 3}, new int[]{2, 3}, new int[]{2, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximalNetworkRank(n, roads)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 8, roads = [[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]");
        try {
            int n = 8;
            int[][] roads = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{2, 4}, new int[]{5, 6}, new int[]{5, 7}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximalNetworkRank(n, roads)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}