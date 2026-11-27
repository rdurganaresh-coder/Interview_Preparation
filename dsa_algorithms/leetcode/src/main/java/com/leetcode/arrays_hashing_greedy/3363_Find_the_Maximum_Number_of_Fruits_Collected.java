package com.leetcode.arrays_hashing_greedy;

class Solution3363 {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        final int inf = 1 << 29;
        int[][] f = new int[n][n];
        for (var row : f) {
            Arrays.fill(row, -inf);
        }
        f[0][n - 1] = fruits[0][n - 1];
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - 1]) + fruits[i][j];
                if (j + 1 < n) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j + 1] + fruits[i][j]);
                }
            }
        }
        f[n - 1][0] = fruits[n - 1][0];
        for (int j = 1; j < n; j++) {
            for (int i = j + 1; i < n; i++) {
                f[i][j] = Math.max(f[i][j - 1], f[i - 1][j - 1]) + fruits[i][j];
                if (i + 1 < n) {
                    f[i][j] = Math.max(f[i][j], f[i + 1][j - 1] + fruits[i][j]);
                }
            }
        }
        int ans = f[n - 2][n - 1] + f[n - 1][n - 2];
        for (int i = 0; i < n; i++) {
            ans += fruits[i][i];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3363 _tcSol = new Solution3363();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "fruits = [[1,2,3,4],[5,6,8,7],[9,10,11,12],[13,14,15,16]]");
        try {
            int[][] fruits = new int[][]{new int[]{1, 2, 3, 4}, new int[]{5, 6, 8, 7}, new int[]{9, 10, 11, 12}, new int[]{13, 14, 15, 16}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxCollectedFruits(fruits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "100");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "fruits = [[1,1],[1,1]]");
        try {
            int[][] fruits = new int[][]{new int[]{1, 1}, new int[]{1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxCollectedFruits(fruits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}
