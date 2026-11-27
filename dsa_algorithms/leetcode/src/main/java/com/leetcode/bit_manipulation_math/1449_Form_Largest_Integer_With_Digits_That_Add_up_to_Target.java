package com.leetcode.bit_manipulation_math;

class Solution1449 {
    public String largestNumber(int[] cost, int target) {
        final int inf = 1 << 30;
        int[][] f = new int[10][target + 1];
        int[][] g = new int[10][target + 1];
        for (var e : f) {
            Arrays.fill(e, -inf);
        }
        f[0][0] = 0;
        for (int i = 1; i <= 9; ++i) {
            int c = cost[i - 1];
            for (int j = 0; j <= target; ++j) {
                if (j < c || f[i][j - c] + 1 < f[i - 1][j]) {
                    f[i][j] = f[i - 1][j];
                    g[i][j] = j;
                } else {
                    f[i][j] = f[i][j - c] + 1;
                    g[i][j] = j - c;
                }
            }
        }
        if (f[9][target] < 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9, j = target; i > 0;) {
            if (j == g[i][j]) {
                --i;
            } else {
                sb.append(i);
                j = g[i][j];
            }
        }
        return sb.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1449 _tcSol = new Solution1449();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "cost = [4,3,2,5,6,7,2,5,5], target = 9");
        try {
            int[] cost = new int[]{4, 3, 2, 5, 6, 7, 2, 5, 5};
            int target = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.largestNumber(cost, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"7772\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "cost = [7,6,5,5,5,6,8,7,8], target = 12");
        try {
            int[] cost = new int[]{7, 6, 5, 5, 5, 6, 8, 7, 8};
            int target = 12;
            System.out.println("  Output  : " + _tcShow(_tcSol.largestNumber(cost, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"85\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "cost = [2,4,6,2,4,6,4,4,4], target = 5");
        try {
            int[] cost = new int[]{2, 4, 6, 2, 4, 6, 4, 4, 4};
            int target = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.largestNumber(cost, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"0\"");
        System.out.println();
    }
}