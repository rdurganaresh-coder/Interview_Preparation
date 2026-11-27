package com.leetcode.stacks_queues;

class Solution1190 {
    public String reverseParentheses(String s) {
        StringBuilder stk = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                StringBuilder t = new StringBuilder();
                while (stk.charAt(stk.length() - 1) != '(') {
                    t.append(stk.charAt(stk.length() - 1));
                    stk.deleteCharAt(stk.length() - 1);
                }
                stk.deleteCharAt(stk.length() - 1);
                stk.append(t);
            } else {
                stk.append(c);
            }
        }
        return stk.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1190 _tcSol = new Solution1190();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"(abcd)\"");
        try {
            String s = "(abcd)";
            System.out.println("  Output  : " + _tcShow(_tcSol.reverseParentheses(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"dcba\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"(u(love)i)\"");
        try {
            String s = "(u(love)i)";
            System.out.println("  Output  : " + _tcShow(_tcSol.reverseParentheses(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"iloveu\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"(ed(et(oc))el)\"");
        try {
            String s = "(ed(et(oc))el)";
            System.out.println("  Output  : " + _tcShow(_tcSol.reverseParentheses(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"leetcode\"");
        System.out.println();
    }
}
