package com.leetcode.sliding_window_two_pointers;

class Solution0417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] vis1 = new boolean[m][n];
        boolean[][] vis2 = new boolean[m][n];
        Deque<int[]> q1 = new ArrayDeque<>();
        Deque<int[]> q2 = new ArrayDeque<>();
        int[] dirs = {-1, 0, 1, 0, -1};

        for (int i = 0; i < m; ++i) {
            q1.offer(new int[] {i, 0});
            vis1[i][0] = true;
            q2.offer(new int[] {i, n - 1});
            vis2[i][n - 1] = true;
        }
        for (int j = 0; j < n; ++j) {
            q1.offer(new int[] {0, j});
            vis1[0][j] = true;
            q2.offer(new int[] {m - 1, j});
            vis2[m - 1][j] = true;
        }

        BiConsumer<Deque<int[]>, boolean[][]> bfs = (q, vis) -> {
            while (!q.isEmpty()) {
                var cell = q.poll();
                int x = cell[0], y = cell[1];
                for (int k = 0; k < 4; ++k) {
                    int nx = x + dirs[k], ny = y + dirs[k + 1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !vis[nx][ny]
                        && heights[nx][ny] >= heights[x][y]) {
                        vis[nx][ny] = true;
                        q.offer(new int[] {nx, ny});
                    }
                }
            }
        };

        bfs.accept(q1, vis1);
        bfs.accept(q2, vis2);

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (vis1[i][j] && vis2[i][j]) {
                    ans.add(List.of(i, j));
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
        Solution0417 _tcSol = new Solution0417();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]");
        try {
            int[][] heights = new int[][]{new int[]{1, 2, 2, 3, 5}, new int[]{3, 2, 3, 4, 4}, new int[]{2, 4, 5, 3, 1}, new int[]{6, 7, 1, 4, 5}, new int[]{5, 1, 1, 2, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.pacificAtlantic(heights)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "heights = [[1]]");
        try {
            int[][] heights = new int[][]{new int[]{1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.pacificAtlantic(heights)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,0]]");
        System.out.println();
    }
}
