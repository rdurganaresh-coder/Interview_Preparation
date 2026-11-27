package com.leetcode.arrays_hashing_greedy;

class Solution1765_2 {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] ans = new int[m][n];
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ans[i][j] = isWater[i][j] - 1;
                if (ans[i][j] == 0) {
                    q.offer(new int[] {i, j});
                }
            }
        }
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            for (int t = q.size(); t > 0; --t) {
                var p = q.poll();
                int i = p[0], j = p[1];
                for (int k = 0; k < 4; ++k) {
                    int x = i + dirs[k], y = j + dirs[k + 1];
                    if (x >= 0 && x < m && y >= 0 && y < n && ans[x][y] == -1) {
                        ans[x][y] = ans[i][j] + 1;
                        q.offer(new int[] {x, y});
                    }
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
        Solution1765_2 _tcSol = new Solution1765_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "isWater = [[0,1],[0,0]]");
        try {
            int[][] isWater = new int[][]{new int[]{0, 1}, new int[]{0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.highestPeak(isWater)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,0],[2,1]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "isWater = [[0,0,1],[1,0,0],[0,0,0]]");
        try {
            int[][] isWater = new int[][]{new int[]{0, 0, 1}, new int[]{1, 0, 0}, new int[]{0, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.highestPeak(isWater)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,1,0],[0,1,1],[1,2,2]]");
        System.out.println();
    }
}