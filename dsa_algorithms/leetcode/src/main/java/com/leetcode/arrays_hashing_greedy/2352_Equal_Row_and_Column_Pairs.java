package com.leetcode.arrays_hashing_greedy;

class Solution2352 {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int ok = 1;
                for (int k = 0; k < n; ++k) {
                    if (grid[i][k] != grid[k][j]) {
                        ok = 0;
                        break;
                    }
                }
                ans += ok;
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
        Solution2352 _tcSol = new Solution2352();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[3,2,1],[1,7,6],[2,7,7]]");
        try {
            int[][] grid = new int[][]{new int[]{3, 2, 1}, new int[]{1, 7, 6}, new int[]{2, 7, 7}};
            System.out.println("  Output  : " + _tcShow(_tcSol.equalPairs(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]");
        try {
            int[][] grid = new int[][]{new int[]{3, 1, 2, 2}, new int[]{1, 4, 4, 5}, new int[]{2, 4, 2, 2}, new int[]{2, 4, 2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.equalPairs(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}