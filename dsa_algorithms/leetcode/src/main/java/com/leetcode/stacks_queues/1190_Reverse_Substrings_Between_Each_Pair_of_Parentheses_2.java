package com.leetcode.stacks_queues;

class Solution1190_2 {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] d = new int[n];
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(') {
                stk.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stk.pop();
                d[i] = j;
                d[j] = i;
            }
        }
        StringBuilder ans = new StringBuilder();
        int i = 0, x = 1;
        while (i < n) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = d[i];
                x = -x;
            } else {
                ans.append(s.charAt(i));
            }
            i += x;
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1190_2 _tcSol = new Solution1190_2();
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
