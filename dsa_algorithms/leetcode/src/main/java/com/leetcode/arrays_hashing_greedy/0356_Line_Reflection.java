package com.leetcode.arrays_hashing_greedy;

class Solution0356 {
    public boolean isReflected(int[][] points) {
        final int inf = 1 << 30;
        int minX = inf, maxX = -inf;
        Set<List<Integer>> pointSet = new HashSet<>();
        for (int[] p : points) {
            minX = Math.min(minX, p[0]);
            maxX = Math.max(maxX, p[0]);
            pointSet.add(List.of(p[0], p[1]));
        }
        int s = minX + maxX;
        for (int[] p : points) {
            if (!pointSet.contains(List.of(s - p[0], p[1]))) {
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
        Solution0356 _tcSol = new Solution0356();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "points = [[1,1],[-1,1]]");
        try {
            int[][] points = new int[][]{new int[]{1, 1}, new int[]{-1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.isReflected(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "points = [[1,1],[-1,-1]]");
        try {
            int[][] points = new int[][]{new int[]{1, 1}, new int[]{-1, -1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.isReflected(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}