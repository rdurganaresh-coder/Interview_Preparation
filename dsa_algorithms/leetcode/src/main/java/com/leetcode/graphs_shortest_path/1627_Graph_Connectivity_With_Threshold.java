package com.leetcode.graphs_shortest_path;

class UnionFind1627 {
    private int[] p;
    private int[] size;

    public UnionFind1627(int n) {
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

class Solution1627 {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        UnionFind1627 uf = new UnionFind1627(n + 1);
        for (int a = threshold + 1; a <= n; ++a) {
            for (int b = a + a; b <= n; b += a) {
                uf.union(a, b);
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (var q : queries) {
            ans.add(uf.find(q[0]) == uf.find(q[1]));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1627 _tcSol = new Solution1627();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 6, threshold = 2, queries = [[1,4],[2,5],[3,6]]");
        try {
            int n = 6;
            int threshold = 2;
            int[][] queries = new int[][]{new int[]{1, 4}, new int[]{2, 5}, new int[]{3, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.areConnected(n, threshold, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[false,false,true]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 6, threshold = 0, queries = [[4,5],[3,4],[3,2],[2,6],[1,3]]");
        try {
            int n = 6;
            int threshold = 0;
            int[][] queries = new int[][]{new int[]{4, 5}, new int[]{3, 4}, new int[]{3, 2}, new int[]{2, 6}, new int[]{1, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.areConnected(n, threshold, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[true,true,true,true,true]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 5, threshold = 1, queries = [[4,5],[4,5],[3,2],[2,3],[3,4]]");
        try {
            int n = 5;
            int threshold = 1;
            int[][] queries = new int[][]{new int[]{4, 5}, new int[]{4, 5}, new int[]{3, 2}, new int[]{2, 3}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.areConnected(n, threshold, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[false,false,false,false,false]");
        System.out.println();
    }
}