package com.leetcode.graphs_shortest_path;

class UnionFind1631 {
    private final int[] p;
    private final int[] size;

    public UnionFind1631(int n) {
        p = new int[n];
        size = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public boolean union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) {
            return false;
        }
        if (size[pa] > size[pb]) {
            p[pb] = pa;
            size[pa] += size[pb];
        } else {
            p[pa] = pb;
            size[pb] += size[pa];
        }
        return true;
    }

    public boolean connected(int a, int b) {
        return find(a) == find(b);
    }
}

class Solution1631 {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        UnionFind1631 uf = new UnionFind1631(m * n);
        List<int[]> edges = new ArrayList<>();
        int[] dirs = {1, 0, 1};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < 2; ++k) {
                    int x = i + dirs[k], y = j + dirs[k + 1];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        int d = Math.abs(heights[i][j] - heights[x][y]);
                        edges.add(new int[] {d, i * n + j, x * n + y});
                    }
                }
            }
        }
        Collections.sort(edges, (a, b) -> a[0] - b[0]);
        for (int[] e : edges) {
            uf.union(e[1], e[2]);
            if (uf.connected(0, m * n - 1)) {
                return e[0];
            }
        }
        return 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1631 _tcSol = new Solution1631();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "heights = [[1,2,2],[3,8,2],[5,3,5]]");
        try {
            int[][] heights = new int[][]{new int[]{1, 2, 2}, new int[]{3, 8, 2}, new int[]{5, 3, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumEffortPath(heights)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "heights = [[1,2,3],[3,8,4],[5,3,5]]");
        try {
            int[][] heights = new int[][]{new int[]{1, 2, 3}, new int[]{3, 8, 4}, new int[]{5, 3, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumEffortPath(heights)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]");
        try {
            int[][] heights = new int[][]{new int[]{1, 2, 1, 1, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 1, 2, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumEffortPath(heights)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}