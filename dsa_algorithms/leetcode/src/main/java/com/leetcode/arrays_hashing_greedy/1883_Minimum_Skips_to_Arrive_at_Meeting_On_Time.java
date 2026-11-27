package com.leetcode.arrays_hashing_greedy;

class Solution1883 {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        int n = dist.length;
        double[][] f = new double[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(f[i], 1e20);
        }
        f[0][0] = 0;
        double eps = 1e-8;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (j < i) {
                    f[i][j] = Math.min(
                        f[i][j], Math.ceil(f[i - 1][j]) + 1.0 * dist[i - 1] / speed - eps);
                }
                if (j > 0) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 1.0 * dist[i - 1] / speed);
                }
            }
        }
        for (int j = 0; j <= n; ++j) {
            if (f[n][j] <= hoursBefore + eps) {
                return j;
            }
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1883 _tcSol = new Solution1883();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "dist = [1,3,2], speed = 4, hoursBefore = 2");
        try {
            int[] dist = new int[]{1, 3, 2};
            int speed = 4;
            int hoursBefore = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minSkips(dist, speed, hoursBefore)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "dist = [7,3,5,5], speed = 2, hoursBefore = 10");
        try {
            int[] dist = new int[]{7, 3, 5, 5};
            int speed = 2;
            int hoursBefore = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.minSkips(dist, speed, hoursBefore)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "dist = [7,3,5,5], speed = 1, hoursBefore = 10");
        try {
            int[] dist = new int[]{7, 3, 5, 5};
            int speed = 1;
            int hoursBefore = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.minSkips(dist, speed, hoursBefore)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}