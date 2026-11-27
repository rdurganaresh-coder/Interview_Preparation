package com.leetcode.graphs_shortest_path;

class Solution2608 {
    private List<Integer>[] g;
    private final int inf = 1 << 30;

    public int findShortestCycle(int n, int[][] edges) {
        g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
        }
        int ans = inf;
        for (var e : edges) {
            int u = e[0], v = e[1];
            ans = Math.min(ans, bfs(u, v));
        }
        return ans < inf ? ans : -1;
    }

    private int bfs(int u, int v) {
        int[] dist = new int[g.length];
        Arrays.fill(dist, inf);
        dist[u] = 0;
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(u);
        while (!q.isEmpty()) {
            int i = q.poll();
            for (int j : g[i]) {
                if ((i == u && j == v) || (i == v && j == u) || dist[j] != inf) {
                    continue;
                }
                dist[j] = dist[i] + 1;
                q.offer(j);
            }
        }
        return dist[v] + 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2608 _tcSol = new Solution2608();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 7, edges = [[0,1],[1,2],[2,0],[3,4],[4,5],[5,6],[6,3]]");
        try {
            int n = 7;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}, new int[]{3, 4}, new int[]{4, 5}, new int[]{5, 6}, new int[]{6, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findShortestCycle(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, edges = [[0,1],[0,2]]");
        try {
            int n = 4;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findShortestCycle(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}