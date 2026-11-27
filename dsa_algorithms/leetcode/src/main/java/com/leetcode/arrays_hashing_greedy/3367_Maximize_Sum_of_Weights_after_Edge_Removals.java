package com.leetcode.arrays_hashing_greedy;

class Solution3367 {
    private List<int[]>[] g;
    private int k;

    public long maximizeSumOfWeights(int[][] edges, int k) {
        this.k = k;
        int n = edges.length + 1;
        g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (var e : edges) {
            int u = e[0], v = e[1], w = e[2];
            g[u].add(new int[] {v, w});
            g[v].add(new int[] {u, w});
        }
        var ans = dfs(0, -1);
        return Math.max(ans[0], ans[1]);
    }

    private long[] dfs(int u, int fa) {
        long s = 0;
        List<Long> t = new ArrayList<>();
        for (var e : g[u]) {
            int v = e[0], w = e[1];
            if (v == fa) {
                continue;
            }
            var res = dfs(v, u);
            s += res[0];
            long d = w + res[1] - res[0];
            if (d > 0) {
                t.add(d);
            }
        }
        t.sort(Comparator.reverseOrder());
        for (int i = 0; i < Math.min(t.size(), k - 1); ++i) {
            s += t.get(i);
        }
        return new long[] {s + (t.size() >= k ? t.get(k - 1) : 0), s};
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3367 _tcSol = new Solution3367();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges = [[0,1,4],[0,2,2],[2,3,12],[2,4,6]], k = 2");
        try {
            int[][] edges = new int[][]{new int[]{0, 1, 4}, new int[]{0, 2, 2}, new int[]{2, 3, 12}, new int[]{2, 4, 6}};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximizeSumOfWeights(edges, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "22");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges = [[0,1,5],[1,2,10],[0,3,15],[3,4,20],[3,5,5],[0,6,10]], k = 3");
        try {
            int[][] edges = new int[][]{new int[]{0, 1, 5}, new int[]{1, 2, 10}, new int[]{0, 3, 15}, new int[]{3, 4, 20}, new int[]{3, 5, 5}, new int[]{0, 6, 10}};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximizeSumOfWeights(edges, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "65");
        System.out.println();
    }
}
