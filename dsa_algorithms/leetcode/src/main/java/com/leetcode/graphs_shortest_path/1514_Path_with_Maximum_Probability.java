package com.leetcode.graphs_shortest_path;

class Solution1514 {
    public double maxProbability(
        int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<Pair<Integer, Double>>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 0; i < edges.length; ++i) {
            var e = edges[i];
            int a = e[0], b = e[1];
            double p = succProb[i];
            g[a].add(new Pair<>(b, p));
            g[b].add(new Pair<>(a, p));
        }
        double[] dist = new double[n];
        dist[start_node] = 1;
        PriorityQueue<Pair<Integer, Double>> pq
            = new PriorityQueue<>(Comparator.comparingDouble(p -> - p.getValue()));
        pq.offer(new Pair<>(start_node, 1.0));
        while (!pq.isEmpty()) {
            var p = pq.poll();
            int a = p.getKey();
            double w = p.getValue();
            if (dist[a] > w) {
                continue;
            }
            for (var e : g[a]) {
                int b = e.getKey();
                double pab = e.getValue();
                double wab = w * pab;
                if (wab > dist[b]) {
                    dist[b] = wab;
                    pq.offer(new Pair<>(b, wab));
                }
            }
        }
        return dist[end_node];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1514 _tcSol = new Solution1514();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2");
        try {
            int n = 3;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{0, 2}};
            double[] succProb = new double[]{0.5, 0.5, 0.2};
            int start_node = 0;
            int end_node = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProbability(n, edges, succProb, start_node, end_node)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0.25000");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2");
        try {
            int n = 3;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{0, 2}};
            double[] succProb = new double[]{0.5, 0.5, 0.3};
            int start_node = 0;
            int end_node = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProbability(n, edges, succProb, start_node, end_node)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0.30000");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2");
        try {
            int n = 3;
            int[][] edges = new int[][]{new int[]{0, 1}};
            double[] succProb = new double[]{0.5};
            int start_node = 0;
            int end_node = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProbability(n, edges, succProb, start_node, end_node)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0.00000");
        System.out.println();
    }
}
