package com.leetcode.dynamic_programming;

class Solution3548 {
    public boolean canPartitionGrid(int[][] grid) {
        return check(grid) || check(rotate(grid));
    }

    private boolean check(int[][] g) {
        int m = g.length, n = g[0].length;
        long s1 = 0, s2 = 0;

        Map<Long, Integer> cnt1 = new HashMap<>();
        Map<Long, Integer> cnt2 = new HashMap<>();

        for (int[] row : g) {
            for (int x : row) {
                s2 += x;
                cnt2.merge((long) x, 1, Integer::sum);
            }
        }

        for (int i = 0; i < m - 1; i++) {
            for (int x : g[i]) {
                s1 += x;
                s2 -= x;

                cnt1.merge((long) x, 1, Integer::sum);
                cnt2.merge((long) x, -1, Integer::sum);
            }

            if (s1 == s2) {
                return true;
            }

            if (s1 < s2) {
                long diff = s2 - s1;
                if (cnt2.getOrDefault(diff, 0) > 0) {
                    if ((m - i - 1 > 1 && n > 1)
                        || (i == m - 2 && (g[i + 1][0] == diff || g[i + 1][n - 1] == diff))
                        || (n == 1 && (g[i + 1][0] == diff || g[m - 1][0] == diff))) {
                        return true;
                    }
                }
            } else {
                long diff = s1 - s2;
                if (cnt1.getOrDefault(diff, 0) > 0) {
                    if ((i + 1 > 1 && n > 1) || (i == 0 && (g[0][0] == diff || g[0][n - 1] == diff))
                        || (n == 1 && (g[0][0] == diff || g[i][0] == diff))) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private int[][] rotate(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] t = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                t[j][i] = grid[i][j];
            }
        }
        return t;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3548 _tcSol = new Solution3548();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,4],[2,3]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 4}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.canPartitionGrid(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,2],[3,4]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 2}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.canPartitionGrid(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1,2,4],[2,3,5]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 2, 4}, new int[]{2, 3, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.canPartitionGrid(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "grid = [[4,1,8],[3,2,6]]");
        try {
            int[][] grid = new int[][]{new int[]{4, 1, 8}, new int[]{3, 2, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.canPartitionGrid(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
