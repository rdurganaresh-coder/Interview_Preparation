package com.leetcode.strings;

class Solution2042 {
    public boolean areNumbersAscending(String s) {
        int pre = 0;
        for (var t : s.split(" ")) {
            if (t.charAt(0) <= '9') {
                int cur = Integer.parseInt(t);
                if (pre >= cur) {
                    return false;
                }
                pre = cur;
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
        Solution2042 _tcSol = new Solution2042();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"1 box has 3 blue 4 red 6 green and 12 yellow marbles\"");
        try {
            String s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
            System.out.println("  Output  : " + _tcShow(_tcSol.areNumbersAscending(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"hello world 5 x 5\"");
        try {
            String s = "hello world 5 x 5";
            System.out.println("  Output  : " + _tcShow(_tcSol.areNumbersAscending(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s\"");
        try {
            String s = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s";
            System.out.println("  Output  : " + _tcShow(_tcSol.areNumbersAscending(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}