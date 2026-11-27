package com.leetcode.dynamic_programming;

class Solution0856 {
    public int scoreOfParentheses(String s) {
        int ans = 0, d = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                ++d;
            } else {
                --d;
                if (s.charAt(i - 1) == '(') {
                    ans += 1 << d;
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
        Solution0856 _tcSol = new Solution0856();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"()\"");
        try {
            String s = "()";
            System.out.println("  Output  : " + _tcShow(_tcSol.scoreOfParentheses(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"(())\"");
        try {
            String s = "(())";
            System.out.println("  Output  : " + _tcShow(_tcSol.scoreOfParentheses(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"()()\"");
        try {
            String s = "()()";
            System.out.println("  Output  : " + _tcShow(_tcSol.scoreOfParentheses(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}