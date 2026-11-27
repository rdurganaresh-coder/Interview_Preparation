package com.leetcode.dynamic_programming;

class Solution3025 {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int ans = 0;
        int n = points.length;
        final int inf = 1 << 30;
        for (int i = 0; i < n; ++i) {
            int y1 = points[i][1];
            int maxY = -inf;
            for (int j = i + 1; j < n; ++j) {
                int y2 = points[j][1];
                if (maxY < y2 && y2 <= y1) {
                    maxY = y2;
                    ++ans;
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
        Solution3025 _tcSol = new Solution3025();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "points = [[1,1],[2,2],[3,3]]");
        try {
            int[][] points = new int[][]{new int[]{1, 1}, new int[]{2, 2}, new int[]{3, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfPairs(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "points = [[6,2],[4,4],[2,6]]");
        try {
            int[][] points = new int[][]{new int[]{6, 2}, new int[]{4, 4}, new int[]{2, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfPairs(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "points = [[3,1],[1,3],[1,1]]");
        try {
            int[][] points = new int[][]{new int[]{3, 1}, new int[]{1, 3}, new int[]{1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfPairs(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}