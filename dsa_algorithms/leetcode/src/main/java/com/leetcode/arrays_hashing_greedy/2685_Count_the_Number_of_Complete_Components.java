package com.leetcode.arrays_hashing_greedy;

class Solution2685 {
    private List<Integer>[] g;
    private boolean[] vis;

    public int countCompleteComponents(int n, int[][] edges) {
        g = new List[n];
        vis = new boolean[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (!vis[i]) {
                int[] t = dfs(i);
                if (t[0] * (t[0] - 1) == t[1]) {
                    ++ans;
                }
            }
        }
        return ans;
    }

    private int[] dfs(int i) {
        vis[i] = true;
        int x = 1, y = g[i].size();
        for (int j : g[i]) {
            if (!vis[j]) {
                int[] t = dfs(j);
                x += t[0];
                y += t[1];
            }
        }
        return new int[] {x, y};
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2685 _tcSol = new Solution2685();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]");
        try {
            int n = 6;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 2}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countCompleteComponents(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 6, edges = [[0,1],[0,2],[1,2],[3,4],[3,5]]");
        try {
            int n = 6;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 2}, new int[]{3, 4}, new int[]{3, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countCompleteComponents(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}