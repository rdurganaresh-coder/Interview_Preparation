package com.leetcode.trees_tries;

class Solution1245 {
    private List<Integer>[] g;
    private int ans;
    private int a;

    public int treeDiameter(int[][] edges) {
        int n = edges.length + 1;
        g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        dfs(0, -1, 0);
        dfs(a, -1, 0);
        return ans;
    }

    private void dfs(int i, int fa, int t) {
        for (int j : g[i]) {
            if (j != fa) {
                dfs(j, i, t + 1);
            }
        }
        if (ans < t) {
            ans = t;
            a = i;
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1245 _tcSol = new Solution1245();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges = [[0,1],[0,2]]");
        try {
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.treeDiameter(edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges = [[0,1],[1,2],[2,3],[1,4],[4,5]]");
        try {
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{1, 4}, new int[]{4, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.treeDiameter(edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}
