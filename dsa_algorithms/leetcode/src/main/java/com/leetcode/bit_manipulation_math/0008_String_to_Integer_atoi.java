package com.leetcode.bit_manipulation_math;

class Solution0008 {
    public int myAtoi(String s) {
        if (s == null) return 0;
        int n = s.length();
        if (n == 0) return 0;
        int i = 0;
        while (s.charAt(i) == ' ') {
            if (++i == n) return 0;
        }
        int sign = 1;
        if (s.charAt(i) == '-') sign = -1;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') ++i;
        int res = 0, flag = Integer.MAX_VALUE / 10;
        for (; i < n; ++i) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') break;
            if (res > flag || (res == flag && s.charAt(i) > '7'))
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (s.charAt(i) - '0');
        }
        return sign * res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0008 _tcSol = new Solution0008();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"42\"");
        try {
            String s = "42";
            System.out.println("  Output  : " + _tcShow(_tcSol.myAtoi(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "42");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \" -042\"");
        try {
            String s = " -042";
            System.out.println("  Output  : " + _tcShow(_tcSol.myAtoi(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-42");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"1337c0d3\"");
        try {
            String s = "1337c0d3";
            System.out.println("  Output  : " + _tcShow(_tcSol.myAtoi(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1337");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "s = \"0-1\"");
        try {
            String s = "0-1";
            System.out.println("  Output  : " + _tcShow(_tcSol.myAtoi(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 5");
        System.out.println("  Input   : " + "s = \"words and 987\"");
        try {
            String s = "words and 987";
            System.out.println("  Output  : " + _tcShow(_tcSol.myAtoi(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}