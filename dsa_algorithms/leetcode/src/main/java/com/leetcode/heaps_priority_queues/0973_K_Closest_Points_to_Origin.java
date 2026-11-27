package com.leetcode.heaps_priority_queues;

class Solution0973 {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(
            points, (p1, p2) -> Double.compare(Math.hypot(p1[0], p1[1]), Math.hypot(p2[0], p2[1])));
        return Arrays.copyOfRange(points, 0, k);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0973 _tcSol = new Solution0973();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "points = [[1,3],[-2,2]], k = 1");
        try {
            int[][] points = new int[][]{new int[]{1, 3}, new int[]{-2, 2}};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.kClosest(points, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[-2,2]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "points = [[3,3],[5,-1],[-2,4]], k = 2");
        try {
            int[][] points = new int[][]{new int[]{3, 3}, new int[]{5, -1}, new int[]{-2, 4}};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.kClosest(points, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[3,3],[-2,4]]");
        System.out.println();
    }
}
