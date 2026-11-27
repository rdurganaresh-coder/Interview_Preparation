package com.leetcode.arrays_hashing_greedy;

class UnionFind1970_2 {
    private final int[] p;
    private final int[] size;

    public UnionFind1970_2(int n) {
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
}

class Solution1970_2 {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int mn = cells.length;
        UnionFind1970_2 uf = new UnionFind1970_2(mn + 2);
        int s = mn, t = mn + 1;
        int[][] g = new int[row][col];
        for (var e : g) {
            Arrays.fill(e, 1);
        }
        final int[] dirs = {-1, 0, 1, 0, -1};
        for (int i = mn - 1;; --i) {
            int x = cells[i][0] - 1, y = cells[i][1] - 1;
            g[x][y] = 0;
            for (int j = 0; j < 4; ++j) {
                int nx = x + dirs[j], ny = y + dirs[j + 1];
                if (nx >= 0 && nx < row && ny >= 0 && ny < col && g[nx][ny] == 0) {
                    uf.union(x * col + y, nx * col + ny);
                }
            }
            if (x == 0) {
                uf.union(s, x * col + y);
            }
            if (x == row - 1) {
                uf.union(t, x * col + y);
            }
            if (uf.find(s) == uf.find(t)) {
                return i;
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1970_2 _tcSol = new Solution1970_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "row = 2, col = 2, cells = [[1,1],[2,1],[1,2],[2,2]]");
        try {
            int row = 2;
            int col = 2;
            int[][] cells = new int[][]{new int[]{1, 1}, new int[]{2, 1}, new int[]{1, 2}, new int[]{2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.latestDayToCross(row, col, cells)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "row = 2, col = 2, cells = [[1,1],[1,2],[2,1],[2,2]]");
        try {
            int row = 2;
            int col = 2;
            int[][] cells = new int[][]{new int[]{1, 1}, new int[]{1, 2}, new int[]{2, 1}, new int[]{2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.latestDayToCross(row, col, cells)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "row = 3, col = 3, cells = [[1,2],[2,1],[3,3],[2,2],[1,1],[1,3],[2,3],[3,2],[3,1]]");
        try {
            int row = 3;
            int col = 3;
            int[][] cells = new int[][]{new int[]{1, 2}, new int[]{2, 1}, new int[]{3, 3}, new int[]{2, 2}, new int[]{1, 1}, new int[]{1, 3}, new int[]{2, 3}, new int[]{3, 2}, new int[]{3, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.latestDayToCross(row, col, cells)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
