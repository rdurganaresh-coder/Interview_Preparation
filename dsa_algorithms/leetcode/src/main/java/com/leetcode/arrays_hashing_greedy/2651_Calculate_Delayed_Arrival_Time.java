package com.leetcode.arrays_hashing_greedy;

class Solution2651 {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2651 _tcSol = new Solution2651();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arrivalTime = 15, delayedTime = 5");
        try {
            int arrivalTime = 15;
            int delayedTime = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.findDelayedArrivalTime(arrivalTime, delayedTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arrivalTime = 13, delayedTime = 11");
        try {
            int arrivalTime = 13;
            int delayedTime = 11;
            System.out.println("  Output  : " + _tcShow(_tcSol.findDelayedArrivalTime(arrivalTime, delayedTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}