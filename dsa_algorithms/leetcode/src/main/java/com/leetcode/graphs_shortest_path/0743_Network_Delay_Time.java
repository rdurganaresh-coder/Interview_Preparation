package com.leetcode.graphs_shortest_path;

class Solution0743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] g = new int[n][n];
        int[] dist = new int[n];
        final int inf = 1 << 29;
        Arrays.fill(dist, inf);
        for (var e : g) {
            Arrays.fill(e, inf);
        }
        for (var e : times) {
            g[e[0] - 1][e[1] - 1] = e[2];
        }
        dist[k - 1] = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int t = -1;
            for (int j = 0; j < n; ++j) {
                if (!vis[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }
            vis[t] = true;
            for (int j = 0; j < n; ++j) {
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
            }
        }
        int ans = 0;
        for (int x : dist) {
            ans = Math.max(ans, x);
        }
        return ans == inf ? -1 : ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0743 _tcSol = new Solution0743();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2");
        try {
            int[][] times = new int[][]{new int[]{2, 1, 1}, new int[]{2, 3, 1}, new int[]{3, 4, 1}};
            int n = 4;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.networkDelayTime(times, n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "times = [[1,2,1]], n = 2, k = 1");
        try {
            int[][] times = new int[][]{new int[]{1, 2, 1}};
            int n = 2;
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.networkDelayTime(times, n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "times = [[1,2,1]], n = 2, k = 2");
        try {
            int[][] times = new int[][]{new int[]{1, 2, 1}};
            int n = 2;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.networkDelayTime(times, n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
