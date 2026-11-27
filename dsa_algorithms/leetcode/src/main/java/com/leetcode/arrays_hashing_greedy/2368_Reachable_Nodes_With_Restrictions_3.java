package com.leetcode.arrays_hashing_greedy;

class Solution2368_3 {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        boolean[] vis = new boolean[n];
        for (int i : restricted) {
            vis[i] = true;
        }
        int ans = 0;
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(0);
        while (!stk.isEmpty()) {
            int i = stk.pop();
            if (vis[i]) {
                continue;
            }
            vis[i] = true;
            ++ans;
            for (int j : g[i]) {
                if (!vis[j]) {
                    stk.push(j);
                }
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2368_3 _tcSol = new Solution2368_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 7, edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], restricted = [4,5]");
        try {
            int n = 7;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{3, 1}, new int[]{4, 0}, new int[]{0, 5}, new int[]{5, 6}};
            int[] restricted = new int[]{4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.reachableNodes(n, edges, restricted)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 7, edges = [[0,1],[0,2],[0,5],[0,4],[3,2],[6,5]], restricted = [4,2,1]");
        try {
            int n = 7;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 5}, new int[]{0, 4}, new int[]{3, 2}, new int[]{6, 5}};
            int[] restricted = new int[]{4, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.reachableNodes(n, edges, restricted)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
