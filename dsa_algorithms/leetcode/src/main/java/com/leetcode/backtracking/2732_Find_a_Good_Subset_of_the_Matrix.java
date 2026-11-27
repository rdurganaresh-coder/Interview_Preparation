package com.leetcode.backtracking;

class Solution2732 {
    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        Map<Integer, Integer> g = new HashMap<>();
        for (int i = 0; i < grid.length; ++i) {
            int mask = 0;
            for (int j = 0; j < grid[0].length; ++j) {
                mask |= grid[i][j] << j;
            }
            if (mask == 0) {
                return List.of(i);
            }
            g.put(mask, i);
        }
        for (var e1 : g.entrySet()) {
            for (var e2 : g.entrySet()) {
                if ((e1.getKey() & e2.getKey()) == 0) {
                    int i = e1.getValue(), j = e2.getValue();
                    return List.of(Math.min(i, j), Math.max(i, j));
                }
            }
        }
        return List.of();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2732 _tcSol = new Solution2732();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[0,1,1,0],[0,0,0,1],[1,1,1,1]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 1, 1, 0}, new int[]{0, 0, 0, 1}, new int[]{1, 1, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.goodSubsetofBinaryMatrix(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[0]]");
        try {
            int[][] grid = new int[][]{new int[]{0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.goodSubsetofBinaryMatrix(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1,1,1],[1,1,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 1}, new int[]{1, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.goodSubsetofBinaryMatrix(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}