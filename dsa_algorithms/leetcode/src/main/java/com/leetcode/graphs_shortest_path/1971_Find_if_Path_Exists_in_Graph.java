package com.leetcode.graphs_shortest_path;

class Solution1971 {
    private int destination;
    private boolean[] vis;
    private List<Integer>[] g;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        this.destination = destination;
        vis = new boolean[n];
        g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (var e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
        }
        return dfs(source);
    }

    private boolean dfs(int i) {
        if (i == destination) {
            return true;
        }
        vis[i] = true;
        for (var j : g[i]) {
            if (!vis[j] && dfs(j)) {
                return true;
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1971 _tcSol = new Solution1971();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2");
        try {
            int n = 3;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}};
            int source = 0;
            int destination = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.validPath(n, edges, source, destination)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5");
        try {
            int n = 6;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{3, 5}, new int[]{5, 4}, new int[]{4, 3}};
            int source = 0;
            int destination = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.validPath(n, edges, source, destination)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
