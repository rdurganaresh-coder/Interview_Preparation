package com.leetcode.arrays_hashing_greedy;

class Solution3193 {
    public int numberOfPermutations(int n, int[][] requirements) {
        int[] req = new int[n];
        Arrays.fill(req, -1);
        int m = 0;
        for (var r : requirements) {
            req[r[0]] = r[1];
            m = Math.max(m, r[1]);
        }
        if (req[0] > 0) {
            return 0;
        }
        req[0] = 0;
        final int mod = (int) 1e9 + 7;
        int[][] f = new int[n][m + 1];
        f[0][0] = 1;
        for (int i = 1; i < n; ++i) {
            int l = 0, r = m;
            if (req[i] >= 0) {
                l = r = req[i];
            }
            for (int j = l; j <= r; ++j) {
                for (int k = 0; k <= Math.min(i, j); ++k) {
                    f[i][j] = (f[i][j] + f[i - 1][j - k]) % mod;
                }
            }
        }
        return f[n - 1][req[n - 1]];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3193 _tcSol = new Solution3193();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, requirements = [[2,2],[0,0]]");
        try {
            int n = 3;
            int[][] requirements = new int[][]{new int[]{2, 2}, new int[]{0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfPermutations(n, requirements)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, requirements = [[2,2],[1,1],[0,0]]");
        try {
            int n = 3;
            int[][] requirements = new int[][]{new int[]{2, 2}, new int[]{1, 1}, new int[]{0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfPermutations(n, requirements)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 2, requirements = [[0,0],[1,0]]");
        try {
            int n = 2;
            int[][] requirements = new int[][]{new int[]{0, 0}, new int[]{1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfPermutations(n, requirements)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}