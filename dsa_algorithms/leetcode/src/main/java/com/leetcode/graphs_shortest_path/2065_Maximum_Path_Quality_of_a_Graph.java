package com.leetcode.graphs_shortest_path;

class Solution2065 {
    private List<int[]>[] g;
    private boolean[] vis;
    private int[] values;
    private int maxTime;
    private int ans;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int u = e[0], v = e[1], t = e[2];
            g[u].add(new int[] {v, t});
            g[v].add(new int[] {u, t});
        }
        vis = new boolean[n];
        vis[0] = true;
        this.values = values;
        this.maxTime = maxTime;
        dfs(0, 0, values[0]);
        return ans;
    }

    private void dfs(int u, int cost, int value) {
        if (u == 0) {
            ans = Math.max(ans, value);
        }
        for (var e : g[u]) {
            int v = e[0], t = e[1];
            if (cost + t <= maxTime) {
                if (vis[v]) {
                    dfs(v, cost + t, value);
                } else {
                    vis[v] = true;
                    dfs(v, cost + t, value + values[v]);
                    vis[v] = false;
                }
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2065 _tcSol = new Solution2065();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "values = [0,32,10,43], edges = [[0,1,10],[1,2,15],[0,3,10]], maxTime = 49");
        try {
            int[] values = new int[]{0, 32, 10, 43};
            int[][] edges = new int[][]{new int[]{0, 1, 10}, new int[]{1, 2, 15}, new int[]{0, 3, 10}};
            int maxTime = 49;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximalPathQuality(values, edges, maxTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "75");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "values = [5,10,15,20], edges = [[0,1,10],[1,2,10],[0,3,10]], maxTime = 30");
        try {
            int[] values = new int[]{5, 10, 15, 20};
            int[][] edges = new int[][]{new int[]{0, 1, 10}, new int[]{1, 2, 10}, new int[]{0, 3, 10}};
            int maxTime = 30;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximalPathQuality(values, edges, maxTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "25");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "values = [1,2,3,4], edges = [[0,1,10],[1,2,11],[2,3,12],[1,3,13]], maxTime = 50");
        try {
            int[] values = new int[]{1, 2, 3, 4};
            int[][] edges = new int[][]{new int[]{0, 1, 10}, new int[]{1, 2, 11}, new int[]{2, 3, 12}, new int[]{1, 3, 13}};
            int maxTime = 50;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximalPathQuality(values, edges, maxTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}