package com.leetcode.linked_lists;

class Solution2316_2 {
    public long countPairs(int n, int[][] edges) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        boolean[] vis = new boolean[n];
        long ans = 0, s = 0;
        for (int i = 0; i < n; ++i) {
            int t = dfs(g, vis, i);
            ans += s * t;
            s += t;
        }
        return ans;
    }

    private int dfs(List<Integer>[] g, boolean[] vis, int i) {
        if (vis[i]) {
            return 0;
        }
        vis[i] = true;
        int cnt = 0;
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(i);
        while (!stk.isEmpty()) {
            int u = stk.pop();
            ++cnt;
            for (int j : g[u]) {
                if (!vis[j]) {
                    vis[j] = true;
                    stk.push(j);
                }
            }
        }
        return cnt;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2316_2 _tcSol = new Solution2316_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, edges = [[0,1],[0,2],[1,2]]");
        try {
            int n = 3;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPairs(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 7, edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]");
        try {
            int n = 7;
            int[][] edges = new int[][]{new int[]{0, 2}, new int[]{0, 5}, new int[]{2, 4}, new int[]{1, 6}, new int[]{5, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPairs(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "14");
        System.out.println();
    }
}
