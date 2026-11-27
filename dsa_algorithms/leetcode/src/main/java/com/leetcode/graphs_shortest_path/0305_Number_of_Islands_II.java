package com.leetcode.graphs_shortest_path;

class UnionFind0305 {
    private final int[] p;
    private final int[] size;

    public UnionFind0305(int n) {
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

class Solution0305 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] grid = new int[m][n];
        UnionFind0305 uf = new UnionFind0305(m * n);
        int[] dirs = {-1, 0, 1, 0, -1};
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();
        for (var p : positions) {
            int i = p[0], j = p[1];
            if (grid[i][j] == 1) {
                ans.add(cnt);
                continue;
            }
            grid[i][j] = 1;
            ++cnt;
            for (int k = 0; k < 4; ++k) {
                int x = i + dirs[k], y = j + dirs[k + 1];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1
                    && uf.union(i * n + j, x * n + y)) {
                    --cnt;
                }
            }
            ans.add(cnt);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0305 _tcSol = new Solution0305();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "m = 3, n = 3, positions = [[0,0],[0,1],[1,2],[2,1]]");
        try {
            int m = 3;
            int n = 3;
            int[][] positions = new int[][]{new int[]{0, 0}, new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numIslands2(m, n, positions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1,2,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "m = 1, n = 1, positions = [[0,0]]");
        try {
            int m = 1;
            int n = 1;
            int[][] positions = new int[][]{new int[]{0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numIslands2(m, n, positions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1]");
        System.out.println();
    }
}