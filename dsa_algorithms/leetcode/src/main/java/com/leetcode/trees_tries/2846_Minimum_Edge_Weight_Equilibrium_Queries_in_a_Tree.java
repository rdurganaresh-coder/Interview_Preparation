package com.leetcode.trees_tries;

class Solution2846 {
    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        int m = 32 - Integer.numberOfLeadingZeros(n);
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        int[][] f = new int[n][m];
        int[] p = new int[n];
        int[][] cnt = new int[n][0];
        int[] depth = new int[n];
        for (var e : edges) {
            int u = e[0], v = e[1], w = e[2] - 1;
            g[u].add(new int[] {v, w});
            g[v].add(new int[] {u, w});
        }
        cnt[0] = new int[26];
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
                    cnt[j] = cnt[i].clone();
                    cnt[j][w]++;
                    depth[j] = depth[i] + 1;
                    q.offer(j);
                }
            }
        }
        int k = queries.length;
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
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
            int mx = 0;
            for (int j = 0; j < 26; ++j) {
                mx = Math.max(mx, cnt[u][j] + cnt[v][j] - 2 * cnt[x][j]);
            }
            ans[i] = depth[u] + depth[v] - 2 * depth[x] - mx;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2846 _tcSol = new Solution2846();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 7, edges = [[0,1,1],[1,2,1],[2,3,1],[3,4,2],[4,5,2],[5,6,2]], queries = [[0,3],[3,6],[2,6],[0,6]]");
        try {
            int n = 7;
            int[][] edges = new int[][]{new int[]{0, 1, 1}, new int[]{1, 2, 1}, new int[]{2, 3, 1}, new int[]{3, 4, 2}, new int[]{4, 5, 2}, new int[]{5, 6, 2}};
            int[][] queries = new int[][]{new int[]{0, 3}, new int[]{3, 6}, new int[]{2, 6}, new int[]{0, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperationsQueries(n, edges, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,0,1,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 8, edges = [[1,2,6],[1,3,4],[2,4,6],[2,5,3],[3,6,6],[3,0,8],[7,0,2]], queries = [[4,6],[0,4],[6,5],[7,4]]");
        try {
            int n = 8;
            int[][] edges = new int[][]{new int[]{1, 2, 6}, new int[]{1, 3, 4}, new int[]{2, 4, 6}, new int[]{2, 5, 3}, new int[]{3, 6, 6}, new int[]{3, 0, 8}, new int[]{7, 0, 2}};
            int[][] queries = new int[][]{new int[]{4, 6}, new int[]{0, 4}, new int[]{6, 5}, new int[]{7, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperationsQueries(n, edges, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,2,3]");
        System.out.println();
    }
}