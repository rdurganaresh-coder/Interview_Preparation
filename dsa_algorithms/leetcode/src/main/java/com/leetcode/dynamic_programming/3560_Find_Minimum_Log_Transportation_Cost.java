package com.leetcode.dynamic_programming;

class Solution3560 {
    public long minCuttingCost(int n, int m, int k) {
        int x = Math.max(n, m);
        return x <= k ? 0 : 1L * k * (x - k);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3560 _tcSol = new Solution3560();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 6, m = 5, k = 5");
        try {
            int n = 6;
            int m = 5;
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.minCuttingCost(n, m, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, m = 4, k = 6");
        try {
            int n = 4;
            int m = 4;
            int k = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.minCuttingCost(n, m, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}