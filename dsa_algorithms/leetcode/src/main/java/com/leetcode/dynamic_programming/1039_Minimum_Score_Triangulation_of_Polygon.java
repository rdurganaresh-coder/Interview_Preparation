package com.leetcode.dynamic_programming;

class Solution1039 {
    private int n;
    private int[] values;
    private Integer[][] f;

    public int minScoreTriangulation(int[] values) {
        n = values.length;
        this.values = values;
        f = new Integer[n][n];
        return dfs(0, n - 1);
    }

    private int dfs(int i, int j) {
        if (i + 1 == j) {
            return 0;
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        int ans = 1 << 30;
        for (int k = i + 1; k < j; ++k) {
            ans = Math.min(ans, dfs(i, k) + dfs(k, j) + values[i] * values[k] * values[j]);
        }
        return f[i][j] = ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1039 _tcSol = new Solution1039();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "values = [1,2,3]");
        try {
            int[] values = new int[]{1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minScoreTriangulation(values)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "values = [3,7,4,5]");
        try {
            int[] values = new int[]{3, 7, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minScoreTriangulation(values)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "144");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "values = [1,3,1,4,1,5]");
        try {
            int[] values = new int[]{1, 3, 1, 4, 1, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minScoreTriangulation(values)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();
    }
}