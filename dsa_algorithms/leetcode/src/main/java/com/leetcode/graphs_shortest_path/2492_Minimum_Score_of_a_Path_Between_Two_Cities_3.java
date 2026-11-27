package com.leetcode.graphs_shortest_path;

class Solution2492_3 {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] g = new List[n + 1];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : roads) {
            int a = e[0], b = e[1], w = e[2];
            g[a].add(new int[] {b, w});
            g[b].add(new int[] {a, w});
        }
        int ans = Integer.MAX_VALUE;
        boolean[] vis = new boolean[n + 1];
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(1);
        while (!stk.isEmpty()) {
            int a = stk.pop();
            if (vis[a]) {
                continue;
            }
            vis[a] = true;
            for (int[] nb : g[a]) {
                int b = nb[0], w = nb[1];
                ans = Math.min(ans, w);
                if (!vis[b]) {
                    stk.push(b);
                }
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
        Solution2492_3 _tcSol = new Solution2492_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, roads = [[1,2,9],[2,3,6],[2,4,5],[1,4,7]]");
        try {
            int n = 4;
            int[][] roads = new int[][]{new int[]{1, 2, 9}, new int[]{2, 3, 6}, new int[]{2, 4, 5}, new int[]{1, 4, 7}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minScore(n, roads)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, roads = [[1,2,2],[1,3,4],[3,4,7]]");
        try {
            int n = 4;
            int[][] roads = new int[][]{new int[]{1, 2, 2}, new int[]{1, 3, 4}, new int[]{3, 4, 7}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minScore(n, roads)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
