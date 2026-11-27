package com.leetcode.sliding_window_two_pointers;

class Solution0009 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }
        int y = 0;
        for (; y < x; x /= 10) {
            y = y * 10 + x % 10;
        }
        return x == y || x == y / 10;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0009 _tcSol = new Solution0009();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "x = 121");
        try {
            int x = 121;
            System.out.println("  Output  : " + _tcShow(_tcSol.isPalindrome(x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "x = -121");
        try {
            int x = -121;
            System.out.println("  Output  : " + _tcShow(_tcSol.isPalindrome(x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "x = 10");
        try {
            int x = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.isPalindrome(x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}