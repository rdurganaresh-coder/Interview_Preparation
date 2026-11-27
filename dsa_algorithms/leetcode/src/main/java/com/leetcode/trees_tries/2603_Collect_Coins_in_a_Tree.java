package com.leetcode.trees_tries;

class Solution2603 {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        Set<Integer>[] g = new Set[n];
        Arrays.setAll(g, k -> new HashSet<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (coins[i] == 0 && g[i].size() == 1) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int i = q.poll();
            for (int j : g[i]) {
                g[j].remove(i);
                if (coins[j] == 0 && g[j].size() == 1) {
                    q.offer(j);
                }
            }
            g[i].clear();
        }
        q.clear();
        for (int k = 0; k < 2; ++k) {
            for (int i = 0; i < n; ++i) {
                if (g[i].size() == 1) {
                    q.offer(i);
                }
            }
            for (int i : q) {
                for (int j : g[i]) {
                    g[j].remove(i);
                }
                g[i].clear();
            }
        }
        int ans = 0;
        for (var e : edges) {
            int a = e[0], b = e[1];
            if (g[a].size() > 0 && g[b].size() > 0) {
                ans += 2;
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
        Solution2603 _tcSol = new Solution2603();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "coins = [1,0,0,0,0,1], edges = [[0,1],[1,2],[2,3],[3,4],[4,5]]");
        try {
            int[] coins = new int[]{1, 0, 0, 0, 0, 1};
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{4, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.collectTheCoins(coins, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "coins = [0,0,0,1,1,0,0,1], edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[5,6],[5,7]]");
        try {
            int[] coins = new int[]{0, 0, 0, 1, 1, 0, 0, 1};
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 3}, new int[]{1, 4}, new int[]{2, 5}, new int[]{5, 6}, new int[]{5, 7}};
            System.out.println("  Output  : " + _tcShow(_tcSol.collectTheCoins(coins, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}