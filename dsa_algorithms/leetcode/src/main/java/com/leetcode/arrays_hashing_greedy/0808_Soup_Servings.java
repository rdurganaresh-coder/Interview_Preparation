package com.leetcode.arrays_hashing_greedy;

class Solution0808 {
    private double[][] f = new double[200][200];

    public double soupServings(int n) {
        return n > 4800 ? 1 : dfs((n + 24) / 25, (n + 24) / 25);
    }

    private double dfs(int i, int j) {
        if (i <= 0 && j <= 0) {
            return 0.5;
        }
        if (i <= 0) {
            return 1.0;
        }
        if (j <= 0) {
            return 0;
        }
        if (f[i][j] > 0) {
            return f[i][j];
        }
        double ans
            = 0.25 * (dfs(i - 4, j) + dfs(i - 3, j - 1) + dfs(i - 2, j - 2) + dfs(i - 1, j - 3));
        f[i][j] = ans;
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0808 _tcSol = new Solution0808();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 50");
        try {
            int n = 50;
            System.out.println("  Output  : " + _tcShow(_tcSol.soupServings(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0.62500");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 100");
        try {
            int n = 100;
            System.out.println("  Output  : " + _tcShow(_tcSol.soupServings(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0.71875");
        System.out.println();
    }
}