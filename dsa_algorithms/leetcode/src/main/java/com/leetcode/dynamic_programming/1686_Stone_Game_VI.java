package com.leetcode.dynamic_programming;

class Solution1686 {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[][] vals = new int[n][0];
        for (int i = 0; i < n; ++i) {
            vals[i] = new int[] {aliceValues[i] + bobValues[i], i};
        }
        Arrays.sort(vals, (a, b) -> b[0] - a[0]);
        int a = 0, b = 0;
        for (int k = 0; k < n; ++k) {
            int i = vals[k][1];
            if (k % 2 == 0) {
                a += aliceValues[i];
            } else {
                b += bobValues[i];
            }
        }
        if (a == b) {
            return 0;
        }
        return a > b ? 1 : -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1686 _tcSol = new Solution1686();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "aliceValues = [1,3], bobValues = [2,1]");
        try {
            int[] aliceValues = new int[]{1, 3};
            int[] bobValues = new int[]{2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.stoneGameVI(aliceValues, bobValues)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "aliceValues = [1,2], bobValues = [3,1]");
        try {
            int[] aliceValues = new int[]{1, 2};
            int[] bobValues = new int[]{3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.stoneGameVI(aliceValues, bobValues)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "aliceValues = [2,4,3], bobValues = [1,6,7]");
        try {
            int[] aliceValues = new int[]{2, 4, 3};
            int[] bobValues = new int[]{1, 6, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.stoneGameVI(aliceValues, bobValues)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}