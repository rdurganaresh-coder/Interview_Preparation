package com.leetcode.matrices_grids;

class Solution0750 {
    public int countCornerRectangles(int[][] grid) {
        int n = grid[0].length;
        int ans = 0;
        Map<List<Integer>, Integer> cnt = new HashMap<>();
        for (var row : grid) {
            for (int i = 0; i < n; ++i) {
                if (row[i] == 1) {
                    for (int j = i + 1; j < n; ++j) {
                        if (row[j] == 1) {
                            List<Integer> t = List.of(i, j);
                            ans += cnt.getOrDefault(t, 0);
                            cnt.merge(t, 1, Integer::sum);
                        }
                    }
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
        Solution0750 _tcSol = new Solution0750();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,0,0,1,0],[0,0,1,0,1],[0,0,0,1,0],[1,0,1,0,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 0, 0, 1, 0}, new int[]{0, 0, 1, 0, 1}, new int[]{0, 0, 0, 1, 0}, new int[]{1, 0, 1, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countCornerRectangles(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,1,1],[1,1,1],[1,1,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 1}, new int[]{1, 1, 1}, new int[]{1, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countCornerRectangles(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1,1,1,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countCornerRectangles(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}