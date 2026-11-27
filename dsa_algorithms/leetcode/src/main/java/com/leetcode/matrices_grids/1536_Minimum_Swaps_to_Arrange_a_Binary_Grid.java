package com.leetcode.matrices_grids;

class Solution1536 {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] pos = new int[n];
        Arrays.fill(pos, -1);
        for (int i = 0; i < n; ++i) {
            for (int j = n - 1; j >= 0; --j) {
                if (grid[i][j] == 1) {
                    pos[i] = j;
                    break;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int k = -1;
            for (int j = i; j < n; ++j) {
                if (pos[j] <= i) {
                    ans += j - i;
                    k = j;
                    break;
                }
            }
            if (k == -1) {
                return -1;
            }
            for (; k > i; --k) {
                int t = pos[k];
                pos[k] = pos[k - 1];
                pos[k - 1] = t;
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
        Solution1536 _tcSol = new Solution1536();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[0,0,1],[1,1,0],[1,0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 0, 1}, new int[]{1, 1, 0}, new int[]{1, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minSwaps(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,1,1,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 1, 1, 0}, new int[]{0, 1, 1, 0}, new int[]{0, 1, 1, 0}, new int[]{0, 1, 1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minSwaps(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1,0,0],[1,1,0],[1,1,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 0, 0}, new int[]{1, 1, 0}, new int[]{1, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minSwaps(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}