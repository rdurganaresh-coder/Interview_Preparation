package com.leetcode.graphs_shortest_path;

class Solution2192 {
    private int n;
    private List<Integer>[] g;
    private List<List<Integer>> ans;

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        g = new List[n];
        this.n = n;
        Arrays.setAll(g, i -> new ArrayList<>());
        for (var e : edges) {
            g[e[0]].add(e[1]);
        }
        ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            ans.add(new ArrayList<>());
        }
        for (int i = 0; i < n; ++i) {
            bfs(i);
        }
        return ans;
    }

    private void bfs(int s) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(s);
        boolean[] vis = new boolean[n];
        vis[s] = true;
        while (!q.isEmpty()) {
            int i = q.poll();
            for (int j : g[i]) {
                if (!vis[j]) {
                    vis[j] = true;
                    q.offer(j);
                    ans.get(j).add(s);
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
        Solution2192 _tcSol = new Solution2192();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 8, edgeList = [[0,3],[0,4],[1,3],[2,4],[2,7],[3,5],[3,6],[3,7],[4,6]]");
        try {
            int n = 8;
            int[][] edges = new int[][]{new int[]{0, 3}, new int[]{0, 4}, new int[]{1, 3}, new int[]{2, 4}, new int[]{2, 7}, new int[]{3, 5}, new int[]{3, 6}, new int[]{3, 7}, new int[]{4, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.getAncestors(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[],[],[],[0,1],[0,2],[0,1,3],[0,1,2,3,4],[0,1,2,3]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, edgeList = [[0,1],[0,2],[0,3],[0,4],[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]");
        try {
            int n = 5;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{0, 4}, new int[]{1, 2}, new int[]{1, 3}, new int[]{1, 4}, new int[]{2, 3}, new int[]{2, 4}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.getAncestors(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[],[0],[0,1],[0,1,2],[0,1,2,3]]");
        System.out.println();
    }
}