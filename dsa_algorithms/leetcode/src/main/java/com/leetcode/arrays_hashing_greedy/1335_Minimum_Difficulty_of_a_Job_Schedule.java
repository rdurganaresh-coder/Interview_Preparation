package com.leetcode.arrays_hashing_greedy;

class Solution1335 {
    public int minDifficulty(int[] jobDifficulty, int d) {
        final int inf = 1 << 30;
        int n = jobDifficulty.length;
        int[][] f = new int[n + 1][d + 1];
        for (var g : f) {
            Arrays.fill(g, inf);
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= Math.min(d, i); ++j) {
                int mx = 0;
                for (int k = i; k > 0; --k) {
                    mx = Math.max(mx, jobDifficulty[k - 1]);
                    f[i][j] = Math.min(f[i][j], f[k - 1][j - 1] + mx);
                }
            }
        }
        return f[n][d] >= inf ? -1 : f[n][d];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1335 _tcSol = new Solution1335();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "jobDifficulty = [6,5,4,3,2,1], d = 2");
        try {
            int[] jobDifficulty = new int[]{6, 5, 4, 3, 2, 1};
            int d = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minDifficulty(jobDifficulty, d)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "jobDifficulty = [9,9,9], d = 4");
        try {
            int[] jobDifficulty = new int[]{9, 9, 9};
            int d = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minDifficulty(jobDifficulty, d)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "jobDifficulty = [1,1,1], d = 3");
        try {
            int[] jobDifficulty = new int[]{1, 1, 1};
            int d = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minDifficulty(jobDifficulty, d)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}