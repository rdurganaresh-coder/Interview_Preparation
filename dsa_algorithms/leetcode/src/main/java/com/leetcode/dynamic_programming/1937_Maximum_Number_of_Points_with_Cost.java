package com.leetcode.dynamic_programming;

class Solution1937 {
    public long maxPoints(int[][] points) {
        int n = points[0].length;
        long[] f = new long[n];
        final long inf = 1L << 60;
        for (int[] p : points) {
            long[] g = new long[n];
            long lmx = -inf, rmx = -inf;
            for (int j = 0; j < n; ++j) {
                lmx = Math.max(lmx, f[j] + j);
                g[j] = Math.max(g[j], p[j] + lmx - j);
            }
            for (int j = n - 1; j >= 0; --j) {
                rmx = Math.max(rmx, f[j] - j);
                g[j] = Math.max(g[j], p[j] + rmx + j);
            }
            f = g;
        }
        long ans = 0;
        for (long x : f) {
            ans = Math.max(ans, x);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1937 _tcSol = new Solution1937();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "points = [[1,2,3],[1,5,1],[3,1,1]]");
        try {
            int[][] points = new int[][]{new int[]{1, 2, 3}, new int[]{1, 5, 1}, new int[]{3, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxPoints(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "points = [[1,5],[2,3],[4,2]]");
        try {
            int[][] points = new int[][]{new int[]{1, 5}, new int[]{2, 3}, new int[]{4, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxPoints(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();
    }
}