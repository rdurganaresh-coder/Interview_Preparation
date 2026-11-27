package com.leetcode.strings;

class Solution3114_2 {
    public String findLatestTime(String s) {
        char[] cs = s.toCharArray();
        if (cs[0] == '?') {
            cs[0] = cs[1] == '?' || cs[1] < '2' ? '1' : '0';
        }
        if (cs[1] == '?') {
            cs[1] = cs[0] == '1' ? '1' : '9';
        }
        if (cs[3] == '?') {
            cs[3] = '5';
        }
        if (cs[4] == '?') {
            cs[4] = '9';
        }
        return new String(cs);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3114_2 _tcSol = new Solution3114_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"1?:?4\"");
        try {
            String s = "1?:?4";
            System.out.println("  Output  : " + _tcShow(_tcSol.findLatestTime(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"11:54\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"0?:5?\"");
        try {
            String s = "0?:5?";
            System.out.println("  Output  : " + _tcShow(_tcSol.findLatestTime(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"09:59\"");
        System.out.println();
    }
}