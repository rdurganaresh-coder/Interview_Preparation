package com.leetcode.graphs_shortest_path;

class UnionFind1971_3 {
    private int[] p;
    private int[] size;

    public UnionFind1971_3(int n) {
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
}

class Solution1971_3 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind1971_3 uf = new UnionFind1971_3(n);
        for (var e : edges) {
            uf.union(e[0], e[1]);
        }
        return uf.find(source) == uf.find(destination);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1971_3 _tcSol = new Solution1971_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2");
        try {
            int n = 3;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}};
            int source = 0;
            int destination = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.validPath(n, edges, source, destination)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5");
        try {
            int n = 6;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{3, 5}, new int[]{5, 4}, new int[]{4, 3}};
            int source = 0;
            int destination = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.validPath(n, edges, source, destination)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
