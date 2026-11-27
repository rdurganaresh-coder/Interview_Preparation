package com.leetcode.graphs_shortest_path;

class Solution2204 {
    public int[] distanceToCycle(int n, int[][] edges) {
        Set<Integer>[] g = new Set[n];
        Arrays.setAll(g, k -> new HashSet<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (g[i].size() == 1) {
                q.offer(i);
            }
        }
        int[] f = new int[n];
        Deque<Integer> seq = new ArrayDeque<>();
        while (!q.isEmpty()) {
            int i = q.poll();
            seq.push(i);
            for (int j : g[i]) {
                g[j].remove(i);
                f[i] = j;
                if (g[j].size() == 1) {
                    q.offer(j);
                }
            }
        }
        int[] ans = new int[n];
        while (!seq.isEmpty()) {
            int i = seq.pop();
            ans[i] = ans[f[i]] + 1;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2204 _tcSol = new Solution2204();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 7, edges = [[1,2],[2,4],[4,3],[3,1],[0,1],[5,2],[6,5]]");
        try {
            int n = 7;
            int[][] edges = new int[][]{new int[]{1, 2}, new int[]{2, 4}, new int[]{4, 3}, new int[]{3, 1}, new int[]{0, 1}, new int[]{5, 2}, new int[]{6, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.distanceToCycle(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,0,0,0,0,1,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 9, edges = [[0,1],[1,2],[0,2],[2,6],[6,7],[6,8],[0,3],[3,4],[3,5]]");
        try {
            int n = 9;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{0, 2}, new int[]{2, 6}, new int[]{6, 7}, new int[]{6, 8}, new int[]{0, 3}, new int[]{3, 4}, new int[]{3, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.distanceToCycle(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,0,0,1,2,2,1,2,2]");
        System.out.println();
    }
}