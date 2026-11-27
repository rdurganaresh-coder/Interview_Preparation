package com.leetcode.matrices_grids;

class Solution2684 {
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<Integer> q = IntStream.range(0, m).boxed().collect(Collectors.toSet());
        for (int j = 0; j < n - 1; ++j) {
            Set<Integer> t = new HashSet<>();
            for (int i : q) {
                for (int k = i - 1; k <= i + 1; ++k) {
                    if (k >= 0 && k < m && grid[i][j] < grid[k][j + 1]) {
                        t.add(k);
                    }
                }
            }
            if (t.isEmpty()) {
                return j;
            }
            q = t;
        }
        return n - 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2684 _tcSol = new Solution2684();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]");
        try {
            int[][] grid = new int[][]{new int[]{2, 4, 3, 5}, new int[]{5, 4, 9, 3}, new int[]{3, 4, 2, 11}, new int[]{10, 9, 13, 15}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxMoves(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[3,2,4],[2,1,9],[1,1,7]]");
        try {
            int[][] grid = new int[][]{new int[]{3, 2, 4}, new int[]{2, 1, 9}, new int[]{1, 1, 7}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxMoves(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}