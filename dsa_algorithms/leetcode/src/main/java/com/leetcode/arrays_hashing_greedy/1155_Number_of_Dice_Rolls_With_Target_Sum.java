package com.leetcode.arrays_hashing_greedy;

class Solution1155 {
    public int numRollsToTarget(int n, int k, int target) {
        final int mod = (int) 1e9 + 7;
        int[][] f = new int[n + 1][target + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= Math.min(target, i * k); ++j) {
                for (int h = 1; h <= Math.min(j, k); ++h) {
                    f[i][j] = (f[i][j] + f[i - 1][j - h]) % mod;
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
        Solution1155 _tcSol = new Solution1155();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 1, k = 6, target = 3");
        try {
            int n = 1;
            int k = 6;
            int target = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.numRollsToTarget(n, k, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2, k = 6, target = 7");
        try {
            int n = 2;
            int k = 6;
            int target = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.numRollsToTarget(n, k, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 30, k = 30, target = 500");
        try {
            int n = 30;
            int k = 30;
            int target = 500;
            System.out.println("  Output  : " + _tcShow(_tcSol.numRollsToTarget(n, k, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "222616187");
        System.out.println();
    }
}