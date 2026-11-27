package com.leetcode.graphs_shortest_path;

class Solution0062 {
    public int uniquePaths(int m, int n) {
        var f = new int[m][n];
        f[0][0] = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i > 0) {
                    f[i][j] += f[i - 1][j];
                }
                if (j > 0) {
                    f[i][j] += f[i][j - 1];
                }
            }
        }
        return f[m - 1][n - 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0062 _tcSol = new Solution0062();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "m = 3, n = 7");
        try {
            int m = 3;
            int n = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.uniquePaths(m, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "28");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "m = 3, n = 2");
        try {
            int m = 3;
            int n = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.uniquePaths(m, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}