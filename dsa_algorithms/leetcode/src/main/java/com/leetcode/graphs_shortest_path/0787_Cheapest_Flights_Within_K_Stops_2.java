package com.leetcode.graphs_shortest_path;

class Solution0787_2 {
    private int[][] memo;
    private int[][] g;
    private int dst;
    private static final int INF = (int) 1e6;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        n += 10;
        memo = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(memo[i], -1);
        }
        g = new int[n][n];
        for (int[] e : flights) {
            g[e[0]][e[1]] = e[2];
        }
        this.dst = dst;
        int ans = dfs(src, k + 1);
        return ans >= INF ? -1 : ans;
    }

    private int dfs(int u, int k) {
        if (memo[u][k] != -1) {
            return memo[u][k];
        }
        if (u == dst) {
            return 0;
        }
        if (k <= 0) {
            return INF;
        }
        int ans = INF;
        for (int v = 0; v < g[u].length; ++v) {
            if (g[u][v] > 0) {
                ans = Math.min(ans, dfs(v, k - 1) + g[u][v]);
            }
        }
        memo[u][k] = ans;
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0787_2 _tcSol = new Solution0787_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1");
        try {
            int n = 4;
            int[][] flights = new int[][]{new int[]{0, 1, 100}, new int[]{1, 2, 100}, new int[]{2, 0, 100}, new int[]{1, 3, 600}, new int[]{2, 3, 200}};
            int src = 0;
            int dst = 3;
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findCheapestPrice(n, flights, src, dst, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "700");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1");
        try {
            int n = 3;
            int[][] flights = new int[][]{new int[]{0, 1, 100}, new int[]{1, 2, 100}, new int[]{0, 2, 500}};
            int src = 0;
            int dst = 2;
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findCheapestPrice(n, flights, src, dst, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "200");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0");
        try {
            int n = 3;
            int[][] flights = new int[][]{new int[]{0, 1, 100}, new int[]{1, 2, 100}, new int[]{0, 2, 500}};
            int src = 0;
            int dst = 2;
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.findCheapestPrice(n, flights, src, dst, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "500");
        System.out.println();
    }
}