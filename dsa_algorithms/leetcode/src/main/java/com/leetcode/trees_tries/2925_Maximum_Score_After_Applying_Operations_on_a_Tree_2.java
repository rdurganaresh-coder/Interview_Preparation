package com.leetcode.trees_tries;

class Solution2925_2 {
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n = values.length;
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        long[] sum = new long[n];
        long[] best = new long[n];
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {0, -1, 0});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int i = cur[0], fa = cur[1], state = cur[2];
            if (state == 0) {
                stk.push(new int[] {i, fa, 1});
                for (int j : g[i]) {
                    if (j != fa) {
                        stk.push(new int[] {j, i, 0});
                    }
                }
            } else {
                long a = 0, b = 0;
                boolean leaf = true;
                for (int j : g[i]) {
                    if (j != fa) {
                        leaf = false;
                        a += sum[j];
                        b += best[j];
                    }
                }
                if (leaf) {
                    sum[i] = values[i];
                    best[i] = 0;
                } else {
                    sum[i] = values[i] + a;
                    best[i] = Math.max(values[i] + b, a);
                }
            }
        }
        return best[0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2925_2 _tcSol = new Solution2925_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges = [[0,1],[0,2],[0,3],[2,4],[4,5]], values = [5,2,5,2,1,1]");
        try {
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{2, 4}, new int[]{4, 5}};
            int[] values = new int[]{5, 2, 5, 2, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumScoreAfterOperations(edges, values)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]], values = [20,10,9,7,4,3,5]");
        try {
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 3}, new int[]{1, 4}, new int[]{2, 5}, new int[]{2, 6}};
            int[] values = new int[]{20, 10, 9, 7, 4, 3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumScoreAfterOperations(edges, values)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "40");
        System.out.println();
    }
}
