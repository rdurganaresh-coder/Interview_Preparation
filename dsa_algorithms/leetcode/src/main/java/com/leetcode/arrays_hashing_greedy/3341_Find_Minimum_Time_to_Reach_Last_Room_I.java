package com.leetcode.arrays_hashing_greedy;

class Solution3341 {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] dist = new int[n][m];
        for (var row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] {0, 0, 0});
        int[] dirs = {-1, 0, 1, 0, -1};
        while (true) {
            int[] p = pq.poll();
            int d = p[0], i = p[1], j = p[2];

            if (i == n - 1 && j == m - 1) {
                return d;
            }
            if (d > dist[i][j]) {
                continue;
            }

            for (int k = 0; k < 4; k++) {
                int x = i + dirs[k];
                int y = j + dirs[k + 1];
                if (x >= 0 && x < n && y >= 0 && y < m) {
                    int t = Math.max(moveTime[x][y], dist[i][j]) + 1;
                    if (dist[x][y] > t) {
                        dist[x][y] = t;
                        pq.offer(new int[] {t, x, y});
                    }
                }
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3341 _tcSol = new Solution3341();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "moveTime = [[0,4],[4,4]]");
        try {
            int[][] moveTime = new int[][]{new int[]{0, 4}, new int[]{4, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minTimeToReach(moveTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "moveTime = [[0,0,0],[0,0,0]]");
        try {
            int[][] moveTime = new int[][]{new int[]{0, 0, 0}, new int[]{0, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minTimeToReach(moveTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "moveTime = [[0,1],[1,2]]");
        try {
            int[][] moveTime = new int[][]{new int[]{0, 1}, new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minTimeToReach(moveTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
