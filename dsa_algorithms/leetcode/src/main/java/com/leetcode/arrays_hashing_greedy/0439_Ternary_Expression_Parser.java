package com.leetcode.arrays_hashing_greedy;

class Solution0439 {
    public String parseTernary(String expression) {
        Deque<Character> stk = new ArrayDeque<>();
        boolean cond = false;
        for (int i = expression.length() - 1; i >= 0; --i) {
            char c = expression.charAt(i);
            if (c == ':') {
                continue;
            }
            if (c == '?') {
                cond = true;
            } else {
                if (cond) {
                    if (c == 'T') {
                        char x = stk.pop();
                        stk.pop();
                        stk.push(x);
                    } else {
                        stk.pop();
                    }
                    cond = false;
                } else {
                    stk.push(c);
                }
            }
        }
        return String.valueOf(stk.peek());
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0439 _tcSol = new Solution0439();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "expression = \"T?2:3\"");
        try {
            String expression = "T?2:3";
            System.out.println("  Output  : " + _tcShow(_tcSol.parseTernary(expression)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"2\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "expression = \"F?1:T?4:5\"");
        try {
            String expression = "F?1:T?4:5";
            System.out.println("  Output  : " + _tcShow(_tcSol.parseTernary(expression)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"4\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "expression = \"T?T?F:5:3\"");
        try {
            String expression = "T?T?F:5:3";
            System.out.println("  Output  : " + _tcShow(_tcSol.parseTernary(expression)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"F\"");
        System.out.println();
    }
}