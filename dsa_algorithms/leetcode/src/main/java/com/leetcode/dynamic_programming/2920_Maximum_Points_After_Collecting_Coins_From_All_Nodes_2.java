package com.leetcode.dynamic_programming;

class Solution2920_2 {
    public int maximumPoints(int[][] edges, int[] coins, int k) {
        int n = coins.length;
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        int[][] f = new int[n][15];
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {0, -1, 0});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int i = cur[0], fa = cur[1], state = cur[2];
            if (state == 0) {
                stk.push(new int[] {i, fa, 1});
                for (int c : g[i]) {
                    if (c != fa) {
                        stk.push(new int[] {c, i, 0});
                    }
                }
            } else {
                for (int j = 0; j < 15; ++j) {
                    int a = (coins[i] >> j) - k;
                    int b = coins[i] >> (j + 1);
                    for (int c : g[i]) {
                        if (c != fa) {
                            a += f[c][j];
                            if (j < 14) {
                                b += f[c][j + 1];
                            }
                        }
                    }
                    f[i][j] = Math.max(a, b);
                }
            }
        }
        return f[0][0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2920_2 _tcSol = new Solution2920_2();
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
