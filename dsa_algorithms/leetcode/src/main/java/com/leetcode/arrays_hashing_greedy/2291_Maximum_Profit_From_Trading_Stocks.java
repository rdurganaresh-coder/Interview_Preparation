package com.leetcode.arrays_hashing_greedy;

class Solution2291 {
    public int maximumProfit(int[] present, int[] future, int budget) {
        int n = present.length;
        int[][] f = new int[n + 1][budget + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= budget; ++j) {
                f[i][j] = f[i - 1][j];
                if (j >= present[i - 1]) {
                    f[i][j] = Math.max(
                        f[i][j], f[i - 1][j - present[i - 1]] + future[i - 1] - present[i - 1]);
                }
            }
        }
        return f[n][budget];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2291 _tcSol = new Solution2291();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "present = [5,4,6,2,3], future = [8,5,4,3,5], budget = 10");
        try {
            int[] present = new int[]{5, 4, 6, 2, 3};
            int[] future = new int[]{8, 5, 4, 3, 5};
            int budget = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumProfit(present, future, budget)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "present = [2,2,5], future = [3,4,10], budget = 6");
        try {
            int[] present = new int[]{2, 2, 5};
            int[] future = new int[]{3, 4, 10};
            int budget = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumProfit(present, future, budget)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "present = [3,3,12], future = [0,3,15], budget = 10");
        try {
            int[] present = new int[]{3, 3, 12};
            int[] future = new int[]{0, 3, 15};
            int budget = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumProfit(present, future, budget)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}