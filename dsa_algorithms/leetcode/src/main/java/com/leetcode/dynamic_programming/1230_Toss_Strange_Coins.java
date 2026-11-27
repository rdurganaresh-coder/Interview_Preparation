package com.leetcode.dynamic_programming;

class Solution1230 {
    public double probabilityOfHeads(double[] prob, int target) {
        int n = prob.length;
        double[][] f = new double[n + 1][target + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= Math.min(i, target); ++j) {
                f[i][j] = (1 - prob[i - 1]) * f[i - 1][j];
                if (j > 0) {
                    f[i][j] += prob[i - 1] * f[i - 1][j - 1];
                }
            }
        }
        return f[n][target];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1230 _tcSol = new Solution1230();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "prob = [0.4], target = 1");
        try {
            double[] prob = new double[]{0.4};
            int target = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.probabilityOfHeads(prob, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0.40000");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "prob = [0.5,0.5,0.5,0.5,0.5], target = 0");
        try {
            double[] prob = new double[]{0.5, 0.5, 0.5, 0.5, 0.5};
            int target = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.probabilityOfHeads(prob, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0.03125");
        System.out.println();
    }
}