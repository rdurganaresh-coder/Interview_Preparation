package com.leetcode.dynamic_programming;

class Solution2240 {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ans = 0;
        for (int x = 0; x <= total / cost1; ++x) {
            int y = (total - x * cost1) / cost2 + 1;
            ans += y;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2240 _tcSol = new Solution2240();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "total = 20, cost1 = 10, cost2 = 5");
        try {
            int total = 20;
            int cost1 = 10;
            int cost2 = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.waysToBuyPensPencils(total, cost1, cost2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "total = 5, cost1 = 10, cost2 = 10");
        try {
            int total = 5;
            int cost1 = 10;
            int cost2 = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.waysToBuyPensPencils(total, cost1, cost2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}