package com.leetcode.graphs_shortest_path;

class Solution1462 {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] f = new boolean[n][n];
        for (var p : prerequisites) {
            f[p[0]][p[1]] = true;
        }
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    f[i][j] |= f[i][k] && f[k][j];
                }
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (var q : queries) {
            ans.add(f[q[0]][q[1]]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1462 _tcSol = new Solution1462();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "numCourses = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]");
        try {
            int n = 2;
            int[][] prerequisites = new int[][]{new int[]{1, 0}};
            int[][] queries = new int[][]{new int[]{0, 1}, new int[]{1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkIfPrerequisite(n, prerequisites, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[false,true]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "numCourses = 2, prerequisites = [], queries = [[1,0],[0,1]]");
        try {
            int n = 2;
            int[][] prerequisites = new int[][]{};
            int[][] queries = new int[][]{new int[]{1, 0}, new int[]{0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkIfPrerequisite(n, prerequisites, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[false,false]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "numCourses = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]");
        try {
            int n = 3;
            int[][] prerequisites = new int[][]{new int[]{1, 2}, new int[]{1, 0}, new int[]{2, 0}};
            int[][] queries = new int[][]{new int[]{1, 0}, new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkIfPrerequisite(n, prerequisites, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[true,true]");
        System.out.println();
    }
}