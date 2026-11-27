package com.leetcode.dynamic_programming;

class Solution1000 {
    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if ((n - 1) % (K - 1) != 0) {
            return -1;
        }
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            s[i] = s[i - 1] + stones[i - 1];
        }
        int[][][] f = new int[n + 1][n + 1][K + 1];
        final int inf = 1 << 20;
        for (int[][] g : f) {
            for (int[] e : g) {
                Arrays.fill(e, inf);
            }
        }
        for (int i = 1; i <= n; ++i) {
            f[i][i][1] = 0;
        }
        for (int l = 2; l <= n; ++l) {
            for (int i = 1; i + l - 1 <= n; ++i) {
                int j = i + l - 1;
                for (int k = 1; k <= K; ++k) {
                    for (int h = i; h < j; ++h) {
                        f[i][j][k] = Math.min(f[i][j][k], f[i][h][1] + f[h + 1][j][k - 1]);
                    }
                }
                f[i][j][1] = f[i][j][K] + s[j] - s[i - 1];
            }
        }
        return f[1][n][1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1000 _tcSol = new Solution1000();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "stones = [3,2,4,1], k = 2");
        try {
            int[] stones = new int[]{3, 2, 4, 1};
            int K = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.mergeStones(stones, K)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "stones = [3,2,4,1], k = 3");
        try {
            int[] stones = new int[]{3, 2, 4, 1};
            int K = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.mergeStones(stones, K)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "stones = [3,5,1,2,6], k = 3");
        try {
            int[] stones = new int[]{3, 5, 1, 2, 6};
            int K = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.mergeStones(stones, K)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "25");
        System.out.println();
    }
}