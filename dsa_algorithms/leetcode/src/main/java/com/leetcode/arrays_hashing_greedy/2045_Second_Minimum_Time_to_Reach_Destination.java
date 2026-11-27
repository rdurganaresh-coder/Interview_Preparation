package com.leetcode.arrays_hashing_greedy;

class Solution2045 {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<Integer>[] g = new List[n + 1];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
        }
        Deque<int[]> q = new LinkedList<>();
        q.offerLast(new int[] {1, 0});
        int[][] dist = new int[n + 1][2];
        for (int i = 0; i < n + 1; ++i) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[1][1] = 0;
        while (!q.isEmpty()) {
            int[] e = q.pollFirst();
            int u = e[0], d = e[1];
            for (int v : g[u]) {
                if (d + 1 < dist[v][0]) {
                    dist[v][0] = d + 1;
                    q.offerLast(new int[] {v, d + 1});
                } else if (dist[v][0] < d + 1 && d + 1 < dist[v][1]) {
                    dist[v][1] = d + 1;
                    if (v == n) {
                        break;
                    }
                    q.offerLast(new int[] {v, d + 1});
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < dist[n][1]; ++i) {
            ans += time;
            if (i < dist[n][1] - 1 && (ans / change) % 2 == 1) {
                ans = (ans + change) / change * change;
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
        Solution2045 _tcSol = new Solution2045();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, edges = [[1,2],[1,3],[1,4],[3,4],[4,5]], time = 3, change = 5");
        try {
            int n = 5;
            int[][] edges = new int[][]{new int[]{1, 2}, new int[]{1, 3}, new int[]{1, 4}, new int[]{3, 4}, new int[]{4, 5}};
            int time = 3;
            int change = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.secondMinimum(n, edges, time, change)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2, edges = [[1,2]], time = 3, change = 2");
        try {
            int n = 2;
            int[][] edges = new int[][]{new int[]{1, 2}};
            int time = 3;
            int change = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.secondMinimum(n, edges, time, change)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();
    }
}