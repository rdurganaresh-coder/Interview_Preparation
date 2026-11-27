package com.leetcode.graphs_shortest_path;

class Solution0864 {
    private int[] dirs = {-1, 0, 1, 0, -1};

    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        int k = 0;
        int si = 0, sj = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                char c = grid[i].charAt(j);
                if (Character.isLowerCase(c)) {
                    ++k;
                } else if (c == '@') {
                    si = i;
                    sj = j;
                }
            }
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {si, sj, 0});
        boolean[][][] vis = new boolean[m][n][1 << k];
        vis[si][sj][0] = true;
        int ans = 0;
        while (!q.isEmpty()) {
            for (int t = q.size(); t > 0; --t) {
                var p = q.poll();
                int i = p[0], j = p[1], state = p[2];
                if (state == (1 << k) - 1) {
                    return ans;
                }
                for (int h = 0; h < 4; ++h) {
                    int x = i + dirs[h], y = j + dirs[h + 1];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        char c = grid[x].charAt(y);
                        if (c == '#'
                            || (Character.isUpperCase(c) && ((state >> (c - 'A')) & 1) == 0)) {
                            continue;
                        }
                        int nxt = state;
                        if (Character.isLowerCase(c)) {
                            nxt |= 1 << (c - 'a');
                        }
                        if (!vis[x][y][nxt]) {
                            vis[x][y][nxt] = true;
                            q.offer(new int[] {x, y, nxt});
                        }
                    }
                }
            }
            ++ans;
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0864 _tcSol = new Solution0864();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [\"@.a..\",\"###.#\",\"b.A.B\"]");
        try {
            String[] grid = new String[]{"@.a..", "###.#", "b.A.B"};
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestPathAllKeys(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [\"@..aA\",\"..B#.\",\"....b\"]");
        try {
            String[] grid = new String[]{"@..aA", "..B#.", "....b"};
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestPathAllKeys(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [\"@Aa\"]");
        try {
            String[] grid = new String[]{"@Aa"};
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestPathAllKeys(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}