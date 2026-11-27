package com.leetcode.arrays_hashing_greedy;

class Solution0149 {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int ans = 1;
        for (int i = 0; i < n; ++i) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = i + 1; j < n; ++j) {
                int x2 = points[j][0], y2 = points[j][1];
                int cnt = 2;
                for (int k = j + 1; k < n; ++k) {
                    int x3 = points[k][0], y3 = points[k][1];
                    int a = (y2 - y1) * (x3 - x1);
                    int b = (y3 - y1) * (x2 - x1);
                    if (a == b) {
                        ++cnt;
                    }
                }
                ans = Math.max(ans, cnt);
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
        Solution0149 _tcSol = new Solution0149();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "points = [[1,1],[2,2],[3,3]]");
        try {
            int[][] points = new int[][]{new int[]{1, 1}, new int[]{2, 2}, new int[]{3, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxPoints(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]");
        try {
            int[][] points = new int[][]{new int[]{1, 1}, new int[]{3, 2}, new int[]{5, 3}, new int[]{4, 1}, new int[]{2, 3}, new int[]{1, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxPoints(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}