package com.leetcode.dynamic_programming;

class Solution3558 {
    private List<Integer>[] g;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        g = new List[n + 1];
        Arrays.setAll(g, k -> new ArrayList<>());

        for (var e : edges) {
            int u = e[0];
            int v = e[1];
            g[u].add(v);
            g[v].add(u);
        }

        return (int) pow(2, dfs(1, 0) - 1, 1_000_000_007);
    }

    private int dfs(int i, int fa) {
        int res = 0;
        for (int j : g[i]) {
            if (j != fa) {
                res = Math.max(res, dfs(j, i) + 1);
            }
        }
        return res;
    }

    private long pow(long a, int n, int mod) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                res = res * a % mod;
            }
            a = a * a % mod;
            n >>= 1;
        }
        return res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3558 _tcSol = new Solution3558();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges = [[1,2]]");
        try {
            int[][] edges = new int[][]{new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.assignEdgeWeights(edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges = [[1,2],[1,3],[3,4],[3,5]]");
        try {
            int[][] edges = new int[][]{new int[]{1, 2}, new int[]{1, 3}, new int[]{3, 4}, new int[]{3, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.assignEdgeWeights(edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
