package com.leetcode.graphs_shortest_path;

class Solution2497 {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, key -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            if (vals[b] > 0) {
                g[a].add(vals[b]);
            }
            if (vals[a] > 0) {
                g[b].add(vals[a]);
            }
        }
        for (var e : g) {
            Collections.sort(e, (a, b) -> b - a);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            int v = vals[i];
            for (int j = 0; j < Math.min(g[i].size(), k); ++j) {
                v += g[i].get(j);
            }
            ans = Math.max(ans, v);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2497 _tcSol = new Solution2497();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "vals = [1,2,3,4,10,-10,-20], edges = [[0,1],[1,2],[1,3],[3,4],[3,5],[3,6]], k = 2");
        try {
            int[] vals = new int[]{1, 2, 3, 4, 10, -10, -20};
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{1, 3}, new int[]{3, 4}, new int[]{3, 5}, new int[]{3, 6}};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxStarSum(vals, edges, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "vals = [-5], edges = [], k = 0");
        try {
            int[] vals = new int[]{-5};
            int[][] edges = new int[][]{};
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxStarSum(vals, edges, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-5");
        System.out.println();
    }
}