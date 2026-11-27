package com.leetcode.dynamic_programming;

class Solution1473 {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] f = new int[m][n + 1][target + 1];
        final int inf = 1 << 30;
        for (int[][] g : f) {
            for (int[] e : g) {
                Arrays.fill(e, inf);
            }
        }
        if (houses[0] == 0) {
            for (int j = 1; j <= n; ++j) {
                f[0][j][1] = cost[0][j - 1];
            }
        } else {
            f[0][houses[0]][1] = 0;
        }
        for (int i = 1; i < m; ++i) {
            if (houses[i] == 0) {
                for (int j = 1; j <= n; ++j) {
                    for (int k = 1; k <= Math.min(target, i + 1); ++k) {
                        for (int j0 = 1; j0 <= n; ++j0) {
                            if (j == j0) {
                                f[i][j][k] = Math.min(f[i][j][k], f[i - 1][j][k] + cost[i][j - 1]);
                            } else {
                                f[i][j][k]
                                    = Math.min(f[i][j][k], f[i - 1][j0][k - 1] + cost[i][j - 1]);
                            }
                        }
                    }
                }
            } else {
                int j = houses[i];
                for (int k = 1; k <= Math.min(target, i + 1); ++k) {
                    for (int j0 = 1; j0 <= n; ++j0) {
                        if (j == j0) {
                            f[i][j][k] = Math.min(f[i][j][k], f[i - 1][j][k]);
                        } else {
                            f[i][j][k] = Math.min(f[i][j][k], f[i - 1][j0][k - 1]);
                        }
                    }
                }
            }
        }
        int ans = inf;
        for (int j = 1; j <= n; ++j) {
            ans = Math.min(ans, f[m - 1][j][target]);
        }
        return ans >= inf ? -1 : ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1473 _tcSol = new Solution1473();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "houses = [0,0,0,0,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3");
        try {
            int[] houses = new int[]{0, 0, 0, 0, 0};
            int[][] cost = new int[][]{new int[]{1, 10}, new int[]{10, 1}, new int[]{10, 1}, new int[]{1, 10}, new int[]{5, 1}};
            int m = 5;
            int n = 2;
            int target = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(houses, cost, m, n, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "houses = [0,2,1,2,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3");
        try {
            int[] houses = new int[]{0, 2, 1, 2, 0};
            int[][] cost = new int[][]{new int[]{1, 10}, new int[]{10, 1}, new int[]{10, 1}, new int[]{1, 10}, new int[]{5, 1}};
            int m = 5;
            int n = 2;
            int target = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(houses, cost, m, n, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "houses = [3,1,2,3], cost = [[1,1,1],[1,1,1],[1,1,1],[1,1,1]], m = 4, n = 3, target = 3");
        try {
            int[] houses = new int[]{3, 1, 2, 3};
            int[][] cost = new int[][]{new int[]{1, 1, 1}, new int[]{1, 1, 1}, new int[]{1, 1, 1}, new int[]{1, 1, 1}};
            int m = 4;
            int n = 3;
            int target = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(houses, cost, m, n, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}