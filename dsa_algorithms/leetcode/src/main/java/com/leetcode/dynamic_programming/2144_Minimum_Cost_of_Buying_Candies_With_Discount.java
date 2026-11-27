package com.leetcode.dynamic_programming;

class Solution2144 {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int ans = 0;
        for (int i = cost.length - 1; i >= 0; i -= 3) {
            ans += cost[i];
            if (i > 0) {
                ans += cost[i - 1];
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2144 _tcSol = new Solution2144();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "cost = [1,2,3]");
        try {
            int[] cost = new int[]{1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "cost = [6,5,7,9,2,2]");
        try {
            int[] cost = new int[]{6, 5, 7, 9, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "23");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "cost = [5,5]");
        try {
            int[] cost = new int[]{5, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}