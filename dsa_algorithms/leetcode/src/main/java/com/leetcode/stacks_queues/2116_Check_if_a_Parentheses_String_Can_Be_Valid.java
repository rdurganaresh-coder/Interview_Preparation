package com.leetcode.stacks_queues;

class Solution2116 {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        int x = 0;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(' || locked.charAt(i) == '0') {
                ++x;
            } else if (x > 0) {
                --x;
            } else {
                return false;
            }
        }
        x = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt(i) == ')' || locked.charAt(i) == '0') {
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
        Solution2116 _tcSol = new Solution2116();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"))()))\", locked = \"010100\"");
        try {
            String s = "))()))";
            String locked = "010100";
            System.out.println("  Output  : " + _tcShow(_tcSol.canBeValid(s, locked)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"()()\", locked = \"0000\"");
        try {
            String s = "()()";
            String locked = "0000";
            System.out.println("  Output  : " + _tcShow(_tcSol.canBeValid(s, locked)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \")\", locked = \"0\"");
        try {
            String s = ")";
            String locked = "0";
            System.out.println("  Output  : " + _tcShow(_tcSol.canBeValid(s, locked)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "s = \"(((())(((())\", locked = \"111111010111\"");
        try {
            String s = "(((())(((())";
            String locked = "111111010111";
            System.out.println("  Output  : " + _tcShow(_tcSol.canBeValid(s, locked)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}