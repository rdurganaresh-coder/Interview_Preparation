package com.leetcode.graphs_shortest_path;

class Solution2812 {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }
        Deque<int[]> q = new ArrayDeque<>();
        int[][] dist = new int[n][n];
        final int inf = 1 << 30;
        for (int[] d : dist) {
            Arrays.fill(d, inf);
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    q.offer(new int[] {i, j});
                }
            }
        }
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int i = p[0], j = p[1];
            for (int k = 0; k < 4; ++k) {
                int x = i + dirs[k], y = j + dirs[k + 1];
                if (x >= 0 && x < n && y >= 0 && y < n && dist[x][y] == inf) {
                    dist[x][y] = dist[i][j] + 1;
                    q.offer(new int[] {x, y});
                }
            }
        }
        List<int[]> t = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                t.add(new int[] {dist[i][j], i, j});
            }
        }
        t.sort((a, b) -> Integer.compare(b[0], a[0]));
        UnionFind2812 uf = new UnionFind2812(n * n);
        for (int[] p : t) {
            int d = p[0], i = p[1], j = p[2];
            for (int k = 0; k < 4; ++k) {
                int x = i + dirs[k], y = j + dirs[k + 1];
                if (x >= 0 && x < n && y >= 0 && y < n && dist[x][y] >= d) {
                    uf.union(i * n + j, x * n + y);
                }
            }
            if (uf.find(0) == uf.find(n * n - 1)) {
                return d;
            }
        }
        return 0;
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
        Solution2812 _tcSol = new Solution2812();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,0,0],[0,0,0],[0,0,1]]");
        try {
            List<List<Integer>> grid = _tcL(_tcL(1, 0, 0), _tcL(0, 0, 0), _tcL(0, 0, 1));
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSafenessFactor(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[0,0,1],[0,0,0],[0,0,0]]");
        try {
            List<List<Integer>> grid = _tcL(_tcL(0, 0, 1), _tcL(0, 0, 0), _tcL(0, 0, 0));
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSafenessFactor(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[0,0,0,1],[0,0,0,0],[0,0,0,0],[1,0,0,0]]");
        try {
            List<List<Integer>> grid = _tcL(_tcL(0, 0, 0, 1), _tcL(0, 0, 0, 0), _tcL(0, 0, 0, 0), _tcL(1, 0, 0, 0));
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSafenessFactor(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}

class UnionFind2812 {
    public int[] p;
    public int n;

    public UnionFind2812(int n) {
        p = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
        this.n = n;
    }

    public boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) {
            return false;
        }
        p[pa] = pb;
        --n;
        return true;
    }

    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}