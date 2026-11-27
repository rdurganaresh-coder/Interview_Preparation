package com.leetcode.trees_tries;

class Solution3585 {
    public int[] findMedian(int n, int[][] edges, int[][] queries) {
        int m = 32 - Integer.numberOfLeadingZeros(n);
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (var e : edges) {
            int u = e[0], v = e[1], w = e[2];
            g[u].add(new int[] {v, w});
            g[v].add(new int[] {u, w});
        }
        int[][] f = new int[n][m];
        int[] p = new int[n];
        int[] depth = new int[n];
        long[] dist = new long[n];
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int i = q.poll();
            f[i][0] = p[i];
            for (int j = 1; j < m; ++j) {
                f[i][j] = f[f[i][j - 1]][j - 1];
            }
            for (var nxt : g[i]) {
                int j = nxt[0], w = nxt[1];
                if (j != p[i]) {
                    p[j] = i;
                    depth[j] = depth[i] + 1;
                    dist[j] = dist[i] + w;
                    q.offer(j);
                }
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            int u = queries[i][0], v = queries[i][1];
            if (u == v) {
                ans[i] = u;
                continue;
            }
            int x = u, y = v;
            if (depth[x] < depth[y]) {
                int t = x;
                x = y;
                y = t;
            }
            for (int j = m - 1; j >= 0; --j) {
                if (depth[x] - depth[y] >= (1 << j)) {
                    x = f[x][j];
                }
            }
            for (int j = m - 1; j >= 0; --j) {
                if (f[x][j] != f[y][j]) {
                    x = f[x][j];
                    y = f[y][j];
                }
            }
            if (x != y) {
                x = p[x];
            }
            long w = dist[u] + dist[v] - 2 * dist[x];
            if (2 * (dist[u] - dist[x]) >= w) {
                int cur = u;
                for (int j = m - 1; j >= 0; --j) {
                    int k = f[cur][j];
                    if (depth[k] >= depth[x] && 2 * (dist[u] - dist[k]) < w) {
                        cur = k;
                    }
                }
                ans[i] = p[cur];
            } else {
                int cur = v;
                for (int j = m - 1; j >= 0; --j) {
                    int k = f[cur][j];
                    if (depth[k] > depth[x] && 2 * (dist[u] + dist[k] - 2 * dist[x]) >= w) {
                        cur = k;
                    }
                }
                ans[i] = cur;
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
        Solution3585 _tcSol = new Solution3585();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 2, edges = [[0,1,7]], queries = [[1,0],[0,1]]");
        try {
            int n = 2;
            int[][] edges = new int[][]{new int[]{0, 1, 7}};
            int[][] queries = new int[][]{new int[]{1, 0}, new int[]{0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMedian(n, edges, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, edges = [[0,1,2],[2,0,4]], queries = [[0,1],[2,0],[1,2]]");
        try {
            int n = 3;
            int[][] edges = new int[][]{new int[]{0, 1, 2}, new int[]{2, 0, 4}};
            int[][] queries = new int[][]{new int[]{0, 1}, new int[]{2, 0}, new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMedian(n, edges, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,0,2]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 5, edges = [[0,1,2],[0,2,5],[1,3,1],[2,4,3]], queries = [[3,4],[1,2]]");
        try {
            int n = 5;
            int[][] edges = new int[][]{new int[]{0, 1, 2}, new int[]{0, 2, 5}, new int[]{1, 3, 1}, new int[]{2, 4, 3}};
            int[][] queries = new int[][]{new int[]{3, 4}, new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMedian(n, edges, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,2]");
        System.out.println();
    }
}
