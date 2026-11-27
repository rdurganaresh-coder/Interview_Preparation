package com.leetcode.graphs_shortest_path;

class Solution2203 {
    private static final Long INF = Long.MAX_VALUE;

    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        List<Pair<Integer, Long>>[] g = new List[n];
        List<Pair<Integer, Long>>[] rg = new List[n];
        for (int i = 0; i < n; ++i) {
            g[i] = new ArrayList<>();
            rg[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int f = e[0], t = e[1];
            long w = e[2];
            g[f].add(new Pair<>(t, w));
            rg[t].add(new Pair<>(f, w));
        }
        long[] d1 = dijkstra(g, src1);
        long[] d2 = dijkstra(g, src2);
        long[] d3 = dijkstra(rg, dest);
        long ans = -1;
        for (int i = 0; i < n; ++i) {
            if (d1[i] == INF || d2[i] == INF || d3[i] == INF) {
                continue;
            }
            long t = d1[i] + d2[i] + d3[i];
            if (ans == -1 || ans > t) {
                ans = t;
            }
        }
        return ans;
    }

    private long[] dijkstra(List<Pair<Integer, Long>>[] g, int u) {
        int n = g.length;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[u] = 0;
        PriorityQueue<Pair<Long, Integer>> q
            = new PriorityQueue<>(Comparator.comparingLong(Pair::getKey));
        q.offer(new Pair<>(0L, u));
        while (!q.isEmpty()) {
            Pair<Long, Integer> p = q.poll();
            long d = p.getKey();
            u = p.getValue();
            if (d > dist[u]) {
                continue;
            }
            for (Pair<Integer, Long> e : g[u]) {
                int v = e.getKey();
                long w = e.getValue();
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    q.offer(new Pair<>(dist[v], v));
                }
            }
        }
        return dist;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2203 _tcSol = new Solution2203();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 6, edges = [[0,2,2],[0,5,6],[1,0,3],[1,4,5],[2,1,1],[2,3,3],[2,3,4],[3,4,2],[4,5,1]], src1 = 0, src2 = 1, dest = 5");
        try {
            int n = 6;
            int[][] edges = new int[][]{new int[]{0, 2, 2}, new int[]{0, 5, 6}, new int[]{1, 0, 3}, new int[]{1, 4, 5}, new int[]{2, 1, 1}, new int[]{2, 3, 3}, new int[]{2, 3, 4}, new int[]{3, 4, 2}, new int[]{4, 5, 1}};
            int src1 = 0;
            int src2 = 1;
            int dest = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumWeight(n, edges, src1, src2, dest)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, edges = [[0,1,1],[2,1,1]], src1 = 0, src2 = 1, dest = 2");
        try {
            int n = 3;
            int[][] edges = new int[][]{new int[]{0, 1, 1}, new int[]{2, 1, 1}};
            int src1 = 0;
            int src2 = 1;
            int dest = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumWeight(n, edges, src1, src2, dest)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}