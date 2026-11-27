package com.leetcode.dynamic_programming;

class Solution3559 {
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        int m = 32 - Integer.numberOfLeadingZeros(n);
        List<Integer>[] g = new List[n + 1];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (var e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
        }
        int[][] f = new int[n + 1][m];
        int[] p = new int[n + 1];
        int[] depth = new int[n + 1];
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        while (!q.isEmpty()) {
            int i = q.poll();
            f[i][0] = p[i];
            for (int j = 1; j < m; ++j) {
                f[i][j] = f[f[i][j - 1]][j - 1];
            }
            for (int j : g[i]) {
                if (j != p[i]) {
                    p[j] = i;
                    depth[j] = depth[i] + 1;
                    q.offer(j);
                }
            }
        }
        final int mod = (int) 1e9 + 7;
        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 1; i < n; ++i) {
            pow2[i] = (int) (pow2[i - 1] * 2L % mod);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            int u = queries[i][0], v = queries[i][1];
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
            int d = depth[u] + depth[v] - 2 * depth[x];
            ans[i] = d == 0 ? 0 : pow2[d - 1];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3559 _tcSol = new Solution3559();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges = [[1,2]], queries = [[1,1],[1,2]]");
        try {
            int[][] edges = new int[][]{new int[]{1, 2}};
            int[][] queries = new int[][]{new int[]{1, 1}, new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.assignEdgeWeights(edges, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges = [[1,2],[1,3],[3,4],[3,5]], queries = [[1,4],[3,4],[2,5]]");
        try {
            int[][] edges = new int[][]{new int[]{1, 2}, new int[]{1, 3}, new int[]{3, 4}, new int[]{3, 5}};
            int[][] queries = new int[][]{new int[]{1, 4}, new int[]{3, 4}, new int[]{2, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.assignEdgeWeights(edges, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,1,4]");
        System.out.println();
    }
}
