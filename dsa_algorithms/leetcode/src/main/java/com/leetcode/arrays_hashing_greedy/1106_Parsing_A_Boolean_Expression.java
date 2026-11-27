package com.leetcode.arrays_hashing_greedy;

class Solution1106 {
    public boolean parseBoolExpr(String expression) {
        Deque<Character> stk = new ArrayDeque<>();
        for (char c : expression.toCharArray()) {
            if (c != '(' && c != ')' && c != ',') {
                stk.push(c);
            } else if (c == ')') {
                int t = 0, f = 0;
                while (stk.peek() == 't' || stk.peek() == 'f') {
                    t += stk.peek() == 't' ? 1 : 0;
                    f += stk.peek() == 'f' ? 1 : 0;
                    stk.pop();
                }
                char op = stk.pop();
                c = 'f';
                if ((op == '!' && f > 0) || (op == '&' && f == 0) || (op == '|' && t > 0)) {
                    c = 't';
                }
                stk.push(c);
            }
        }
        return stk.peek() == 't';
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1106 _tcSol = new Solution1106();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "expression = \"&(|(f))\"");
        try {
            String expression = "&(|(f))";
            System.out.println("  Output  : " + _tcShow(_tcSol.parseBoolExpr(expression)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "expression = \"|(f,f,f,t)\"");
        try {
            String expression = "|(f,f,f,t)";
            System.out.println("  Output  : " + _tcShow(_tcSol.parseBoolExpr(expression)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "expression = \"!(&(f,t))\"");
        try {
            String expression = "!(&(f,t))";
            System.out.println("  Output  : " + _tcShow(_tcSol.parseBoolExpr(expression)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}