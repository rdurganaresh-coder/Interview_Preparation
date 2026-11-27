package com.leetcode.trees_tries;

class Solution3313 {
    private List<Integer>[] g;

    public int[] lastMarkedNodes(int[][] edges) {
        int n = edges.length + 1;
        g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
        }
        int[] dist1 = new int[n];
        dist1[0] = 0;
        dfs(0, -1, dist1);
        int a = maxNode(dist1);

        int[] dist2 = new int[n];
        dist2[a] = 0;
        dfs(a, -1, dist2);
        int b = maxNode(dist2);

        int[] dist3 = new int[n];
        dist3[b] = 0;
        dfs(b, -1, dist3);

        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = dist2[i] > dist3[i] ? a : b;
        }
        return ans;
    }

    private void dfs(int i, int fa, int[] dist) {
        for (int j : g[i]) {
            if (j != fa) {
                dist[j] = dist[i] + 1;
                dfs(j, i, dist);
            }
        }
    }

    private int maxNode(int[] dist) {
        int mx = 0;
        for (int i = 0; i < dist.length; ++i) {
            if (dist[mx] < dist[i]) {
                mx = i;
            }
        }
        return mx;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3313 _tcSol = new Solution3313();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges = [[0,1],[0,2]]");
        try {
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.lastMarkedNodes(edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,2,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges = [[0,1]]");
        try {
            int[][] edges = new int[][]{new int[]{0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.lastMarkedNodes(edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,0]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "edges = [[0,1],[0,2],[2,3],[2,4]]");
        try {
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{2, 3}, new int[]{2, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.lastMarkedNodes(edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,3,1,1,1]");
        System.out.println();
    }
}
