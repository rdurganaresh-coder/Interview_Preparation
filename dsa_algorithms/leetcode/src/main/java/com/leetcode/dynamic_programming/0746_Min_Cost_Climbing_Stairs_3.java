package com.leetcode.dynamic_programming;

class Solution0746_3 {
    public int minCostClimbingStairs(int[] cost) {
        int f = 0, g = 0;
        for (int i = 2; i <= cost.length; ++i) {
            int gg = Math.min(f + cost[i - 2], g + cost[i - 1]);
            f = g;
            g = gg;
        }
        return g;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0746_3 _tcSol = new Solution0746_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "cost = [10,15,20]");
        try {
            int[] cost = new int[]{10, 15, 20};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCostClimbingStairs(cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "cost = [1,100,1,1,1,100,1,1,100,1]");
        try {
            int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCostClimbingStairs(cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}
