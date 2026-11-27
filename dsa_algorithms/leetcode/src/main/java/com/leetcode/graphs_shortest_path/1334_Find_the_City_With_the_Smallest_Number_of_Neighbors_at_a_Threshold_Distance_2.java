package com.leetcode.graphs_shortest_path;

class Solution1334_2 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        final int inf = 1 << 29;
        int[][] g = new int[n][n];
        for (var e : g) {
            Arrays.fill(e, inf);
        }
        for (var e : edges) {
            int f = e[0], t = e[1], w = e[2];
            g[f][t] = w;
            g[t][f] = w;
        }
        for (int k = 0; k < n; ++k) {
            g[k][k] = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
        int ans = n, cnt = inf;
        for (int i = n - 1; i >= 0; --i) {
            int t = 0;
            for (int d : g[i]) {
                if (d <= distanceThreshold) {
                    ++t;
                }
            }
            if (t < cnt) {
                cnt = t;
                ans = i;
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
        Solution1334_2 _tcSol = new Solution1334_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4");
        try {
            int n = 4;
            int[][] edges = new int[][]{new int[]{0, 1, 3}, new int[]{1, 2, 1}, new int[]{1, 3, 4}, new int[]{2, 3, 1}};
            int distanceThreshold = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.findTheCity(n, edges, distanceThreshold)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]], distanceThreshold = 2");
        try {
            int n = 5;
            int[][] edges = new int[][]{new int[]{0, 1, 2}, new int[]{0, 4, 8}, new int[]{1, 2, 3}, new int[]{1, 4, 2}, new int[]{2, 3, 1}, new int[]{3, 4, 1}};
            int distanceThreshold = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.findTheCity(n, edges, distanceThreshold)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}