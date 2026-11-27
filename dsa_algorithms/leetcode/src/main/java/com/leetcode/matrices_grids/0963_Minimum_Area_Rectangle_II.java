package com.leetcode.matrices_grids;

class Solution0963 {
    public double minAreaFreeRect(int[][] points) {
        int n = points.length;
        Set<Integer> s = new HashSet<>(n);
        for (int[] p : points) {
            s.add(f(p[0], p[1]));
        }
        double ans = Double.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = 0; j < n; ++j) {
                if (j != i) {
                    int x2 = points[j][0], y2 = points[j][1];
                    for (int k = j + 1; k < n; ++k) {
                        if (k != i) {
                            int x3 = points[k][0], y3 = points[k][1];
                            int x4 = x2 - x1 + x3, y4 = y2 - y1 + y3;
                            if (x4 >= 0 && x4 <= 40000 && y4 >= 0 && y4 <= 40000
                                && s.contains(f(x4, y4))) {
                                if ((x2 - x1) * (x3 - x1) + (y2 - y1) * (y3 - y1) == 0) {
                                    long ww = (long) (x2 - x1) * (x2 - x1)
                                        + (long) (y2 - y1) * (y2 - y1);
                                    long hh = (long) (x3 - x1) * (x3 - x1)
                                        + (long) (y3 - y1) * (y3 - y1);
                                    ans = Math.min(ans, Math.sqrt(ww * hh));
                                }
                            }
                        }
                    }
                }
            }
        }
        return ans == Double.MAX_VALUE ? 0 : ans;
    }

    private int f(int x, int y) {
        return x * 40001 + y;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0963 _tcSol = new Solution0963();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "points = [[1,2],[2,1],[1,0],[0,1]]");
        try {
            int[][] points = new int[][]{new int[]{1, 2}, new int[]{2, 1}, new int[]{1, 0}, new int[]{0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minAreaFreeRect(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2.00000");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "points = [[0,1],[2,1],[1,1],[1,0],[2,0]]");
        try {
            int[][] points = new int[][]{new int[]{0, 1}, new int[]{2, 1}, new int[]{1, 1}, new int[]{1, 0}, new int[]{2, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minAreaFreeRect(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1.00000");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "points = [[0,3],[1,2],[3,1],[1,3],[2,1]]");
        try {
            int[][] points = new int[][]{new int[]{0, 3}, new int[]{1, 2}, new int[]{3, 1}, new int[]{1, 3}, new int[]{2, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minAreaFreeRect(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}