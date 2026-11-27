package com.leetcode.matrices_grids;

class Solution2387 {
    private int[][] grid;

    public int matrixMedian(int[][] grid) {
        this.grid = grid;
        int m = grid.length, n = grid[0].length;
        int target = (m * n + 1) >> 1;
        int left = 0, right = 1000010;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (count(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int count(int x) {
        int cnt = 0;
        for (var row : grid) {
            int left = 0, right = row.length;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (row[mid] > x) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            cnt += left;
        }
        return cnt;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2387 _tcSol = new Solution2387();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,1,2],[2,3,3],[1,3,4]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 2}, new int[]{2, 3, 3}, new int[]{1, 3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.matrixMedian(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,1,3,3,4]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 3, 3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.matrixMedian(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}