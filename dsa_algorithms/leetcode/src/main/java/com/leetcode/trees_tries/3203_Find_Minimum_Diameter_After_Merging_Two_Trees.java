package com.leetcode.trees_tries;

class Solution3203 {
    private List<Integer>[] g;
    private int ans;
    private int a;

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int d1 = treeDiameter(edges1);
        int d2 = treeDiameter(edges2);
        return Math.max(Math.max(d1, d2), (d1 + 1) / 2 + (d2 + 1) / 2 + 1);
    }

    public int treeDiameter(int[][] edges) {
        int n = edges.length + 1;
        g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        ans = 0;
        a = 0;
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
        Solution3203 _tcSol = new Solution3203();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges1 = [[0,1],[0,2],[0,3]], edges2 = [[0,1]]");
        try {
            int[][] edges1 = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}};
            int[][] edges2 = new int[][]{new int[]{0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumDiameterAfterMerge(edges1, edges2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges1 = [[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]], edges2 = [[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]]");
        try {
            int[][] edges1 = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{2, 4}, new int[]{2, 5}, new int[]{3, 6}, new int[]{2, 7}};
            int[][] edges2 = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{2, 4}, new int[]{2, 5}, new int[]{3, 6}, new int[]{2, 7}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumDiameterAfterMerge(edges1, edges2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}
