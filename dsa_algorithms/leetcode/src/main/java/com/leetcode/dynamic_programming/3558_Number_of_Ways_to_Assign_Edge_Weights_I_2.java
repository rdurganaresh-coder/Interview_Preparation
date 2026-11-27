package com.leetcode.dynamic_programming;

class Solution3558_2 {
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] g = new List[n + 1];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int u = e[0];
            int v = e[1];
            g[u].add(v);
            g[v].add(u);
        }
        int d = 0;
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {1, 0, 0});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int i = cur[0], fa = cur[1], dep = cur[2];
            d = Math.max(d, dep);
            for (int j : g[i]) {
                if (j != fa) {
                    stk.push(new int[] {j, i, dep + 1});
                }
            }
        }
        return (int) pow(2, d - 1, 1_000_000_007);
    }

    private long pow(long a, int n, int mod) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                res = res * a % mod;
            }
            a = a * a % mod;
            n >>= 1;
        }
        return res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3558_2 _tcSol = new Solution3558_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges = [[1,2]]");
        try {
            int[][] edges = new int[][]{new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.assignEdgeWeights(edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges = [[1,2],[1,3],[3,4],[3,5]]");
        try {
            int[][] edges = new int[][]{new int[]{1, 2}, new int[]{1, 3}, new int[]{3, 4}, new int[]{3, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.assignEdgeWeights(edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
