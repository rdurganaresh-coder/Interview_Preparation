package com.leetcode.arrays_hashing_greedy;

class Solution2814 {
    public int minimumSeconds(List<List<String>> land) {
        int m = land.size(), n = land.get(0).size();
        boolean[][] vis = new boolean[m][n];
        int[][] g = new int[m][n];
        Deque<int[]> q = new ArrayDeque<>();
        int si = 0, sj = 0;
        for (int i = 0; i < m; ++i) {
            Arrays.fill(g[i], 1 << 30);
            for (int j = 0; j < n; ++j) {
                String c = land.get(i).get(j);
                if ("*".equals(c)) {
                    q.offer(new int[] {i, j});
                } else if ("S".equals(c)) {
                    si = i;
                    sj = j;
                }
            }
        }
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int t = 0; !q.isEmpty(); ++t) {
            for (int k = q.size(); k > 0; --k) {
                int[] p = q.poll();
                int i = p[0], j = p[1];
                g[i][j] = t;
                for (int d = 0; d < 4; ++d) {
                    int x = i + dirs[d], y = j + dirs[d + 1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y]) {
                        boolean empty = ".".equals(land.get(x).get(y));
                        boolean start = "S".equals(land.get(x).get(y));
                        if (empty || start) {
                            vis[x][y] = true;
                            q.offer(new int[] {x, y});
                        }
                    }
                }
            }
        }
        q.offer(new int[] {si, sj});
        vis = new boolean[m][n];
        vis[si][sj] = true;
        for (int t = 0; !q.isEmpty(); ++t) {
            for (int k = q.size(); k > 0; --k) {
                int[] p = q.poll();
                int i = p[0], j = p[1];
                if ("D".equals(land.get(i).get(j))) {
                    return t;
                }
                for (int d = 0; d < 4; ++d) {
                    int x = i + dirs[d], y = j + dirs[d + 1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && g[x][y] > t + 1) {
                        boolean empty = ".".equals(land.get(x).get(y));
                        boolean dest = "D".equals(land.get(x).get(y));
                        if (empty || dest) {
                            vis[x][y] = true;
                            q.offer(new int[] {x, y});
                        }
                    }
                }
            }
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution2814 _tcSol = new Solution2814();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "land = [[\"D\",\".\",\"*\"],[\".\",\".\",\".\"],[\".\",\"S\",\".\"]]");
        try {
            List<List<String>> land = _tcL(_tcL("D", ".", "*"), _tcL(".", ".", "."), _tcL(".", "S", "."));
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSeconds(land)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "land = [[\"D\",\"X\",\"*\"],[\".\",\".\",\".\"],[\".\",\".\",\"S\"]]");
        try {
            List<List<String>> land = _tcL(_tcL("D", "X", "*"), _tcL(".", ".", "."), _tcL(".", ".", "S"));
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSeconds(land)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "land = [[\"D\",\".\",\".\",\".\",\"*\",\".\"],[\".\",\"X\",\".\",\"X\",\".\",\".\"],[\".\",\".\",\".\",\".\",\"S\",\".\"]]");
        try {
            List<List<String>> land = _tcL(_tcL("D", ".", ".", ".", "*", "."), _tcL(".", "X", ".", "X", ".", "."), _tcL(".", ".", ".", ".", "S", "."));
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSeconds(land)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}