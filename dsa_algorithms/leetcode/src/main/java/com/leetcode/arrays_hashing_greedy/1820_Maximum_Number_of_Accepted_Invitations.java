package com.leetcode.arrays_hashing_greedy;

class Solution1820 {
    private int[][] grid;
    private boolean[] vis;
    private int[] match;
    private int n;

    public int maximumInvitations(int[][] grid) {
        int m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        vis = new boolean[n];
        match = new int[n];
        Arrays.fill(match, -1);
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            Arrays.fill(vis, false);
            if (find(i)) {
                ++ans;
            }
        }
        return ans;
    }

    private boolean find(int i) {
        for (int j = 0; j < n; ++j) {
            if (grid[i][j] == 1 && !vis[j]) {
                vis[j] = true;
                if (match[j] == -1 || find(match[j])) {
                    match[j] = i;
                    return true;
                }
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1820 _tcSol = new Solution1820();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,1,1], [1,0,1], [0,0,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 1}, new int[]{1, 0, 1}, new int[]{0, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumInvitations(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,0,1,0], [1,0,0,0], [0,0,1,0], [1,1,1,0]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 0, 1, 0}, new int[]{1, 0, 0, 0}, new int[]{0, 0, 1, 0}, new int[]{1, 1, 1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumInvitations(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}