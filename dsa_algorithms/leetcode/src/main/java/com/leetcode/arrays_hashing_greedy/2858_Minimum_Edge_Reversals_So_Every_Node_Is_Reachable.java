package com.leetcode.arrays_hashing_greedy;

class Solution2858 {
    private List<int[]>[] g;
    private int[] ans;

    public int[] minEdgeReversals(int n, int[][] edges) {
        ans = new int[n];
        g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (var e : edges) {
            int x = e[0], y = e[1];
            g[x].add(new int[] {y, 1});
            g[y].add(new int[] {x, -1});
        }
        dfs(0, -1);
        dfs2(0, -1);
        return ans;
    }

    private void dfs(int i, int fa) {
        for (var ne : g[i]) {
            int j = ne[0], k = ne[1];
            if (j != fa) {
                ans[0] += k < 0 ? 1 : 0;
                dfs(j, i);
            }
        }
    }

    private void dfs2(int i, int fa) {
        for (var ne : g[i]) {
            int j = ne[0], k = ne[1];
            if (j != fa) {
                ans[j] = ans[i] + k;
                dfs2(j, i);
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2858 _tcSol = new Solution2858();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, edges = [[2,0],[2,1],[1,3]]");
        try {
            int n = 4;
            int[][] edges = new int[][]{new int[]{2, 0}, new int[]{2, 1}, new int[]{1, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minEdgeReversals(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1,0,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, edges = [[1,2],[2,0]]");
        try {
            int n = 3;
            int[][] edges = new int[][]{new int[]{1, 2}, new int[]{2, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minEdgeReversals(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,0,1]");
        System.out.println();
    }
}
