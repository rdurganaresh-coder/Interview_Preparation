package com.leetcode.sql_database;

class Solution2806 {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int diff = 100, x = 0;
        for (int y = 100; y >= 0; y -= 10) {
            int t = Math.abs(y - purchaseAmount);
            if (t < diff) {
                diff = t;
                x = y;
            }
        }
        return 100 - x;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2806 _tcSol = new Solution2806();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "purchaseAmount = 9");
        try {
            int purchaseAmount = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.accountBalanceAfterPurchase(purchaseAmount)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "90");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "purchaseAmount = 15");
        try {
            int purchaseAmount = 15;
            System.out.println("  Output  : " + _tcShow(_tcSol.accountBalanceAfterPurchase(purchaseAmount)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "80");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "purchaseAmount = 10");
        try {
            int purchaseAmount = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.accountBalanceAfterPurchase(purchaseAmount)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "90");
        System.out.println();
    }
}