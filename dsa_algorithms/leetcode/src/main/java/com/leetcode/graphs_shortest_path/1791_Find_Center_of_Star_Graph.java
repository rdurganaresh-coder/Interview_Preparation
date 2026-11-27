package com.leetcode.graphs_shortest_path;

class Solution1791 {
    public int findCenter(int[][] edges) {
        int a = edges[0][0], b = edges[0][1];
        int c = edges[1][0], d = edges[1][1];
        return a == c || a == d ? a : b;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1791 _tcSol = new Solution1791();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges = [[1,2],[2,3],[4,2]]");
        try {
            int[][] edges = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{4, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findCenter(edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges = [[1,2],[5,1],[1,3],[1,4]]");
        try {
            int[][] edges = new int[][]{new int[]{1, 2}, new int[]{5, 1}, new int[]{1, 3}, new int[]{1, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findCenter(edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}