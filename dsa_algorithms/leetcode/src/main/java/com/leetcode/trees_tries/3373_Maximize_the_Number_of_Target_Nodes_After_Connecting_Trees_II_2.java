package com.leetcode.trees_tries;

class Solution3373_2 {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        var g1 = build(edges1);
        var g2 = build(edges2);
        int n = g1.length, m = g2.length;
        int[] c1 = new int[n];
        int[] c2 = new int[m];
        int[] cnt1 = new int[2];
        int[] cnt2 = new int[2];
        dfs(g2, c2, cnt2);
        dfs(g1, c1, cnt1);
        int t = Math.max(cnt2[0], cnt2[1]);
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = t + cnt1[c1[i]];
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

    private void dfs(List<Integer>[] g, int[] c, int[] cnt) {
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {0, -1, 0});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int a = cur[0], fa = cur[1], d = cur[2];
            c[a] = d;
            cnt[d]++;
            for (int b : g[a]) {
                if (b != fa) {
                    stk.push(new int[] {b, a, d ^ 1});
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
        Solution3373_2 _tcSol = new Solution3373_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges1 = [[0,1],[0,2],[2,3],[2,4]], edges2 = [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]]");
        try {
            int[][] edges1 = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{2, 3}, new int[]{2, 4}};
            int[][] edges2 = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{2, 7}, new int[]{1, 4}, new int[]{4, 5}, new int[]{4, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxTargetNodes(edges1, edges2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[8,7,7,8,8]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges1 = [[0,1],[0,2],[0,3],[0,4]], edges2 = [[0,1],[1,2],[2,3]]");
        try {
            int[][] edges1 = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{0, 4}};
            int[][] edges2 = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxTargetNodes(edges1, edges2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,6,6,6,6]");
        System.out.println();
    }
}
