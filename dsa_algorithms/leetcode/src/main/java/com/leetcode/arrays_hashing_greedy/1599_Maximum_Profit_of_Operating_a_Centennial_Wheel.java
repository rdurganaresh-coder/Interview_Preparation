package com.leetcode.arrays_hashing_greedy;

class Solution1599 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int ans = -1;
        int mx = 0, t = 0;
        int wait = 0, i = 0;
        while (wait > 0 || i < customers.length) {
            wait += i < customers.length ? customers[i] : 0;
            int up = Math.min(4, wait);
            wait -= up;
            ++i;
            t += up * boardingCost - runningCost;
            if (t > mx) {
                mx = t;
                ans = i;
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
        Solution1599 _tcSol = new Solution1599();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "customers = [8,3], boardingCost = 5, runningCost = 6");
        try {
            int[] customers = new int[]{8, 3};
            int boardingCost = 5;
            int runningCost = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperationsMaxProfit(customers, boardingCost, runningCost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "customers = [10,9,6], boardingCost = 6, runningCost = 4");
        try {
            int[] customers = new int[]{10, 9, 6};
            int boardingCost = 6;
            int runningCost = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperationsMaxProfit(customers, boardingCost, runningCost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "customers = [3,4,0,5,1], boardingCost = 1, runningCost = 92");
        try {
            int[] customers = new int[]{3, 4, 0, 5, 1};
            int boardingCost = 1;
            int runningCost = 92;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperationsMaxProfit(customers, boardingCost, runningCost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}