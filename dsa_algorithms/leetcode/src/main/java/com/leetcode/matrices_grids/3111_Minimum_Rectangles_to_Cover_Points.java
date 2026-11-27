package com.leetcode.matrices_grids;

class Solution3111 {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int ans = 0, x1 = -1;
        for (int[] p : points) {
            int x = p[0];
            if (x > x1) {
                ++ans;
                x1 = x + w;
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
        Solution3111 _tcSol = new Solution3111();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "points = [[2,1],[1,0],[1,4],[1,8],[3,5],[4,6]], w = 1");
        try {
            int[][] points = new int[][]{new int[]{2, 1}, new int[]{1, 0}, new int[]{1, 4}, new int[]{1, 8}, new int[]{3, 5}, new int[]{4, 6}};
            int w = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minRectanglesToCoverPoints(points, w)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "points = [[0,0],[1,1],[2,2],[3,3],[4,4],[5,5],[6,6]], w = 2");
        try {
            int[][] points = new int[][]{new int[]{0, 0}, new int[]{1, 1}, new int[]{2, 2}, new int[]{3, 3}, new int[]{4, 4}, new int[]{5, 5}, new int[]{6, 6}};
            int w = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minRectanglesToCoverPoints(points, w)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "points = [[2,3],[1,2]], w = 0");
        try {
            int[][] points = new int[][]{new int[]{2, 3}, new int[]{1, 2}};
            int w = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.minRectanglesToCoverPoints(points, w)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
