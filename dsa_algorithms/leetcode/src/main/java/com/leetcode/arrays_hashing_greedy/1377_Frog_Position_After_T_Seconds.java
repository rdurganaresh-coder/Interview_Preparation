package com.leetcode.arrays_hashing_greedy;

class Solution1377 {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<Integer>[] g = new List[n + 1];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
        }
        Deque<Pair<Integer, Double>> q = new ArrayDeque<>();
        q.offer(new Pair<>(1, 1.0));
        boolean[] vis = new boolean[n + 1];
        vis[1] = true;
        for (; !q.isEmpty() && t >= 0; --t) {
            for (int k = q.size(); k > 0; --k) {
                var x = q.poll();
                int u = x.getKey();
                double p = x.getValue();
                int cnt = g[u].size() - (u == 1 ? 0 : 1);
                if (u == target) {
                    return cnt * t == 0 ? p : 0;
                }
                for (int v : g[u]) {
                    if (!vis[v]) {
                        vis[v] = true;
                        q.offer(new Pair<>(v, p / cnt));
                    }
                }
            }
        }
        return 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1377 _tcSol = new Solution1377();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 2, target = 4");
        try {
            int n = 7;
            int[][] edges = new int[][]{new int[]{1, 2}, new int[]{1, 3}, new int[]{1, 7}, new int[]{2, 4}, new int[]{2, 6}, new int[]{3, 5}};
            int t = 2;
            int target = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.frogPosition(n, edges, t, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0.16666666666666666");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 1, target = 7");
        try {
            int n = 7;
            int[][] edges = new int[][]{new int[]{1, 2}, new int[]{1, 3}, new int[]{1, 7}, new int[]{2, 4}, new int[]{2, 6}, new int[]{3, 5}};
            int t = 1;
            int target = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.frogPosition(n, edges, t, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0.3333333333333333");
        System.out.println();
    }
}