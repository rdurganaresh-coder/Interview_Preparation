package com.leetcode.stacks_queues;

class Solution1614 {
    public int maxDepth(String s) {
        int ans = 0, d = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                ans = Math.max(ans, ++d);
            } else if (c == ')') {
                --d;
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
        Solution1614 _tcSol = new Solution1614();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"(1+(2*3)+((8)/4))+1\"");
        try {
            String s = "(1+(2*3)+((8)/4))+1";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDepth(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"(1)+((2))+(((3)))\"");
        try {
            String s = "(1)+((2))+(((3)))";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDepth(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"()(())((()()))\"");
        try {
            String s = "()(())((()()))";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDepth(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}