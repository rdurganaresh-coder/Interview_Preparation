package com.leetcode.dynamic_programming;

class Solution0256 {
    public int minCost(int[][] costs) {
        int r = 0, g = 0, b = 0;
        for (int[] cost : costs) {
            int _r = r, _g = g, _b = b;
            r = Math.min(_g, _b) + cost[0];
            g = Math.min(_r, _b) + cost[1];
            b = Math.min(_r, _g) + cost[2];
        }
        return Math.min(r, Math.min(g, b));
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0256 _tcSol = new Solution0256();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "costs = [[17,2,17],[16,16,5],[14,3,19]]");
        try {
            int[][] costs = new int[][]{new int[]{17, 2, 17}, new int[]{16, 16, 5}, new int[]{14, 3, 19}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(costs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "costs = [[7,6,2]]");
        try {
            int[][] costs = new int[][]{new int[]{7, 6, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(costs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}