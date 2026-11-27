package com.leetcode.graphs_shortest_path;

class Solution0743_2 {
    public int networkDelayTime(int[][] times, int n, int k) {
        final int inf = 1 << 29;
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (var e : times) {
            g[e[0] - 1].add(new int[] {e[1] - 1, e[2]});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, inf);
        dist[k - 1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] {0, k - 1});
        while (!pq.isEmpty()) {
            var p = pq.poll();
            int d = p[0], u = p[1];
            if (d > dist[u]) {
                continue;
            }
            for (var e : g[u]) {
                int v = e[0], w = e[1];
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[] {dist[v], v});
                }
            }
        }
        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == inf ? -1 : ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0743_2 _tcSol = new Solution0743_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2");
        try {
            int[][] times = new int[][]{new int[]{2, 1, 1}, new int[]{2, 3, 1}, new int[]{3, 4, 1}};
            int n = 4;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.networkDelayTime(times, n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "times = [[1,2,1]], n = 2, k = 1");
        try {
            int[][] times = new int[][]{new int[]{1, 2, 1}};
            int n = 2;
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.networkDelayTime(times, n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "times = [[1,2,1]], n = 2, k = 2");
        try {
            int[][] times = new int[][]{new int[]{1, 2, 1}};
            int n = 2;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.networkDelayTime(times, n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
