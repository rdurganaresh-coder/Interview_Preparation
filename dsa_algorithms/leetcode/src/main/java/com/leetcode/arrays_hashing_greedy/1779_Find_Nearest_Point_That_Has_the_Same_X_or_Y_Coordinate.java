package com.leetcode.arrays_hashing_greedy;

class Solution1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int ans = -1, mi = 1000000;
        for (int i = 0; i < points.length; ++i) {
            int a = points[i][0], b = points[i][1];
            if (a == x || b == y) {
                int d = Math.abs(a - x) + Math.abs(b - y);
                if (d < mi) {
                    mi = d;
                    ans = i;
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
        Solution1779 _tcSol = new Solution1779();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "x = 3, y = 4, points = [[1,2],[3,1],[2,4],[2,3],[4,4]]");
        try {
            int x = 3;
            int y = 4;
            int[][] points = new int[][]{new int[]{1, 2}, new int[]{3, 1}, new int[]{2, 4}, new int[]{2, 3}, new int[]{4, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.nearestValidPoint(x, y, points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "x = 3, y = 4, points = [[3,4]]");
        try {
            int x = 3;
            int y = 4;
            int[][] points = new int[][]{new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.nearestValidPoint(x, y, points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "x = 3, y = 4, points = [[2,3]]");
        try {
            int x = 3;
            int y = 4;
            int[][] points = new int[][]{new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.nearestValidPoint(x, y, points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}