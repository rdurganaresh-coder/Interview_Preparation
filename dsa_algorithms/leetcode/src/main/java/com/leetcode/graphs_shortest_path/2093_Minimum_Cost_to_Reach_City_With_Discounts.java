package com.leetcode.graphs_shortest_path;

class Solution2093 {
    public int minimumCost(int n, int[][] highways, int discounts) {
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; ++i) {
            g[i] = new ArrayList<>();
        }
        for (var e : highways) {
            int a = e[0], b = e[1], c = e[2];
            g[a].add(new int[] {b, c});
            g[b].add(new int[] {a, c});
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.offer(new int[] {0, 0, 0});
        int[][] dist = new int[n][discounts + 1];
        for (var e : dist) {
            Arrays.fill(e, Integer.MAX_VALUE);
        }
        while (!q.isEmpty()) {
            var p = q.poll();
            int cost = p[0], i = p[1], k = p[2];
            if (k > discounts || dist[i][k] <= cost) {
                continue;
            }
            if (i == n - 1) {
                return cost;
            }
            dist[i][k] = cost;
            for (int[] nxt : g[i]) {
                int j = nxt[0], v = nxt[1];
                q.offer(new int[] {cost + v, j, k});
                q.offer(new int[] {cost + v / 2, j, k + 1});
            }
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2093 _tcSol = new Solution2093();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, highways = [[0,1,4],[2,1,3],[1,4,11],[3,2,3],[3,4,2]], discounts = 1");
        try {
            int n = 5;
            int[][] highways = new int[][]{new int[]{0, 1, 4}, new int[]{2, 1, 3}, new int[]{1, 4, 11}, new int[]{3, 2, 3}, new int[]{3, 4, 2}};
            int discounts = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(n, highways, discounts)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, highways = [[1,3,17],[1,2,7],[3,2,5],[0,1,6],[3,0,20]], discounts = 20");
        try {
            int n = 4;
            int[][] highways = new int[][]{new int[]{1, 3, 17}, new int[]{1, 2, 7}, new int[]{3, 2, 5}, new int[]{0, 1, 6}, new int[]{3, 0, 20}};
            int discounts = 20;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(n, highways, discounts)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 4, highways = [[0,1,3],[2,3,2]], discounts = 0");
        try {
            int n = 4;
            int[][] highways = new int[][]{new int[]{0, 1, 3}, new int[]{2, 3, 2}};
            int discounts = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(n, highways, discounts)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}