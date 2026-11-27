package com.leetcode.matrices_grids;

class Solution2371 {
    public int[][] minScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<int[]> nums = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                nums.add(new int[] {grid[i][j], i, j});
            }
        }
        Collections.sort(nums, (a, b) -> a[0] - b[0]);
        int[] rowMax = new int[m];
        int[] colMax = new int[n];
        int[][] ans = new int[m][n];
        for (int[] num : nums) {
            int i = num[1], j = num[2];
            ans[i][j] = Math.max(rowMax[i], colMax[j]) + 1;
            rowMax[i] = ans[i][j];
            colMax[j] = ans[i][j];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2371 _tcSol = new Solution2371();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[3,1],[2,5]]");
        try {
            int[][] grid = new int[][]{new int[]{3, 1}, new int[]{2, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minScore(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[2,1],[1,2]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[10]]");
        try {
            int[][] grid = new int[][]{new int[]{10}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minScore(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1]]");
        System.out.println();
    }
}