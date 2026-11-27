package com.leetcode.arrays_hashing_greedy;

class Solution1637 {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int ans = 0;
        for (int i = 0; i < points.length - 1; ++i) {
            ans = Math.max(ans, points[i + 1][0] - points[i][0]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1637 _tcSol = new Solution1637();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "points = [[8,7],[9,9],[7,4],[9,7]]");
        try {
            int[][] points = new int[][]{new int[]{8, 7}, new int[]{9, 9}, new int[]{7, 4}, new int[]{9, 7}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxWidthOfVerticalArea(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]");
        try {
            int[][] points = new int[][]{new int[]{3, 1}, new int[]{9, 0}, new int[]{1, 0}, new int[]{1, 4}, new int[]{5, 3}, new int[]{8, 8}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxWidthOfVerticalArea(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}