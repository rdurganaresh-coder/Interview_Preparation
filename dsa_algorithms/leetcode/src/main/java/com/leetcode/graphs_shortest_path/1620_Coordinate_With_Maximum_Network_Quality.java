package com.leetcode.graphs_shortest_path;

class Solution1620 {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int mx = 0;
        int[] ans = new int[] {0, 0};
        for (int i = 0; i < 51; ++i) {
            for (int j = 0; j < 51; ++j) {
                int t = 0;
                for (var e : towers) {
                    double d = Math.sqrt((i - e[0]) * (i - e[0]) + (j - e[1]) * (j - e[1]));
                    if (d <= radius) {
                        t += Math.floor(e[2] / (1 + d));
                    }
                }
                if (mx < t) {
                    mx = t;
                    ans = new int[] {i, j};
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
        Solution1620 _tcSol = new Solution1620();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "towers = [[1,2,5],[2,1,7],[3,1,9]], radius = 2");
        try {
            int[][] towers = new int[][]{new int[]{1, 2, 5}, new int[]{2, 1, 7}, new int[]{3, 1, 9}};
            int radius = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.bestCoordinate(towers, radius)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "towers = [[23,11,21]], radius = 9");
        try {
            int[][] towers = new int[][]{new int[]{23, 11, 21}};
            int radius = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.bestCoordinate(towers, radius)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[23,11]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "towers = [[1,2,13],[2,1,7],[0,1,9]], radius = 2");
        try {
            int[][] towers = new int[][]{new int[]{1, 2, 13}, new int[]{2, 1, 7}, new int[]{0, 1, 9}};
            int radius = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.bestCoordinate(towers, radius)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2]");
        System.out.println();
    }
}