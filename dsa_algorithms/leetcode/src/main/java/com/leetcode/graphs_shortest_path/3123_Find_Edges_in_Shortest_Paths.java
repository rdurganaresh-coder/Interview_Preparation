package com.leetcode.graphs_shortest_path;

class Solution3123 {
    public boolean[] findAnswer(int n, int[][] edges) {
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        int m = edges.length;
        for (int i = 0; i < m; ++i) {
            int a = edges[i][0], b = edges[i][1], w = edges[i][2];
            g[a].add(new int[] {b, w, i});
            g[b].add(new int[] {a, w, i});
        }
        long[] dist = new long[n];
        final long inf = (long) 1e18;
        Arrays.fill(dist, inf);
        dist[0] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[] {0, 0});
        while (!pq.isEmpty()) {
            var p = pq.poll();
            long da = p[0];
            int a = (int) p[1];
            if (da > dist[a]) {
                continue;
            }
            for (var e : g[a]) {
                int b = e[0], w = e[1];
                if (dist[b] > dist[a] + w) {
                    dist[b] = dist[a] + w;
                    pq.offer(new long[] {dist[b], b});
                }
            }
        }
        boolean[] ans = new boolean[m];
        if (dist[n - 1] == inf) {
            return ans;
        }
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(n - 1);
        while (!q.isEmpty()) {
            int a = q.poll();
            for (var e : g[a]) {
                int b = e[0], w = e[1], i = e[2];
                if (dist[a] == dist[b] + w) {
                    ans[i] = true;
                    q.offer(b);
                }
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
        Solution3123 _tcSol = new Solution3123();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 6, edges = [[0,1,4],[0,2,1],[1,3,2],[1,4,3],[1,5,1],[2,3,1],[3,5,3],[4,5,2]]");
        try {
            int n = 6;
            int[][] edges = new int[][]{new int[]{0, 1, 4}, new int[]{0, 2, 1}, new int[]{1, 3, 2}, new int[]{1, 4, 3}, new int[]{1, 5, 1}, new int[]{2, 3, 1}, new int[]{3, 5, 3}, new int[]{4, 5, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findAnswer(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[true,true,true,false,true,true,true,false]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, edges = [[2,0,1],[0,1,1],[0,3,4],[3,2,2]]");
        try {
            int n = 4;
            int[][] edges = new int[][]{new int[]{2, 0, 1}, new int[]{0, 1, 1}, new int[]{0, 3, 4}, new int[]{3, 2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findAnswer(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[true,false,false,true]");
        System.out.println();
    }
}