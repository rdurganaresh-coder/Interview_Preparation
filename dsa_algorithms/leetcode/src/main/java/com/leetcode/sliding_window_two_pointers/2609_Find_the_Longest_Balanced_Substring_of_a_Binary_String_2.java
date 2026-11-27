package com.leetcode.sliding_window_two_pointers;

class Solution2609_2 {
    public int findTheLongestBalancedSubstring(String s) {
        int zero = 0, one = 0;
        int ans = 0, n = s.length();
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '0') {
                if (one > 0) {
                    zero = 0;
                    one = 0;
                }
                ++zero;
            } else {
                ans = Math.max(ans, 2 * Math.min(zero, ++one));
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
        Solution2609_2 _tcSol = new Solution2609_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"01000111\"");
        try {
            String s = "01000111";
            System.out.println("  Output  : " + _tcShow(_tcSol.findTheLongestBalancedSubstring(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"00111\"");
        try {
            String s = "00111";
            System.out.println("  Output  : " + _tcShow(_tcSol.findTheLongestBalancedSubstring(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"111\"");
        try {
            String s = "111";
            System.out.println("  Output  : " + _tcShow(_tcSol.findTheLongestBalancedSubstring(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}