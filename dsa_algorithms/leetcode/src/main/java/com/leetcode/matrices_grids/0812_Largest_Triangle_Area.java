package com.leetcode.matrices_grids;

class Solution0812 {
    public double largestTriangleArea(int[][] points) {
        double ans = 0;
        for (int[] p1 : points) {
            int x1 = p1[0], y1 = p1[1];
            for (int[] p2 : points) {
                int x2 = p2[0], y2 = p2[1];
                for (int[] p3 : points) {
                    int x3 = p3[0], y3 = p3[1];
                    int u1 = x2 - x1, v1 = y2 - y1;
                    int u2 = x3 - x1, v2 = y3 - y1;
                    double t = Math.abs(u1 * v2 - u2 * v1) / 2.0;
                    ans = Math.max(ans, t);
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
        Solution0812 _tcSol = new Solution0812();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "points = [[0,0],[0,1],[1,0],[0,2],[2,0]]");
        try {
            int[][] points = new int[][]{new int[]{0, 0}, new int[]{0, 1}, new int[]{1, 0}, new int[]{0, 2}, new int[]{2, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestTriangleArea(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2.00000");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "points = [[1,0],[0,0],[0,1]]");
        try {
            int[][] points = new int[][]{new int[]{1, 0}, new int[]{0, 0}, new int[]{0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestTriangleArea(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0.50000");
        System.out.println();
    }
}