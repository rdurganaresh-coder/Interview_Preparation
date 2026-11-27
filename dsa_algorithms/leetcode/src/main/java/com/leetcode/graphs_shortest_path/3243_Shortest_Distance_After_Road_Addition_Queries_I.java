package com.leetcode.graphs_shortest_path;

class Solution3243 {
    private List<Integer>[] g;
    private int n;

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        this.n = n;
        g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 0; i < n - 1; ++i) {
            g[i].add(i + 1);
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; ++i) {
            int u = queries[i][0], v = queries[i][1];
            g[u].add(v);
            ans[i] = bfs(0);
        }
        return ans;
    }

    private int bfs(int i) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(i);
        boolean[] vis = new boolean[n];
        vis[i] = true;
        for (int d = 0;; ++d) {
            for (int k = q.size(); k > 0; --k) {
                int u = q.poll();
                if (u == n - 1) {
                    return d;
                }
                for (int v : g[u]) {
                    if (!vis[v]) {
                        vis[v] = true;
                        q.offer(v);
                    }
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
        Solution3243 _tcSol = new Solution3243();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, queries = [[2,4],[0,2],[0,4]]");
        try {
            int n = 5;
            int[][] queries = new int[][]{new int[]{2, 4}, new int[]{0, 2}, new int[]{0, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestDistanceAfterQueries(n, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,2,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, queries = [[0,3],[0,2]]");
        try {
            int n = 4;
            int[][] queries = new int[][]{new int[]{0, 3}, new int[]{0, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestDistanceAfterQueries(n, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1]");
        System.out.println();
    }
}
