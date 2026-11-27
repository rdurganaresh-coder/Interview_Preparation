package com.leetcode.graphs_shortest_path;

class UnionFind1579 {
    private int[] p;
    private int[] size;
    public int cnt;

    public UnionFind1579(int n) {
        p = new int[n];
        size = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
            size[i] = 1;
        }
        cnt = n;
    }

    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public boolean union(int a, int b) {
        int pa = find(a - 1), pb = find(b - 1);
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
        --cnt;
        return true;
    }
}

class Solution1579 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind1579 ufa = new UnionFind1579(n);
        UnionFind1579 ufb = new UnionFind1579(n);
        int ans = 0;
        for (var e : edges) {
            int t = e[0], u = e[1], v = e[2];
            if (t == 3) {
                if (ufa.union(u, v)) {
                    ufb.union(u, v);
                } else {
                    ++ans;
                }
            }
        }
        for (var e : edges) {
            int t = e[0], u = e[1], v = e[2];
            if (t == 1 && !ufa.union(u, v)) {
                ++ans;
            }
            if (t == 2 && !ufb.union(u, v)) {
                ++ans;
            }
        }
        return ufa.cnt == 1 && ufb.cnt == 1 ? ans : -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1579 _tcSol = new Solution1579();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]");
        try {
            int n = 4;
            int[][] edges = new int[][]{new int[]{3, 1, 2}, new int[]{3, 2, 3}, new int[]{1, 1, 3}, new int[]{1, 2, 4}, new int[]{1, 1, 2}, new int[]{2, 3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNumEdgesToRemove(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, edges = [[3,1,2],[3,2,3],[1,1,4],[2,1,4]]");
        try {
            int n = 4;
            int[][] edges = new int[][]{new int[]{3, 1, 2}, new int[]{3, 2, 3}, new int[]{1, 1, 4}, new int[]{2, 1, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNumEdgesToRemove(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 4, edges = [[3,2,3],[1,1,2],[2,3,4]]");
        try {
            int n = 4;
            int[][] edges = new int[][]{new int[]{3, 2, 3}, new int[]{1, 1, 2}, new int[]{2, 3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNumEdgesToRemove(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}