package com.leetcode.sliding_window_two_pointers;

class Solution3100 {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles >= numExchange) {
            numBottles -= numExchange;
            ++numExchange;
            ++ans;
            ++numBottles;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3100 _tcSol = new Solution3100();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "numBottles = 13, numExchange = 6");
        try {
            int numBottles = 13;
            int numExchange = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxBottlesDrunk(numBottles, numExchange)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "numBottles = 10, numExchange = 3");
        try {
            int numBottles = 10;
            int numExchange = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxBottlesDrunk(numBottles, numExchange)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();
    }
}