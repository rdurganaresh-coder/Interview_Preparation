package com.leetcode.graphs_shortest_path;

class Solution1319 {
    private int[] p;

    public int makeConnected(int n, int[][] connections) {
        p = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
        int cnt = 0;
        for (int[] e : connections) {
            int pa = find(e[0]), pb = find(e[1]);
            if (pa == pb) {
                ++cnt;
            } else {
                p[pa] = pb;
                --n;
            }
        }
        return n - 1 > cnt ? -1 : n - 1;
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
        Solution1319 _tcSol = new Solution1319();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, connections = [[0,1],[0,2],[1,2]]");
        try {
            int n = 4;
            int[][] connections = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.makeConnected(n, connections)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]");
        try {
            int n = 6;
            int[][] connections = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{1, 2}, new int[]{1, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.makeConnected(n, connections)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]");
        try {
            int n = 6;
            int[][] connections = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.makeConnected(n, connections)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
