package com.leetcode.trees_tries;

class Solution2378_2 {
    public long maxScore(int[][] edges) {
        int n = edges.length;
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 1; i < n; ++i) {
            int p = edges[i][0], w = edges[i][1];
            g[p].add(new int[] {i, w});
        }
        long[][] down = new long[n][2];
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {0, 0});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int i = cur[0], state = cur[1];
            if (state == 0) {
                stk.push(new int[] {i, 1});
                for (int[] nxt : g[i]) {
                    stk.push(new int[] {nxt[0], 0});
                }
            } else {
                long a = 0, b = 0, t = 0;
                for (int[] nxt : g[i]) {
                    int j = nxt[0], w = nxt[1];
                    long x = down[j][0], y = down[j][1];
                    a += y;
                    b += y;
                    t = Math.max(t, x - y + w);
                }
                b += t;
                down[i][0] = a;
                down[i][1] = b;
            }
        }
        return down[0][1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2378_2 _tcSol = new Solution2378_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges = [[-1,-1],[0,5],[0,10],[2,6],[2,4]]");
        try {
            int[][] edges = new int[][]{new int[]{-1, -1}, new int[]{0, 5}, new int[]{0, 10}, new int[]{2, 6}, new int[]{2, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges = [[-1,-1],[0,5],[0,-6],[0,7]]");
        try {
            int[][] edges = new int[][]{new int[]{-1, -1}, new int[]{0, 5}, new int[]{0, -6}, new int[]{0, 7}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}
