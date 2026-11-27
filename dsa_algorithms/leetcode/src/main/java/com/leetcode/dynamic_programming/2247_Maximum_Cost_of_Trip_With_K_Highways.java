package com.leetcode.dynamic_programming;

class Solution2247 {
    public int maximumCost(int n, int[][] highways, int k) {
        if (k >= n) {
            return -1;
        }
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, h -> new ArrayList<>());
        for (int[] h : highways) {
            int a = h[0], b = h[1], cost = h[2];
            g[a].add(new int[] {b, cost});
            g[b].add(new int[] {a, cost});
        }
        int[][] f = new int[1 << n][n];
        for (int[] e : f) {
            Arrays.fill(e, -(1 << 30));
        }
        for (int i = 0; i < n; ++i) {
            f[1 << i][i] = 0;
        }
        int ans = -1;
        for (int i = 0; i < 1 << n; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i >> j & 1) == 1) {
                    for (var e : g[j]) {
                        int h = e[0], cost = e[1];
                        if ((i >> h & 1) == 1) {
                            f[i][j] = Math.max(f[i][j], f[i ^ (1 << j)][h] + cost);
                        }
                    }
                }
                if (Integer.bitCount(i) == k + 1) {
                    ans = Math.max(ans, f[i][j]);
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
        Solution2247 _tcSol = new Solution2247();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, highways = [[0,1,4],[2,1,3],[1,4,11],[3,2,3],[3,4,2]], k = 3");
        try {
            int n = 5;
            int[][] highways = new int[][]{new int[]{0, 1, 4}, new int[]{2, 1, 3}, new int[]{1, 4, 11}, new int[]{3, 2, 3}, new int[]{3, 4, 2}};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumCost(n, highways, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "17");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, highways = [[0,1,3],[2,3,2]], k = 2");
        try {
            int n = 4;
            int[][] highways = new int[][]{new int[]{0, 1, 3}, new int[]{2, 3, 2}};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumCost(n, highways, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}