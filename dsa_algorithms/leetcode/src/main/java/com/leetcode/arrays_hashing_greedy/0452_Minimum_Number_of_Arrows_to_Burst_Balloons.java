package com.leetcode.arrays_hashing_greedy;

class Solution0452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int ans = 0;
        long last = -(1L << 60);
        for (var p : points) {
            int a = p[0], b = p[1];
            if (a > last) {
                ++ans;
                last = b;
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
        Solution0452 _tcSol = new Solution0452();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "points = [[10,16],[2,8],[1,6],[7,12]]");
        try {
            int[][] points = new int[][]{new int[]{10, 16}, new int[]{2, 8}, new int[]{1, 6}, new int[]{7, 12}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMinArrowShots(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "points = [[1,2],[3,4],[5,6],[7,8]]");
        try {
            int[][] points = new int[][]{new int[]{1, 2}, new int[]{3, 4}, new int[]{5, 6}, new int[]{7, 8}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMinArrowShots(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "points = [[1,2],[2,3],[3,4],[4,5]]");
        try {
            int[][] points = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{4, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMinArrowShots(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}