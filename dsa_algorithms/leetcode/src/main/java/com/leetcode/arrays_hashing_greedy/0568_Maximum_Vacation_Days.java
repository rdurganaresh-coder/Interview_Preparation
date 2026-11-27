package com.leetcode.arrays_hashing_greedy;

class Solution0568 {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length;
        int K = days[0].length;
        final int inf = 1 << 30;
        int[][] f = new int[K + 1][n];
        for (var g : f) {
            Arrays.fill(g, -inf);
        }
        f[0][0] = 0;
        for (int k = 1; k <= K; ++k) {
            for (int j = 0; j < n; ++j) {
                f[k][j] = f[k - 1][j];
                for (int i = 0; i < n; ++i) {
                    if (flights[i][j] == 1) {
                        f[k][j] = Math.max(f[k][j], f[k - 1][i]);
                    }
                }
                f[k][j] += days[j][k - 1];
            }
        }
        int ans = 0;
        for (int j = 0; j < n; ++j) {
            ans = Math.max(ans, f[K][j]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0568 _tcSol = new Solution0568();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "flights = [[0,1,1],[1,0,1],[1,1,0]], days = [[1,3,1],[6,0,3],[3,3,3]]");
        try {
            int[][] flights = new int[][]{new int[]{0, 1, 1}, new int[]{1, 0, 1}, new int[]{1, 1, 0}};
            int[][] days = new int[][]{new int[]{1, 3, 1}, new int[]{6, 0, 3}, new int[]{3, 3, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxVacationDays(flights, days)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "flights = [[0,0,0],[0,0,0],[0,0,0]], days = [[1,1,1],[7,7,7],[7,7,7]]");
        try {
            int[][] flights = new int[][]{new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}};
            int[][] days = new int[][]{new int[]{1, 1, 1}, new int[]{7, 7, 7}, new int[]{7, 7, 7}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxVacationDays(flights, days)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "flights = [[0,1,1],[1,0,1],[1,1,0]], days = [[7,0,0],[0,7,0],[0,0,7]]");
        try {
            int[][] flights = new int[][]{new int[]{0, 1, 1}, new int[]{1, 0, 1}, new int[]{1, 1, 0}};
            int[][] days = new int[][]{new int[]{7, 0, 0}, new int[]{0, 7, 0}, new int[]{0, 0, 7}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxVacationDays(flights, days)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "21");
        System.out.println();
    }
}