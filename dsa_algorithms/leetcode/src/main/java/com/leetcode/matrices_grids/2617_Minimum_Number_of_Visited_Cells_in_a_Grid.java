package com.leetcode.matrices_grids;

class Solution2617 {
    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        PriorityQueue<int[]>[] row = new PriorityQueue[m];
        PriorityQueue<int[]>[] col = new PriorityQueue[n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(dist[i], -1);
            row[i] = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        }
        for (int i = 0; i < n; ++i) {
            col[i] = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        }
        dist[0][0] = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                while (!row[i].isEmpty() && grid[i][row[i].peek()[1]] + row[i].peek()[1] < j) {
                    row[i].poll();
                }
                if (!row[i].isEmpty() && (dist[i][j] == -1 || row[i].peek()[0] + 1 < dist[i][j])) {
                    dist[i][j] = row[i].peek()[0] + 1;
                }
                while (!col[j].isEmpty() && grid[col[j].peek()[1]][j] + col[j].peek()[1] < i) {
                    col[j].poll();
                }
                if (!col[j].isEmpty() && (dist[i][j] == -1 || col[j].peek()[0] + 1 < dist[i][j])) {
                    dist[i][j] = col[j].peek()[0] + 1;
                }
                if (dist[i][j] != -1) {
                    row[i].offer(new int[] {dist[i][j], j});
                    col[j].offer(new int[] {dist[i][j], i});
                }
            }
        }
        return dist[m - 1][n - 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2617 _tcSol = new Solution2617();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[3,4,2,1],[4,2,3,1],[2,1,0,0],[2,4,0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{3, 4, 2, 1}, new int[]{4, 2, 3, 1}, new int[]{2, 1, 0, 0}, new int[]{2, 4, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumVisitedCells(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[3,4,2,1],[4,2,1,1],[2,1,1,0],[3,4,1,0]]");
        try {
            int[][] grid = new int[][]{new int[]{3, 4, 2, 1}, new int[]{4, 2, 1, 1}, new int[]{2, 1, 1, 0}, new int[]{3, 4, 1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumVisitedCells(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[2,1,0],[1,0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{2, 1, 0}, new int[]{1, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumVisitedCells(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}