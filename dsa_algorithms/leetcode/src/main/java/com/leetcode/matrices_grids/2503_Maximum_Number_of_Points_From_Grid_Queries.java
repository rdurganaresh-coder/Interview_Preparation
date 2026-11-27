package com.leetcode.matrices_grids;

class Solution2503 {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int k = queries.length;
        int[][] qs = new int[k][2];
        for (int i = 0; i < k; ++i) {
            qs[i] = new int[] {queries[i], i};
        }
        Arrays.sort(qs, (a, b) -> a[0] - b[0]);
        int[] ans = new int[k];
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        vis[0][0] = true;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.offer(new int[] {grid[0][0], 0, 0});
        int[] dirs = new int[] {-1, 0, 1, 0, -1};
        int cnt = 0;
        for (var e : qs) {
            int v = e[0];
            k = e[1];
            while (!q.isEmpty() && q.peek()[0] < v) {
                var p = q.poll();
                ++cnt;
                for (int h = 0; h < 4; ++h) {
                    int x = p[1] + dirs[h], y = p[2] + dirs[h + 1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y]) {
                        vis[x][y] = true;
                        q.offer(new int[] {grid[x][y], x, y});
                    }
                }
            }
            ans[k] = cnt;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2503 _tcSol = new Solution2503();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,2,3],[2,5,7],[3,5,1]], queries = [5,6,2]");
        try {
            int[][] grid = new int[][]{new int[]{1, 2, 3}, new int[]{2, 5, 7}, new int[]{3, 5, 1}};
            int[] queries = new int[]{5, 6, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxPoints(grid, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,8,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[5,2,1],[1,1,2]], queries = [3]");
        try {
            int[][] grid = new int[][]{new int[]{5, 2, 1}, new int[]{1, 1, 2}};
            int[] queries = new int[]{3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxPoints(grid, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0]");
        System.out.println();
    }
}