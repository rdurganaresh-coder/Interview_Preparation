package com.leetcode.arrays_hashing_greedy;

class Solution1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[0][0], y1 = coordinates[0][1];
        int x2 = coordinates[1][0], y2 = coordinates[1][1];
        for (int i = 2; i < coordinates.length; ++i) {
            int x = coordinates[i][0], y = coordinates[i][1];
            if ((x - x1) * (y2 - y1) != (y - y1) * (x2 - x1)) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1232 _tcSol = new Solution1232();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]");
        try {
            int[][] coordinates = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{4, 5}, new int[]{5, 6}, new int[]{6, 7}};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkStraightLine(coordinates)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]");
        try {
            int[][] coordinates = new int[][]{new int[]{1, 1}, new int[]{2, 2}, new int[]{3, 4}, new int[]{4, 5}, new int[]{5, 6}, new int[]{7, 7}};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkStraightLine(coordinates)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}