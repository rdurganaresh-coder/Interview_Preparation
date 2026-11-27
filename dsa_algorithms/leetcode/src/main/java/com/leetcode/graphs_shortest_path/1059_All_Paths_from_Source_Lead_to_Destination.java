package com.leetcode.graphs_shortest_path;

class Solution1059 {
    private List<Integer>[] g;
    private int[] st;
    private int destination;

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        this.destination = destination;
        g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
        }
        if (!g[destination].isEmpty()) {
            return false;
        }
        st = new int[n];
        return dfs(source);
    }

    private boolean dfs(int i) {
        if (st[i] != 0) {
            return st[i] == 2;
        }
        if (g[i].isEmpty()) {
            return i == destination;
        }
        st[i] = 1;
        for (int j : g[i]) {
            if (!dfs(j)) {
                return false;
            }
        }
        st[i] = 2;
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1059 _tcSol = new Solution1059();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, edges = [[0,1],[0,2]], source = 0, destination = 2");
        try {
            int n = 3;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}};
            int source = 0;
            int destination = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.leadsToDestination(n, edges, source, destination)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, edges = [[0,1],[0,3],[1,2],[2,1]], source = 0, destination = 3");
        try {
            int n = 4;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 3}, new int[]{1, 2}, new int[]{2, 1}};
            int source = 0;
            int destination = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.leadsToDestination(n, edges, source, destination)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 4, edges = [[0,1],[0,2],[1,3],[2,3]], source = 0, destination = 3");
        try {
            int n = 4;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 3}, new int[]{2, 3}};
            int source = 0;
            int destination = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.leadsToDestination(n, edges, source, destination)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}
