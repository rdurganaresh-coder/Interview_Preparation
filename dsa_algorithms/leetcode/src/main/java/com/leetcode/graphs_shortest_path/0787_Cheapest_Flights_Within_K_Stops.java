package com.leetcode.graphs_shortest_path;

class Solution0787 {
    private static final int INF = 0x3f3f3f3f;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        int[] backup = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;
        for (int i = 0; i < k + 1; ++i) {
            System.arraycopy(dist, 0, backup, 0, n);
            for (int[] e : flights) {
                int f = e[0], t = e[1], p = e[2];
                dist[t] = Math.min(dist[t], backup[f] + p);
            }
        }
        return dist[dst] == INF ? -1 : dist[dst];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0787 _tcSol = new Solution0787();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1");
        try {
            int n = 4;
            int[][] flights = new int[][]{new int[]{0, 1, 100}, new int[]{1, 2, 100}, new int[]{2, 0, 100}, new int[]{1, 3, 600}, new int[]{2, 3, 200}};
            int src = 0;
            int dst = 3;
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findCheapestPrice(n, flights, src, dst, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "700");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1");
        try {
            int n = 3;
            int[][] flights = new int[][]{new int[]{0, 1, 100}, new int[]{1, 2, 100}, new int[]{0, 2, 500}};
            int src = 0;
            int dst = 2;
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findCheapestPrice(n, flights, src, dst, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "200");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0");
        try {
            int n = 3;
            int[][] flights = new int[][]{new int[]{0, 1, 100}, new int[]{1, 2, 100}, new int[]{0, 2, 500}};
            int src = 0;
            int dst = 2;
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.findCheapestPrice(n, flights, src, dst, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "500");
        System.out.println();
    }
}