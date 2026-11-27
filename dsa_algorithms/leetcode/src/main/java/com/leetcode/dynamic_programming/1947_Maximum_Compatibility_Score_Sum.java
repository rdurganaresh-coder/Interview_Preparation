package com.leetcode.dynamic_programming;

class Solution1947 {
    private int m;
    private int ans;
    private int[][] g;
    private boolean[] vis;

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        m = students.length;
        g = new int[m][m];
        vis = new boolean[m];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < m; ++j) {
                for (int k = 0; k < students[i].length; ++k) {
                    if (students[i][k] == mentors[j][k]) {
                        ++g[i][j];
                    }
                }
            }
        }
        dfs(0, 0);
        return ans;
    }

    private void dfs(int i, int s) {
        if (i >= m) {
            ans = Math.max(ans, s);
            return;
        }
        for (int j = 0; j < m; ++j) {
            if (!vis[j]) {
                vis[j] = true;
                dfs(i + 1, s + g[i][j]);
                vis[j] = false;
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1947 _tcSol = new Solution1947();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "students = [[1,1,0],[1,0,1],[0,0,1]], mentors = [[1,0,0],[0,0,1],[1,1,0]]");
        try {
            int[][] students = new int[][]{new int[]{1, 1, 0}, new int[]{1, 0, 1}, new int[]{0, 0, 1}};
            int[][] mentors = new int[][]{new int[]{1, 0, 0}, new int[]{0, 0, 1}, new int[]{1, 1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxCompatibilitySum(students, mentors)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "students = [[0,0],[0,0],[0,0]], mentors = [[1,1],[1,1],[1,1]]");
        try {
            int[][] students = new int[][]{new int[]{0, 0}, new int[]{0, 0}, new int[]{0, 0}};
            int[][] mentors = new int[][]{new int[]{1, 1}, new int[]{1, 1}, new int[]{1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxCompatibilitySum(students, mentors)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
