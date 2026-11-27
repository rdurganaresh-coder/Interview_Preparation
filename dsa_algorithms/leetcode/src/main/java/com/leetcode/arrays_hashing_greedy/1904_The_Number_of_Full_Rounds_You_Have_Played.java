package com.leetcode.arrays_hashing_greedy;

class Solution1904 {
    public int numberOfRounds(String loginTime, String logoutTime) {
        int a = f(loginTime), b = f(logoutTime);
        if (a > b) {
            b += 1440;
        }
        return Math.max(0, b / 15 - (a + 14) / 15);
    }

    private int f(String s) {
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));
        return h * 60 + m;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1904 _tcSol = new Solution1904();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "loginTime = \"09:31\", logoutTime = \"10:14\"");
        try {
            String loginTime = "09:31";
            String logoutTime = "10:14";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfRounds(loginTime, logoutTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "loginTime = \"21:30\", logoutTime = \"03:00\"");
        try {
            String loginTime = "21:30";
            String logoutTime = "03:00";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfRounds(loginTime, logoutTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "22");
        System.out.println();
    }
}