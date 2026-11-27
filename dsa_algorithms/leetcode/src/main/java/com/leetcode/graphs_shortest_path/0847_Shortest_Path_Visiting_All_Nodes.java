package com.leetcode.graphs_shortest_path;

class Solution0847 {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[n][1 << n];
        for (int i = 0; i < n; ++i) {
            q.offer(new int[] {i, 1 << i});
            vis[i][1 << i] = true;
        }
        for (int ans = 0;; ++ans) {
            for (int k = q.size(); k > 0; --k) {
                var p = q.poll();
                int i = p[0], st = p[1];
                if (st == (1 << n) - 1) {
                    return ans;
                }
                for (int j : graph[i]) {
                    int nst = st | 1 << j;
                    if (!vis[j][nst]) {
                        vis[j][nst] = true;
                        q.offer(new int[] {j, nst});
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
        Solution0847 _tcSol = new Solution0847();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "graph = [[1,2,3],[0],[0],[0]]");
        try {
            int[][] graph = new int[][]{new int[]{1, 2, 3}, new int[]{0}, new int[]{0}, new int[]{0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestPathLength(graph)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]");
        try {
            int[][] graph = new int[][]{new int[]{1}, new int[]{0, 2, 4}, new int[]{1, 3, 4}, new int[]{2}, new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestPathLength(graph)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}