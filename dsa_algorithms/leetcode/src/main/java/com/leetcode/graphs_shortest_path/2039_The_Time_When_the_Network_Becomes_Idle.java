package com.leetcode.graphs_shortest_path;

class Solution2039 {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
        }
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        boolean[] vis = new boolean[n];
        vis[0] = true;
        int ans = 0, d = 0;
        while (!q.isEmpty()) {
            ++d;
            int t = d * 2;
            for (int i = q.size(); i > 0; --i) {
                int u = q.poll();
                for (int v : g[u]) {
                    if (!vis[v]) {
                        vis[v] = true;
                        q.offer(v);
                        ans = Math.max(ans, (t - 1) / patience[v] * patience[v] + t + 1);
                    }
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
        Solution2039 _tcSol = new Solution2039();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges = [[0,1],[1,2]], patience = [0,2,1]");
        try {
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}};
            int[] patience = new int[]{0, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.networkBecomesIdle(edges, patience)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges = [[0,1],[0,2],[1,2]], patience = [0,10,10]");
        try {
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 2}};
            int[] patience = new int[]{0, 10, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.networkBecomesIdle(edges, patience)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}