package com.leetcode.strings;

class Solution3561 {
    public String resultingString(String s) {
        StringBuilder stk = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (stk.length() > 0 && isContiguous(stk.charAt(stk.length() - 1), c)) {
                stk.deleteCharAt(stk.length() - 1);
            } else {
                stk.append(c);
            }
        }
        return stk.toString();
    }

    private boolean isContiguous(char a, char b) {
        int t = Math.abs(a - b);
        return t == 1 || t == 25;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3561 _tcSol = new Solution3561();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abc\"");
        try {
            String s = "abc";
            System.out.println("  Output  : " + _tcShow(_tcSol.resultingString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"c\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"adcb\"");
        try {
            String s = "adcb";
            System.out.println("  Output  : " + _tcShow(_tcSol.resultingString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"zadb\"");
        try {
            String s = "zadb";
            System.out.println("  Output  : " + _tcShow(_tcSol.resultingString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"db\"");
        System.out.println();
    }
}