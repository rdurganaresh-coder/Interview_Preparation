package com.leetcode.dynamic_programming;

class Solution2585 {
    public int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        final int mod = (int) 1e9 + 7;
        int[][] f = new int[n + 1][target + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            int count = types[i - 1][0], marks = types[i - 1][1];
            for (int j = 0; j <= target; ++j) {
                for (int k = 0; k <= count; ++k) {
                    if (j >= k * marks) {
                        f[i][j] = (f[i][j] + f[i - 1][j - k * marks]) % mod;
                    }
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
        Solution2585 _tcSol = new Solution2585();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "target = 6, types = [[6,1],[3,2],[2,3]]");
        try {
            int target = 6;
            int[][] types = new int[][]{new int[]{6, 1}, new int[]{3, 2}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.waysToReachTarget(target, types)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "target = 5, types = [[50,1],[50,2],[50,5]]");
        try {
            int target = 5;
            int[][] types = new int[][]{new int[]{50, 1}, new int[]{50, 2}, new int[]{50, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.waysToReachTarget(target, types)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "target = 18, types = [[6,1],[3,2],[2,3]]");
        try {
            int target = 18;
            int[][] types = new int[][]{new int[]{6, 1}, new int[]{3, 2}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.waysToReachTarget(target, types)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}