package com.leetcode.trees_tries;

class Solution2925 {
    private List<Integer>[] g;
    private int[] values;

    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n = values.length;
        g = new List[n];
        this.values = values;
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        return dfs(0, -1)[1];
    }

    private long[] dfs(int i, int fa) {
        long a = 0, b = 0;
        boolean leaf = true;
        for (int j : g[i]) {
            if (j != fa) {
                leaf = false;
                var t = dfs(j, i);
                a += t[0];
                b += t[1];
            }
        }
        if (leaf) {
            return new long[] {values[i], 0};
        }
        return new long[] {values[i] + a, Math.max(values[i] + b, a)};
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2925 _tcSol = new Solution2925();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges = [[0,1],[0,2],[0,3],[2,4],[4,5]], values = [5,2,5,2,1,1]");
        try {
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{2, 4}, new int[]{4, 5}};
            int[] values = new int[]{5, 2, 5, 2, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumScoreAfterOperations(edges, values)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]], values = [20,10,9,7,4,3,5]");
        try {
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 3}, new int[]{1, 4}, new int[]{2, 5}, new int[]{2, 6}};
            int[] values = new int[]{20, 10, 9, 7, 4, 3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumScoreAfterOperations(edges, values)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "40");
        System.out.println();
    }
}
