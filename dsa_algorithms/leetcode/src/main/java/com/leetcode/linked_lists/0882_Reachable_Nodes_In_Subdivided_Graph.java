package com.leetcode.linked_lists;

class Solution0882 {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (var e : edges) {
            int u = e[0], v = e[1], cnt = e[2] + 1;
            g[u].add(new int[] {v, cnt});
            g[v].add(new int[] {u, cnt});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, 1 << 30);
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.offer(new int[] {0, 0});
        dist[0] = 0;
        while (!q.isEmpty()) {
            var p = q.poll();
            int d = p[0], u = p[1];
            for (var nxt : g[u]) {
                int v = nxt[0], cnt = nxt[1];
                if (d + cnt < dist[v]) {
                    dist[v] = d + cnt;
                    q.offer(new int[] {dist[v], v});
                }
            }
        }
        int ans = 0;
        for (int d : dist) {
            if (d <= maxMoves) {
                ++ans;
            }
        }
        for (var e : edges) {
            int u = e[0], v = e[1], cnt = e[2];
            int a = Math.min(cnt, Math.max(0, maxMoves - dist[u]));
            int b = Math.min(cnt, Math.max(0, maxMoves - dist[v]));
            ans += Math.min(cnt, a + b);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0882 _tcSol = new Solution0882();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges = [[0,1,10],[0,2,1],[1,2,2]], maxMoves = 6, n = 3");
        try {
            int[][] edges = new int[][]{new int[]{0, 1, 10}, new int[]{0, 2, 1}, new int[]{1, 2, 2}};
            int maxMoves = 6;
            int n = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.reachableNodes(edges, maxMoves, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges = [[0,1,4],[1,2,6],[0,2,8],[1,3,1]], maxMoves = 10, n = 4");
        try {
            int[][] edges = new int[][]{new int[]{0, 1, 4}, new int[]{1, 2, 6}, new int[]{0, 2, 8}, new int[]{1, 3, 1}};
            int maxMoves = 10;
            int n = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.reachableNodes(edges, maxMoves, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "23");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "edges = [[1,2,4],[1,4,5],[1,3,1],[2,3,4],[3,4,5]], maxMoves = 17, n = 5");
        try {
            int[][] edges = new int[][]{new int[]{1, 2, 4}, new int[]{1, 4, 5}, new int[]{1, 3, 1}, new int[]{2, 3, 4}, new int[]{3, 4, 5}};
            int maxMoves = 17;
            int n = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.reachableNodes(edges, maxMoves, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}