package com.leetcode.graphs_shortest_path;

class Solution1617_2 {
    private List<Integer>[] g;
    private int msk;
    private int nxt;

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0] - 1, v = e[1] - 1;
            g[u].add(v);
            g[v].add(u);
        }
        int[] ans = new int[n - 1];
        for (int mask = 1; mask < 1 << n; ++mask) {
            if ((mask & (mask - 1)) == 0) {
                continue;
            }
            msk = mask;
            int cur = 31 - Integer.numberOfLeadingZeros(msk);
            bfs(cur);
            if (msk == 0) {
                msk = mask;
                int mx = bfs(nxt);
                ++ans[mx - 1];
            }
        }
        return ans;
    }

    private int bfs(int u) {
        int d = -1;
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(u);
        msk ^= 1 << u;
        while (!q.isEmpty()) {
            ++d;
            for (int k = q.size(); k > 0; --k) {
                u = q.poll();
                nxt = u;
                for (int v : g[u]) {
                    if ((msk >> v & 1) == 1) {
                        msk ^= 1 << v;
                        q.offer(v);
                    }
                }
            }
        }
        return d;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1617_2 _tcSol = new Solution1617_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, edges = [[1,2],[2,3],[2,4]]");
        try {
            int n = 4;
            int[][] edges = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{2, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubgraphsForEachDiameter(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,4,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2, edges = [[1,2]]");
        try {
            int n = 2;
            int[][] edges = new int[][]{new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubgraphsForEachDiameter(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 3, edges = [[1,2],[2,3]]");
        try {
            int n = 3;
            int[][] edges = new int[][]{new int[]{1, 2}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubgraphsForEachDiameter(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,1]");
        System.out.println();
    }
}