package com.leetcode.bit_manipulation_math;

class Solution1736 {
    public String maximumTime(String time) {
        char[] t = time.toCharArray();
        if (t[0] == '?') {
            t[0] = t[1] >= '4' && t[1] <= '9' ? '1' : '2';
        }
        if (t[1] == '?') {
            t[1] = t[0] == '2' ? '3' : '9';
        }
        if (t[3] == '?') {
            t[3] = '5';
        }
        if (t[4] == '?') {
            t[4] = '9';
        }
        return new String(t);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1736 _tcSol = new Solution1736();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "time = \"2?:?0\"");
        try {
            String time = "2?:?0";
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumTime(time)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"23:50\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "time = \"0?:3?\"");
        try {
            String time = "0?:3?";
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumTime(time)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"09:39\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "time = \"1?:22\"");
        try {
            String time = "1?:22";
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumTime(time)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"19:22\"");
        System.out.println();
    }
}