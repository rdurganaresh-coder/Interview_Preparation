package com.leetcode.arrays_hashing_greedy;

class Solution1223_2 {
    public int dieSimulator(int n, int[] rollMax) {
        int[][][] f = new int[n + 1][7][16];
        for (int j = 1; j <= 6; ++j) {
            f[1][j][1] = 1;
        }
        final int mod = (int) 1e9 + 7;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= 6; ++j) {
                for (int x = 1; x <= rollMax[j - 1]; ++x) {
                    for (int k = 1; k <= 6; ++k) {
                        if (k != j) {
                            f[i][k][1] = (f[i][k][1] + f[i - 1][j][x]) % mod;
                        } else if (x + 1 <= rollMax[j - 1]) {
                            f[i][j][x + 1] = (f[i][j][x + 1] + f[i - 1][j][x]) % mod;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int j = 1; j <= 6; ++j) {
            for (int x = 1; x <= rollMax[j - 1]; ++x) {
                ans = (ans + f[n][j][x]) % mod;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1223_2 _tcSol = new Solution1223_2();
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