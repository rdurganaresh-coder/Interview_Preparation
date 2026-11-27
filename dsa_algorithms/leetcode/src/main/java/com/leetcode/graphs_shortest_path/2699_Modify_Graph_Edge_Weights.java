package com.leetcode.graphs_shortest_path;

class Solution2699 {
    private final int inf = 2000000000;

    public int[][] modifiedGraphEdges(
        int n, int[][] edges, int source, int destination, int target) {
        long d = dijkstra(edges, n, source, destination);
        if (d < target) {
            return new int[0][];
        }
        boolean ok = d == target;
        for (var e : edges) {
            if (e[2] > 0) {
                continue;
            }
            if (ok) {
                e[2] = inf;
                continue;
            }
            e[2] = 1;
            d = dijkstra(edges, n, source, destination);
            if (d <= target) {
                ok = true;
                e[2] += target - d;
            }
        }
        return ok ? edges : new int[0][];
    }

    private long dijkstra(int[][] edges, int n, int src, int dest) {
        int[][] g = new int[n][n];
        long[] dist = new long[n];
        Arrays.fill(dist, inf);
        dist[src] = 0;
        for (var f : g) {
            Arrays.fill(f, inf);
        }
        for (var e : edges) {
            int a = e[0], b = e[1], w = e[2];
            if (w == -1) {
                continue;
            }
            g[a][b] = w;
            g[b][a] = w;
        }
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int k = -1;
            for (int j = 0; j < n; ++j) {
                if (!vis[j] && (k == -1 || dist[k] > dist[j])) {
                    k = j;
                }
            }
            vis[k] = true;
            for (int j = 0; j < n; ++j) {
                dist[j] = Math.min(dist[j], dist[k] + g[k][j]);
            }
        }
        return dist[dest];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2699 _tcSol = new Solution2699();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, edges = [[4,1,-1],[2,0,-1],[0,3,-1],[4,3,-1]], source = 0, destination = 1, target = 5");
        try {
            int n = 5;
            int[][] edges = new int[][]{new int[]{4, 1, -1}, new int[]{2, 0, -1}, new int[]{0, 3, -1}, new int[]{4, 3, -1}};
            int source = 0;
            int destination = 1;
            int target = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.modifiedGraphEdges(n, edges, source, destination, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[4,1,1],[2,0,1],[0,3,3],[4,3,1]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, edges = [[0,1,-1],[0,2,5]], source = 0, destination = 2, target = 6");
        try {
            int n = 3;
            int[][] edges = new int[][]{new int[]{0, 1, -1}, new int[]{0, 2, 5}};
            int source = 0;
            int destination = 2;
            int target = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.modifiedGraphEdges(n, edges, source, destination, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 4, edges = [[1,0,4],[1,2,3],[2,3,5],[0,3,-1]], source = 0, destination = 2, target = 6");
        try {
            int n = 4;
            int[][] edges = new int[][]{new int[]{1, 0, 4}, new int[]{1, 2, 3}, new int[]{2, 3, 5}, new int[]{0, 3, -1}};
            int source = 0;
            int destination = 2;
            int target = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.modifiedGraphEdges(n, edges, source, destination, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,0,4],[1,2,3],[2,3,5],[0,3,1]]");
        System.out.println();
    }
}