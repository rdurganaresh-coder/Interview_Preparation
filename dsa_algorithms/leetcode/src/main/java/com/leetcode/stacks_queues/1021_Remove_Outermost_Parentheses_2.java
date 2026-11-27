package com.leetcode.stacks_queues;

class Solution1021_2 {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                ++cnt;
            }
            if (cnt > 1) {
                ans.append(c);
            }
            if (c == ')') {
                --cnt;
            }
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1021_2 _tcSol = new Solution1021_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"(()())(())\"");
        try {
            String s = "(()())(())";
            System.out.println("  Output  : " + _tcShow(_tcSol.removeOuterParentheses(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"()()()\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"(()())(())(()(()))\"");
        try {
            String s = "(()())(())(()(()))";
            System.out.println("  Output  : " + _tcShow(_tcSol.removeOuterParentheses(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"()()()()(())\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"()()\"");
        try {
            String s = "()()";
            System.out.println("  Output  : " + _tcShow(_tcSol.removeOuterParentheses(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();
    }
}