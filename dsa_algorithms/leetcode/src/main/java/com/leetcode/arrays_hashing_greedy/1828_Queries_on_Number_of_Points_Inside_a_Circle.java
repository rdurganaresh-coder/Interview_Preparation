package com.leetcode.arrays_hashing_greedy;

class Solution1828 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int m = queries.length;
        int[] ans = new int[m];
        for (int k = 0; k < m; ++k) {
            int x = queries[k][0], y = queries[k][1], r = queries[k][2];
            for (var p : points) {
                int i = p[0], j = p[1];
                int dx = i - x, dy = j - y;
                if (dx * dx + dy * dy <= r * r) {
                    ++ans[k];
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
        Solution1828 _tcSol = new Solution1828();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]");
        try {
            int[][] points = new int[][]{new int[]{1, 3}, new int[]{3, 3}, new int[]{5, 3}, new int[]{2, 2}};
            int[][] queries = new int[][]{new int[]{2, 3, 1}, new int[]{4, 3, 1}, new int[]{1, 1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPoints(points, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,2,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "points = [[1,1],[2,2],[3,3],[4,4],[5,5]], queries = [[1,2,2],[2,2,2],[4,3,2],[4,3,3]]");
        try {
            int[][] points = new int[][]{new int[]{1, 1}, new int[]{2, 2}, new int[]{3, 3}, new int[]{4, 4}, new int[]{5, 5}};
            int[][] queries = new int[][]{new int[]{1, 2, 2}, new int[]{2, 2, 2}, new int[]{4, 3, 2}, new int[]{4, 3, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPoints(points, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3,2,4]");
        System.out.println();
    }
}