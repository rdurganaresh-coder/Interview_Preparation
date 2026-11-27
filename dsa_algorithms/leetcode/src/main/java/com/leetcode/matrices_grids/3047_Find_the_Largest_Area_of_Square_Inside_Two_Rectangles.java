package com.leetcode.matrices_grids;

class Solution3047 {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long ans = 0;
        for (int i = 0; i < bottomLeft.length; ++i) {
            int x1 = bottomLeft[i][0], y1 = bottomLeft[i][1];
            int x2 = topRight[i][0], y2 = topRight[i][1];
            for (int j = i + 1; j < bottomLeft.length; ++j) {
                int x3 = bottomLeft[j][0], y3 = bottomLeft[j][1];
                int x4 = topRight[j][0], y4 = topRight[j][1];
                int w = Math.min(x2, x4) - Math.max(x1, x3);
                int h = Math.min(y2, y4) - Math.max(y1, y3);
                int e = Math.min(w, h);
                if (e > 0) {
                    ans = Math.max(ans, 1L * e * e);
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
        Solution3047 _tcSol = new Solution3047();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "bottomLeft = [[1,1],[2,2],[3,1]], topRight = [[3,3],[4,4],[6,6]]");
        try {
            int[][] bottomLeft = new int[][]{new int[]{1, 1}, new int[]{2, 2}, new int[]{3, 1}};
            int[][] topRight = new int[][]{new int[]{3, 3}, new int[]{4, 4}, new int[]{6, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestSquareArea(bottomLeft, topRight)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "bottomLeft = [[1,1],[1,3],[1,5]], topRight = [[5,5],[5,7],[5,9]]");
        try {
            int[][] bottomLeft = new int[][]{new int[]{1, 1}, new int[]{1, 3}, new int[]{1, 5}};
            int[][] topRight = new int[][]{new int[]{5, 5}, new int[]{5, 7}, new int[]{5, 9}};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestSquareArea(bottomLeft, topRight)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "bottomLeft = [[1,1],[2,2],[1,2]], topRight = [[3,3],[4,4],[3,4]]");
        try {
            int[][] bottomLeft = new int[][]{new int[]{1, 1}, new int[]{2, 2}, new int[]{1, 2}};
            int[][] topRight = new int[][]{new int[]{3, 3}, new int[]{4, 4}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestSquareArea(bottomLeft, topRight)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "bottomLeft = [[1,1],[3,3],[3,1]], topRight = [[2,2],[4,4],[4,2]]");
        try {
            int[][] bottomLeft = new int[][]{new int[]{1, 1}, new int[]{3, 3}, new int[]{3, 1}};
            int[][] topRight = new int[][]{new int[]{2, 2}, new int[]{4, 4}, new int[]{4, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestSquareArea(bottomLeft, topRight)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}