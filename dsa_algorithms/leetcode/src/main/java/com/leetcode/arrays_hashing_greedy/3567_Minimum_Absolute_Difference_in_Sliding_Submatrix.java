package com.leetcode.arrays_hashing_greedy;

class Solution3567 {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];
        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                List<Integer> nums = new ArrayList<>();
                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        nums.add(grid[x][y]);
                    }
                }
                Collections.sort(nums);
                int d = Integer.MAX_VALUE;
                for (int t = 1; t < nums.size(); t++) {
                    int a = nums.get(t - 1);
                    int b = nums.get(t);
                    if (a != b) {
                        d = Math.min(d, Math.abs(a - b));
                    }
                }
                ans[i][j] = (d == Integer.MAX_VALUE) ? 0 : d;
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
        Solution3567 _tcSol = new Solution3567();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,8],[3,-2]], k = 2");
        try {
            int[][] grid = new int[][]{new int[]{1, 8}, new int[]{3, -2}};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minAbsDiff(grid, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[2]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[3,-1]], k = 1");
        try {
            int[][] grid = new int[][]{new int[]{3, -1}};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minAbsDiff(grid, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,0]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1,-2,3],[2,3,5]], k = 2");
        try {
            int[][] grid = new int[][]{new int[]{1, -2, 3}, new int[]{2, 3, 5}};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minAbsDiff(grid, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,2]]");
        System.out.println();
    }
}
