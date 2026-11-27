package com.leetcode.graphs_shortest_path;

class Solution1129 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[][] g = new List[2][n];
        for (var f : g) {
            Arrays.setAll(f, k -> new ArrayList<>());
        }
        for (var e : redEdges) {
            g[0][e[0]].add(e[1]);
        }
        for (var e : blueEdges) {
            g[1][e[0]].add(e[1]);
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});
        q.offer(new int[] {0, 1});
        boolean[][] vis = new boolean[n][2];
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        int d = 0;
        while (!q.isEmpty()) {
            for (int k = q.size(); k > 0; --k) {
                var p = q.poll();
                int i = p[0], c = p[1];
                if (ans[i] == -1) {
                    ans[i] = d;
                }
                vis[i][c] = true;
                c ^= 1;
                for (int j : g[c][i]) {
                    if (!vis[j][c]) {
                        q.offer(new int[] {j, c});
                    }
                }
            }
            ++d;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1129 _tcSol = new Solution1129();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, redEdges = [[0,1],[1,2]], blueEdges = []");
        try {
            int n = 3;
            int[][] redEdges = new int[][]{new int[]{0, 1}, new int[]{1, 2}};
            int[][] blueEdges = new int[][]{};
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestAlternatingPaths(n, redEdges, blueEdges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,-1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, redEdges = [[0,1]], blueEdges = [[2,1]]");
        try {
            int n = 3;
            int[][] redEdges = new int[][]{new int[]{0, 1}};
            int[][] blueEdges = new int[][]{new int[]{2, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestAlternatingPaths(n, redEdges, blueEdges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,-1]");
        System.out.println();
    }
}