package com.leetcode.matrices_grids;

class UnionFind1632 {
    private int[] p;
    private int[] size;

    public UnionFind1632(int n) {
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

    public void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa != pb) {
            if (size[pa] > size[pb]) {
                p[pb] = pa;
                size[pa] += size[pb];
            } else {
                p[pa] = pb;
                size[pb] += size[pa];
            }
        }
    }

    public void reset(int x) {
        p[x] = x;
        size[x] = 1;
    }
}

class Solution1632 {
    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        TreeMap<Integer, List<int[]>> d = new TreeMap<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                d.computeIfAbsent(matrix[i][j], k -> new ArrayList<>()).add(new int[] {i, j});
            }
        }
        int[] rowMax = new int[m];
        int[] colMax = new int[n];
        int[][] ans = new int[m][n];
        UnionFind1632 uf = new UnionFind1632(m + n);
        int[] rank = new int[m + n];
        for (var ps : d.values()) {
            for (var p : ps) {
                uf.union(p[0], p[1] + m);
            }
            for (var p : ps) {
                int i = p[0], j = p[1];
                rank[uf.find(i)] = Math.max(rank[uf.find(i)], Math.max(rowMax[i], colMax[j]));
            }
            for (var p : ps) {
                int i = p[0], j = p[1];
                ans[i][j] = 1 + rank[uf.find(i)];
                rowMax[i] = ans[i][j];
                colMax[j] = ans[i][j];
            }
            for (var p : ps) {
                uf.reset(p[0]);
                uf.reset(p[1] + m);
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
        Solution1632 _tcSol = new Solution1632();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "matrix = [[1,2],[3,4]]");
        try {
            int[][] matrix = new int[][]{new int[]{1, 2}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.matrixRankTransform(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,2],[2,3]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "matrix = [[7,7],[7,7]]");
        try {
            int[][] matrix = new int[][]{new int[]{7, 7}, new int[]{7, 7}};
            System.out.println("  Output  : " + _tcShow(_tcSol.matrixRankTransform(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,1],[1,1]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "matrix = [[20,-21,14],[-19,4,19],[22,-47,24],[-19,4,19]]");
        try {
            int[][] matrix = new int[][]{new int[]{20, -21, 14}, new int[]{-19, 4, 19}, new int[]{22, -47, 24}, new int[]{-19, 4, 19}};
            System.out.println("  Output  : " + _tcShow(_tcSol.matrixRankTransform(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[4,2,3],[1,3,4],[5,1,6],[1,3,4]]");
        System.out.println();
    }
}