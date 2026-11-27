package com.leetcode.arrays_hashing_greedy;

class Solution2409 {
    static final int[] f = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

    public int countDaysTogether(
        String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String start = arriveAlice.compareTo(arriveBob) > 0 ? arriveAlice : arriveBob;
        String end = leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob;
        int d1
            = f[Integer.parseInt(start.substring(0, 2)) - 1] + Integer.parseInt(start.substring(3));
        int d2 = f[Integer.parseInt(end.substring(0, 2)) - 1] + Integer.parseInt(end.substring(3));
        return Math.max(d2 - d1 + 1, 0);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2409 _tcSol = new Solution2409();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arriveAlice = \"08-15\", leaveAlice = \"08-18\", arriveBob = \"08-16\", leaveBob = \"08-19\"");
        try {
            String arriveAlice = "08-15";
            String leaveAlice = "08-18";
            String arriveBob = "08-16";
            String leaveBob = "08-19";
            System.out.println("  Output  : " + _tcShow(_tcSol.countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arriveAlice = \"10-01\", leaveAlice = \"10-31\", arriveBob = \"11-01\", leaveBob = \"12-31\"");
        try {
            String arriveAlice = "10-01";
            String leaveAlice = "10-31";
            String arriveBob = "11-01";
            String leaveBob = "12-31";
            System.out.println("  Output  : " + _tcShow(_tcSol.countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}