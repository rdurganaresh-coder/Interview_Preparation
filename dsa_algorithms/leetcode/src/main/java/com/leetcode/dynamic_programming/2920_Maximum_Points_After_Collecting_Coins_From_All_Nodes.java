package com.leetcode.dynamic_programming;

class Solution2920 {
    private int k;
    private int[] coins;
    private Integer[][] f;
    private List<Integer>[] g;

    public int maximumPoints(int[][] edges, int[] coins, int k) {
        this.k = k;
        this.coins = coins;
        int n = coins.length;
        f = new Integer[n][15];
        g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        return dfs(0, -1, 0);
    }

    private int dfs(int i, int fa, int j) {
        if (f[i][j] != null) {
            return f[i][j];
        }
        int a = (coins[i] >> j) - k;
        int b = coins[i] >> (j + 1);
        for (int c : g[i]) {
            if (c != fa) {
                a += dfs(c, i, j);
                if (j < 14) {
                    b += dfs(c, i, j + 1);
                }
            }
        }
        return f[i][j] = Math.max(a, b);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2920 _tcSol = new Solution2920();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges = [[0,1],[1,2],[2,3]], coins = [10,10,3,3], k = 5");
        try {
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}};
            int[] coins = new int[]{10, 10, 3, 3};
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumPoints(edges, coins, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges = [[0,1],[0,2]], coins = [8,4,4], k = 0");
        try {
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}};
            int[] coins = new int[]{8, 4, 4};
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumPoints(edges, coins, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();
    }
}
