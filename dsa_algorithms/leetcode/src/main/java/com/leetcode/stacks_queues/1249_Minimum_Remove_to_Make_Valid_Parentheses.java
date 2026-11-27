package com.leetcode.stacks_queues;

class Solution1249 {
    public String minRemoveToMakeValid(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        int x = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == ')' && x == 0) {
                continue;
            }
            if (c == '(') {
                ++x;
            } else if (c == ')') {
                --x;
            }
            stk.push(c);
        }
        StringBuilder ans = new StringBuilder();
        x = 0;
        while (!stk.isEmpty()) {
            char c = stk.pop();
            if (c == '(' && x == 0) {
                continue;
            }
            if (c == ')') {
                ++x;
            } else if (c == '(') {
                --x;
            }
            ans.append(c);
        }
        return ans.reverse().toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1249 _tcSol = new Solution1249();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"lee(t(c)o)de)\"");
        try {
            String s = "lee(t(c)o)de)";
            System.out.println("  Output  : " + _tcShow(_tcSol.minRemoveToMakeValid(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"lee(t(c)o)de\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"a)b(c)d\"");
        try {
            String s = "a)b(c)d";
            System.out.println("  Output  : " + _tcShow(_tcSol.minRemoveToMakeValid(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"ab(c)d\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"))((\"");
        try {
            String s = "))((";
            System.out.println("  Output  : " + _tcShow(_tcSol.minRemoveToMakeValid(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();
    }
}