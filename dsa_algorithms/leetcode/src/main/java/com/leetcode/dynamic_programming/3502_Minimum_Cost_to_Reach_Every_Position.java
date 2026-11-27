package com.leetcode.dynamic_programming;

class Solution3502 {
    public int[] minCosts(int[] cost) {
        int n = cost.length;
        int[] ans = new int[n];
        int mi = cost[0];
        for (int i = 0; i < n; ++i) {
            mi = Math.min(mi, cost[i]);
            ans[i] = mi;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3502 _tcSol = new Solution3502();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "cost = [5,3,4,1,3,2]");
        try {
            int[] cost = new int[]{5, 3, 4, 1, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCosts(cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,3,3,1,1,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "cost = [1,2,4,6,7]");
        try {
            int[] cost = new int[]{1, 2, 4, 6, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCosts(cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1,1,1,1]");
        System.out.println();
    }
}