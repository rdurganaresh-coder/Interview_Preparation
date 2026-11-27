package com.leetcode.sql_database;

class Solution2646 {
    private List<Integer>[] g;
    private int[] price;
    private int[] cnt;

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        this.price = price;
        cnt = new int[n];
        g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        for (var t : trips) {
            int start = t[0], end = t[1];
            dfs(start, -1, end);
        }
        int[] ans = dfs2(0, -1);
        return Math.min(ans[0], ans[1]);
    }

    private boolean dfs(int i, int fa, int k) {
        ++cnt[i];
        if (i == k) {
            return true;
        }
        boolean ok = false;
        for (int j : g[i]) {
            if (j != fa) {
                ok = dfs(j, i, k);
                if (ok) {
                    break;
                }
            }
        }
        if (!ok) {
            --cnt[i];
        }
        return ok;
    }

    private int[] dfs2(int i, int fa) {
        int a = cnt[i] * price[i];
        int b = a >> 1;
        for (int j : g[i]) {
            if (j != fa) {
                var t = dfs2(j, i);
                a += Math.min(t[0], t[1]);
                b += t[0];
            }
        }
        return new int[] {a, b};
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2646 _tcSol = new Solution2646();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, edges = [[0,1],[1,2],[1,3]], price = [2,2,10,6], trips = [[0,3],[2,1],[2,3]]");
        try {
            int n = 4;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{1, 3}};
            int[] price = new int[]{2, 2, 10, 6};
            int[][] trips = new int[][]{new int[]{0, 3}, new int[]{2, 1}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTotalPrice(n, edges, price, trips)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "23");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2, edges = [[0,1]], price = [2,2], trips = [[0,0]]");
        try {
            int n = 2;
            int[][] edges = new int[][]{new int[]{0, 1}};
            int[] price = new int[]{2, 2};
            int[][] trips = new int[][]{new int[]{0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTotalPrice(n, edges, price, trips)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}