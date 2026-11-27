package com.leetcode.arrays_hashing_greedy;

class Solution3402 {
    public int minimumOperations(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int j = 0; j < n; ++j) {
            int pre = -1;
            for (int i = 0; i < m; ++i) {
                int cur = grid[i][j];
                if (pre < cur) {
                    pre = cur;
                } else {
                    ++pre;
                    ans += pre - cur;
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
        Solution3402 _tcSol = new Solution3402();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[3,2],[1,3],[3,4],[0,1]]");
        try {
            int[][] grid = new int[][]{new int[]{3, 2}, new int[]{1, 3}, new int[]{3, 4}, new int[]{0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperations(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[3,2,1],[2,1,0],[1,2,3]]");
        try {
            int[][] grid = new int[][]{new int[]{3, 2, 1}, new int[]{2, 1, 0}, new int[]{1, 2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperations(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();
    }
}
