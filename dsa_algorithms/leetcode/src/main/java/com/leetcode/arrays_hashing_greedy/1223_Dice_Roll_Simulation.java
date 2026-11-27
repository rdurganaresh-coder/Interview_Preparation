package com.leetcode.arrays_hashing_greedy;

class Solution1223 {
    private Integer[][][] f;
    private int[] rollMax;

    public int dieSimulator(int n, int[] rollMax) {
        f = new Integer[n][7][16];
        this.rollMax = rollMax;
        return dfs(0, 0, 0);
    }

    private int dfs(int i, int j, int x) {
        if (i >= f.length) {
            return 1;
        }
        if (f[i][j][x] != null) {
            return f[i][j][x];
        }
        long ans = 0;
        for (int k = 1; k <= 6; ++k) {
            if (k != j) {
                ans += dfs(i + 1, k, 1);
            } else if (x < rollMax[j - 1]) {
                ans += dfs(i + 1, j, x + 1);
            }
        }
        ans %= 1000000007;
        return f[i][j][x] = (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1223 _tcSol = new Solution1223();
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
