package com.leetcode.dynamic_programming;

class Solution1928 {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int m = maxTime, n = passingFees.length;
        int[][] f = new int[m + 1][n];
        final int inf = 1 << 30;
        for (var g : f) {
            Arrays.fill(g, inf);
        }
        f[0][0] = passingFees[0];
        for (int i = 1; i <= m; ++i) {
            for (var e : edges) {
                int x = e[0], y = e[1], t = e[2];
                if (t <= i) {
                    f[i][x] = Math.min(f[i][x], f[i - t][y] + passingFees[x]);
                    f[i][y] = Math.min(f[i][y], f[i - t][x] + passingFees[y]);
                }
            }
        }
        int ans = inf;
        for (int i = 0; i <= m; ++i) {
            ans = Math.min(ans, f[i][n - 1]);
        }
        return ans == inf ? -1 : ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1928 _tcSol = new Solution1928();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "maxTime = 30, edges = [[0,1,10],[1,2,10],[2,5,10],[0,3,1],[3,4,10],[4,5,15]], passingFees = [5,1,2,20,20,3]");
        try {
            int maxTime = 30;
            int[][] edges = new int[][]{new int[]{0, 1, 10}, new int[]{1, 2, 10}, new int[]{2, 5, 10}, new int[]{0, 3, 1}, new int[]{3, 4, 10}, new int[]{4, 5, 15}};
            int[] passingFees = new int[]{5, 1, 2, 20, 20, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(maxTime, edges, passingFees)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "maxTime = 29, edges = [[0,1,10],[1,2,10],[2,5,10],[0,3,1],[3,4,10],[4,5,15]], passingFees = [5,1,2,20,20,3]");
        try {
            int maxTime = 29;
            int[][] edges = new int[][]{new int[]{0, 1, 10}, new int[]{1, 2, 10}, new int[]{2, 5, 10}, new int[]{0, 3, 1}, new int[]{3, 4, 10}, new int[]{4, 5, 15}};
            int[] passingFees = new int[]{5, 1, 2, 20, 20, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(maxTime, edges, passingFees)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "48");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "maxTime = 25, edges = [[0,1,10],[1,2,10],[2,5,10],[0,3,1],[3,4,10],[4,5,15]], passingFees = [5,1,2,20,20,3]");
        try {
            int maxTime = 25;
            int[][] edges = new int[][]{new int[]{0, 1, 10}, new int[]{1, 2, 10}, new int[]{2, 5, 10}, new int[]{0, 3, 1}, new int[]{3, 4, 10}, new int[]{4, 5, 15}};
            int[] passingFees = new int[]{5, 1, 2, 20, 20, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(maxTime, edges, passingFees)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
