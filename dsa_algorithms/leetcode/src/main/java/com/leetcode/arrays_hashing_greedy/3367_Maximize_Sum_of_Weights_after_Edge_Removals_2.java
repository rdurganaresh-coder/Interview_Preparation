package com.leetcode.arrays_hashing_greedy;

class Solution3367_2 {
    public long maximizeSumOfWeights(int[][] edges, int k) {
        int n = edges.length + 1;
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (var e : edges) {
            int u = e[0], v = e[1], w = e[2];
            g[u].add(new int[] {v, w});
            g[v].add(new int[] {u, w});
        }
        long[] keep = new long[n];
        long[] reserve = new long[n];
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {0, -1, 0});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int u = cur[0], fa = cur[1], state = cur[2];
            if (state == 0) {
                stk.push(new int[] {u, fa, 1});
                for (var e : g[u]) {
                    if (e[0] != fa) {
                        stk.push(new int[] {e[0], u, 0});
                    }
                }
            } else {
                long s = 0;
                List<Long> t = new ArrayList<>();
                for (var e : g[u]) {
                    int v = e[0], w = e[1];
                    if (v == fa) {
                        continue;
                    }
                    s += keep[v];
                    long d = w + reserve[v] - keep[v];
                    if (d > 0) {
                        t.add(d);
                    }
                }
                t.sort(Comparator.reverseOrder());
                for (int i = 0; i < Math.min(t.size(), k - 1); ++i) {
                    s += t.get(i);
                }
                reserve[u] = s;
                keep[u] = s + (t.size() >= k ? t.get(k - 1) : 0);
            }
        }
        return Math.max(keep[0], reserve[0]);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3367_2 _tcSol = new Solution3367_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges = [[0,1,4],[0,2,2],[2,3,12],[2,4,6]], k = 2");
        try {
            int[][] edges = new int[][]{new int[]{0, 1, 4}, new int[]{0, 2, 2}, new int[]{2, 3, 12}, new int[]{2, 4, 6}};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximizeSumOfWeights(edges, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "22");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges = [[0,1,5],[1,2,10],[0,3,15],[3,4,20],[3,5,5],[0,6,10]], k = 3");
        try {
            int[][] edges = new int[][]{new int[]{0, 1, 5}, new int[]{1, 2, 10}, new int[]{0, 3, 15}, new int[]{3, 4, 20}, new int[]{3, 5, 5}, new int[]{0, 6, 10}};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximizeSumOfWeights(edges, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "65");
        System.out.println();
    }
}
