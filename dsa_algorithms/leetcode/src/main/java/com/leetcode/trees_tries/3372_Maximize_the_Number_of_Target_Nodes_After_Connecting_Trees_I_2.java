package com.leetcode.trees_tries;

class Solution3372_2 {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        var g2 = build(edges2);
        int m = edges2.length + 1;
        int t = 0;
        for (int i = 0; i < m; ++i) {
            t = Math.max(t, dfs(g2, i, -1, k - 1));
        }
        var g1 = build(edges1);
        int n = edges1.length + 1;
        int[] ans = new int[n];
        Arrays.fill(ans, t);
        for (int i = 0; i < n; ++i) {
            ans[i] += dfs(g1, i, -1, k);
        }
        return ans;
    }

    private List<Integer>[] build(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        return g;
    }

    private int dfs(List<Integer>[] g, int a, int fa, int d) {
        if (d < 0) {
            return 0;
        }
        int cnt = 0;
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {a, fa, d});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int u = cur[0], p = cur[1], rem = cur[2];
            ++cnt;
            if (rem == 0) {
                continue;
            }
            for (int b : g[u]) {
                if (b != p) {
                    stk.push(new int[] {b, u, rem - 1});
                }
            }
        }
        return cnt;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3372_2 _tcSol = new Solution3372_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges1 = [[0,1],[0,2],[2,3],[2,4]], edges2 = [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]], k = 2");
        try {
            int[][] edges1 = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{2, 3}, new int[]{2, 4}};
            int[][] edges2 = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{2, 7}, new int[]{1, 4}, new int[]{4, 5}, new int[]{4, 6}};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxTargetNodes(edges1, edges2, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[9,7,9,8,8]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges1 = [[0,1],[0,2],[0,3],[0,4]], edges2 = [[0,1],[1,2],[2,3]], k = 1");
        try {
            int[][] edges1 = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{0, 4}};
            int[][] edges2 = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxTargetNodes(edges1, edges2, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[6,3,3,3,3]");
        System.out.println();
    }
}
