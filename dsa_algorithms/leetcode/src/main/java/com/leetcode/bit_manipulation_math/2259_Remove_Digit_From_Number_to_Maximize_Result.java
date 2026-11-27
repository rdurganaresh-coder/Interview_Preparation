package com.leetcode.bit_manipulation_math;

class Solution2259 {
    public String removeDigit(String number, char digit) {
        String ans = "0";
        for (int i = 0, n = number.length(); i < n; ++i) {
            char d = number.charAt(i);
            if (d == digit) {
                String t = number.substring(0, i) + number.substring(i + 1);
                if (ans.compareTo(t) < 0) {
                    ans = t;
                }
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
        Solution2259 _tcSol = new Solution2259();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "number = \"123\", digit = \"3\"");
        try {
            String number = "123";
            char digit = '3';
            System.out.println("  Output  : " + _tcShow(_tcSol.removeDigit(number, digit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"12\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "number = \"1231\", digit = \"1\"");
        try {
            String number = "1231";
            char digit = '1';
            System.out.println("  Output  : " + _tcShow(_tcSol.removeDigit(number, digit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"231\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "number = \"551\", digit = \"5\"");
        try {
            String number = "551";
            char digit = '5';
            System.out.println("  Output  : " + _tcShow(_tcSol.removeDigit(number, digit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"51\"");
        System.out.println();
    }
}