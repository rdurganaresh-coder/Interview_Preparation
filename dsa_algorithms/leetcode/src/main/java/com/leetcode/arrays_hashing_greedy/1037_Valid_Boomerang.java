package com.leetcode.arrays_hashing_greedy;

class Solution1037 {
    public boolean isBoomerang(int[][] points) {
        int x1 = points[0][0], y1 = points[0][1];
        int x2 = points[1][0], y2 = points[1][1];
        int x3 = points[2][0], y3 = points[2][1];
        return (y2 - y1) * (x3 - x2) != (y3 - y2) * (x2 - x1);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1037 _tcSol = new Solution1037();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "points = [[1,1],[2,3],[3,2]]");
        try {
            int[][] points = new int[][]{new int[]{1, 1}, new int[]{2, 3}, new int[]{3, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.isBoomerang(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "points = [[1,1],[2,2],[3,3]]");
        try {
            int[][] points = new int[][]{new int[]{1, 1}, new int[]{2, 2}, new int[]{3, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.isBoomerang(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}