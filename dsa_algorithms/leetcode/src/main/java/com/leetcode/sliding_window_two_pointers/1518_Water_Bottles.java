package com.leetcode.sliding_window_two_pointers;

class Solution1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        for (; numBottles >= numExchange; ++ans) {
            numBottles -= (numExchange - 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1518 _tcSol = new Solution1518();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "numBottles = 9, numExchange = 3");
        try {
            int numBottles = 9;
            int numExchange = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.numWaterBottles(numBottles, numExchange)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "numBottles = 15, numExchange = 4");
        try {
            int numBottles = 15;
            int numExchange = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.numWaterBottles(numBottles, numExchange)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "19");
        System.out.println();
    }
}