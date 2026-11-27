package com.leetcode.arrays_hashing_greedy;

class Solution1223_3 {
    public int dieSimulator(int n, int[] rollMax) {
        final int mod = 1000000007;
        int[][][] f = new int[n + 1][7][16];
        for (int j = 0; j < 7; ++j) {
            for (int x = 0; x < 16; ++x) {
                f[n][j][x] = 1;
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = 0; j < 7; ++j) {
                for (int x = 0; x < 16; ++x) {
                    long ans = 0;
                    for (int k = 1; k <= 6; ++k) {
                        if (k != j) {
                            ans += f[i + 1][k][1];
                        } else if (x < rollMax[j - 1]) {
                            ans += f[i + 1][j][x + 1];
                        }
                    }
                    f[i][j][x] = (int) (ans % mod);
                }
            }
        }
        return f[0][0][0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1223_3 _tcSol = new Solution1223_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 2, rollMax = [1,1,2,2,2,3]");
        try {
            int n = 2;
            int[] rollMax = new int[]{1, 1, 2, 2, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.dieSimulator(n, rollMax)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "34");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2, rollMax = [1,1,1,1,1,1]");
        try {
            int n = 2;
            int[] rollMax = new int[]{1, 1, 1, 1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.dieSimulator(n, rollMax)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "30");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 3, rollMax = [1,1,1,2,2,3]");
        try {
            int n = 3;
            int[] rollMax = new int[]{1, 1, 1, 2, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.dieSimulator(n, rollMax)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "181");
        System.out.println();
    }
}
