package com.leetcode.arrays_hashing_greedy;

class Solution1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 1; i < points.length; ++i) {
            int dx = Math.abs(points[i][0] - points[i - 1][0]);
            int dy = Math.abs(points[i][1] - points[i - 1][1]);
            ans += Math.max(dx, dy);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1266 _tcSol = new Solution1266();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "points = [[1,1],[3,4],[-1,0]]");
        try {
            int[][] points = new int[][]{new int[]{1, 1}, new int[]{3, 4}, new int[]{-1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minTimeToVisitAllPoints(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "points = [[3,2],[-2,2]]");
        try {
            int[][] points = new int[][]{new int[]{3, 2}, new int[]{-2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minTimeToVisitAllPoints(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}