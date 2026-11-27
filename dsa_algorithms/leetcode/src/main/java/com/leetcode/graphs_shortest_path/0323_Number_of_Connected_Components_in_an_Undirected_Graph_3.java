package com.leetcode.graphs_shortest_path;

class Solution0323_3 {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        int ans = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (vis[i]) {
                continue;
            }
            vis[i] = true;
            ++ans;
            Deque<Integer> q = new ArrayDeque<>();
            q.offer(i);
            while (!q.isEmpty()) {
                int a = q.poll();
                for (int b : g[a]) {
                    if (!vis[b]) {
                        vis[b] = true;
                        q.offer(b);
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
        Solution0323_3 _tcSol = new Solution0323_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, edges = [[0,1],[1,2],[3,4]]");
        try {
            int n = 5;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countComponents(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]");
        try {
            int n = 5;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countComponents(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}