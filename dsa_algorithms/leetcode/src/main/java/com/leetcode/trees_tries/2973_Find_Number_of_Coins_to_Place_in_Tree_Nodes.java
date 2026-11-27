package com.leetcode.trees_tries;

class Solution2973 {
    private int[] cost;
    private List<Integer>[] g;
    private long[] ans;

    public long[] placedCoins(int[][] edges, int[] cost) {
        int n = cost.length;
        this.cost = cost;
        ans = new long[n];
        g = new List[n];
        Arrays.fill(ans, 1);
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        dfs(0, -1);
        return ans;
    }

    private List<Integer> dfs(int a, int fa) {
        List<Integer> res = new ArrayList<>();
        res.add(cost[a]);
        for (int b : g[a]) {
            if (b != fa) {
                res.addAll(dfs(b, a));
            }
        }
        Collections.sort(res);
        int m = res.size();
        if (m >= 3) {
            long x = (long) res.get(m - 1) * res.get(m - 2) * res.get(m - 3);
            long y = (long) res.get(0) * res.get(1) * res.get(m - 1);
            ans[a] = Math.max(0, Math.max(x, y));
        }
        if (m >= 5) {
            res = List.of(res.get(0), res.get(1), res.get(m - 3), res.get(m - 2), res.get(m - 1));
        }
        return res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2973 _tcSol = new Solution2973();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges = [[0,1],[0,2],[0,3],[0,4],[0,5]], cost = [1,2,3,4,5,6]");
        try {
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{0, 4}, new int[]{0, 5}};
            int[] cost = new int[]{1, 2, 3, 4, 5, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.placedCoins(edges, cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[120,1,1,1,1,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges = [[0,1],[0,2],[1,3],[1,4],[1,5],[2,6],[2,7],[2,8]], cost = [1,4,2,3,5,7,8,-4,2]");
        try {
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 3}, new int[]{1, 4}, new int[]{1, 5}, new int[]{2, 6}, new int[]{2, 7}, new int[]{2, 8}};
            int[] cost = new int[]{1, 4, 2, 3, 5, 7, 8, -4, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.placedCoins(edges, cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[280,140,32,1,1,1,1,1,1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "edges = [[0,1],[0,2]], cost = [1,2,-2]");
        try {
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}};
            int[] cost = new int[]{1, 2, -2};
            System.out.println("  Output  : " + _tcShow(_tcSol.placedCoins(edges, cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,1]");
        System.out.println();
    }
}
