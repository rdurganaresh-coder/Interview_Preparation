package com.leetcode.graphs_shortest_path;

class Solution1761 {
    public int minTrioDegree(int n, int[][] edges) {
        boolean[][] g = new boolean[n][n];
        int[] deg = new int[n];
        for (var e : edges) {
            int u = e[0] - 1, v = e[1] - 1;
            g[u][v] = true;
            g[v][u] = true;
            ++deg[u];
            ++deg[v];
        }
        int ans = 1 << 30;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (g[i][j]) {
                    for (int k = j + 1; k < n; ++k) {
                        if (g[i][k] && g[j][k]) {
                            ans = Math.min(ans, deg[i] + deg[j] + deg[k] - 6);
                        }
                    }
                }
            }
        }
        return ans == 1 << 30 ? -1 : ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1761 _tcSol = new Solution1761();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 6, edges = [[1,2],[1,3],[3,2],[4,1],[5,2],[3,6]]");
        try {
            int n = 6;
            int[][] edges = new int[][]{new int[]{1, 2}, new int[]{1, 3}, new int[]{3, 2}, new int[]{4, 1}, new int[]{5, 2}, new int[]{3, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minTrioDegree(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 7, edges = [[1,3],[4,1],[4,3],[2,5],[5,6],[6,7],[7,5],[2,6]]");
        try {
            int n = 7;
            int[][] edges = new int[][]{new int[]{1, 3}, new int[]{4, 1}, new int[]{4, 3}, new int[]{2, 5}, new int[]{5, 6}, new int[]{6, 7}, new int[]{7, 5}, new int[]{2, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minTrioDegree(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}