package com.leetcode.sliding_window_two_pointers;

class Solution2696 {
    public int minLength(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        stk.push(' ');
        for (char c : s.toCharArray()) {
            if ((c == 'B' && stk.peek() == 'A') || (c == 'D' && stk.peek() == 'C')) {
                stk.pop();
            } else {
                stk.push(c);
            }
        }
        return stk.size() - 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2696 _tcSol = new Solution2696();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"ABFCACDB\"");
        try {
            String s = "ABFCACDB";
            System.out.println("  Output  : " + _tcShow(_tcSol.minLength(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"ACBBD\"");
        try {
            String s = "ACBBD";
            System.out.println("  Output  : " + _tcShow(_tcSol.minLength(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}