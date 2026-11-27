package com.leetcode.strings;

class Solution0678_2 {
    public boolean checkValidString(String s) {
        int x = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) != ')') {
                ++x;
            } else if (x > 0) {
                --x;
            } else {
                return false;
            }
        }
        x = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt(i) != '(') {
                ++x;
            } else if (x > 0) {
                --x;
            } else {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0678_2 _tcSol = new Solution0678_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"()\"");
        try {
            String s = "()";
            System.out.println("  Output  : " + _tcShow(_tcSol.checkValidString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"(*)\"");
        try {
            String s = "(*)";
            System.out.println("  Output  : " + _tcShow(_tcSol.checkValidString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"(*))\"");
        try {
            String s = "(*))";
            System.out.println("  Output  : " + _tcShow(_tcSol.checkValidString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "s = \"(\"");
        try {
            String s = "(";
            System.out.println("  Output  : " + _tcShow(_tcSol.checkValidString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}