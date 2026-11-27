package com.leetcode.dynamic_programming;

class Solution1690_3 {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + stones[i];
        }
        int[][] f = new int[n][n];
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                int a = s[j + 1] - s[i + 1] - f[i + 1][j];
                int b = s[j] - s[i] - f[i][j - 1];
                f[i][j] = Math.max(a, b);
            }
        }
        return f[0][n - 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1690_3 _tcSol = new Solution1690_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "stones = [5,3,1,4,2]");
        try {
            int[] stones = new int[]{5, 3, 1, 4, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.stoneGameVII(stones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "stones = [7,90,5,1,100,10,10,2]");
        try {
            int[] stones = new int[]{7, 90, 5, 1, 100, 10, 10, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.stoneGameVII(stones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "122");
        System.out.println();
    }
}
