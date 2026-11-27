package com.leetcode.trees_tries;

class Solution2467 {
    private List<Integer>[] g;
    private int[] amount;
    private int[] ts;
    private int ans = Integer.MIN_VALUE;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = edges.length + 1;
        g = new List[n];
        ts = new int[n];
        this.amount = amount;
        Arrays.setAll(g, k -> new ArrayList<>());
        Arrays.fill(ts, n);
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        dfs1(bob, -1, 0);
        ts[bob] = 0;
        dfs2(0, -1, 0, 0);
        return ans;
    }

    private boolean dfs1(int i, int fa, int t) {
        if (i == 0) {
            ts[i] = Math.min(ts[i], t);
            return true;
        }
        for (int j : g[i]) {
            if (j != fa && dfs1(j, i, t + 1)) {
                ts[j] = Math.min(ts[j], t + 1);
                return true;
            }
        }
        return false;
    }

    private void dfs2(int i, int fa, int t, int v) {
        if (t == ts[i]) {
            v += amount[i] >> 1;
        } else if (t < ts[i]) {
            v += amount[i];
        }
        if (g[i].size() == 1 && g[i].get(0) == fa) {
            ans = Math.max(ans, v);
            return;
        }
        for (int j : g[i]) {
            if (j != fa) {
                dfs2(j, i, t + 1, v);
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2467 _tcSol = new Solution2467();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges = [[0,1],[1,2],[1,3],[3,4]], bob = 3, amount = [-2,4,2,-4,6]");
        try {
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{1, 3}, new int[]{3, 4}};
            int bob = 3;
            int[] amount = new int[]{-2, 4, 2, -4, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.mostProfitablePath(edges, bob, amount)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges = [[0,1]], bob = 1, amount = [-7280,2350]");
        try {
            int[][] edges = new int[][]{new int[]{0, 1}};
            int bob = 1;
            int[] amount = new int[]{-7280, 2350};
            System.out.println("  Output  : " + _tcShow(_tcSol.mostProfitablePath(edges, bob, amount)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-7280");
        System.out.println();
    }
}
