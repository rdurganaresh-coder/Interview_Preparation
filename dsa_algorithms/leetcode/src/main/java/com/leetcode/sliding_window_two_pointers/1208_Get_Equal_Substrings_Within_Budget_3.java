package com.leetcode.sliding_window_two_pointers;

class Solution1208_3 {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int cost = 0, l = 0;
        for (int r = 0; r < n; ++r) {
            cost += Math.abs(s.charAt(r) - t.charAt(r));
            if (cost > maxCost) {
                cost -= Math.abs(s.charAt(l) - t.charAt(l));
                ++l;
            }
        }
        return n - l;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1208_3 _tcSol = new Solution1208_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abcd\", t = \"bcdf\", maxCost = 3");
        try {
            String s = "abcd";
            String t = "bcdf";
            int maxCost = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.equalSubstring(s, t, maxCost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abcd\", t = \"cdef\", maxCost = 3");
        try {
            String s = "abcd";
            String t = "cdef";
            int maxCost = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.equalSubstring(s, t, maxCost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"abcd\", t = \"acde\", maxCost = 0");
        try {
            String s = "abcd";
            String t = "acde";
            int maxCost = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.equalSubstring(s, t, maxCost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
