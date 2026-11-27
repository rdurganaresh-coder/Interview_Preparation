package com.leetcode.arrays_hashing_greedy;

class Solution0684 {
    private int[] p;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        p = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
        for (int i = 0;; ++i) {
            int pa = find(edges[i][0] - 1);
            int pb = find(edges[i][1] - 1);
            if (pa == pb) {
                return edges[i];
            }
            p[pa] = pb;
        }
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0684 _tcSol = new Solution0684();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges = [[1,2],[1,3],[2,3]]");
        try {
            int[][] edges = new int[][]{new int[]{1, 2}, new int[]{1, 3}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findRedundantConnection(edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]");
        try {
            int[][] edges = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{1, 4}, new int[]{1, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findRedundantConnection(edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,4]");
        System.out.println();
    }
}
