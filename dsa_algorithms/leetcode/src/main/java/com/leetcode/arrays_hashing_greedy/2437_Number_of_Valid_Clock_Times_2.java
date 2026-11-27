package com.leetcode.arrays_hashing_greedy;

class Solution2437_2 {
    public int countTime(String time) {
        return f(time.substring(0, 2), 24) * f(time.substring(3), 60);
    }

    private int f(String s, int m) {
        int cnt = 0;
        for (int i = 0; i < m; ++i) {
            boolean a = s.charAt(0) == '?' || s.charAt(0) - '0' == i / 10;
            boolean b = s.charAt(1) == '?' || s.charAt(1) - '0' == i % 10;
            cnt += a && b ? 1 : 0;
        }
        return cnt;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2437_2 _tcSol = new Solution2437_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "time = \"?5:00\"");
        try {
            String time = "?5:00";
            System.out.println("  Output  : " + _tcShow(_tcSol.countTime(time)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "time = \"0?:0?\"");
        try {
            String time = "0?:0?";
            System.out.println("  Output  : " + _tcShow(_tcSol.countTime(time)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "100");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "time = \"??:??\"");
        try {
            String time = "??:??";
            System.out.println("  Output  : " + _tcShow(_tcSol.countTime(time)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1440");
        System.out.println();
    }
}