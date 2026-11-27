package com.leetcode.stacks_queues;

class Solution0020 {
    public boolean isValid(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        Map<Character, Character> d = new HashMap<>(3);
        d.put('(', ')');
        d.put('[', ']');
        d.put('{', '}');
        for (char c : s.toCharArray()) {
            if (d.containsKey(c)) {
                stk.push(d.get(c));
            } else if (stk.isEmpty() || stk.pop() != c) {
                return false;
            }
        }
        return stk.isEmpty();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0020 _tcSol = new Solution0020();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"()\"");
        try {
            String s = "()";
            System.out.println("  Output  : " + _tcShow(_tcSol.isValid(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"()[]{}\"");
        try {
            String s = "()[]{}";
            System.out.println("  Output  : " + _tcShow(_tcSol.isValid(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"(]\"");
        try {
            String s = "(]";
            System.out.println("  Output  : " + _tcShow(_tcSol.isValid(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "s = \"([])\"");
        try {
            String s = "([])";
            System.out.println("  Output  : " + _tcShow(_tcSol.isValid(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 5");
        System.out.println("  Input   : " + "s = \"([)]\"");
        try {
            String s = "([)]";
            System.out.println("  Output  : " + _tcShow(_tcSol.isValid(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
