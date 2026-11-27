package com.leetcode.strings;

class Solution1247 {
    public int minimumSwap(String s1, String s2) {
        int xy = 0, yx = 0;
        for (int i = 0; i < s1.length(); ++i) {
            char a = s1.charAt(i), b = s2.charAt(i);
            if (a < b) {
                ++xy;
            }
            if (a > b) {
                ++yx;
            }
        }
        if ((xy + yx) % 2 == 1) {
            return -1;
        }
        return xy / 2 + yx / 2 + xy % 2 + yx % 2;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1247 _tcSol = new Solution1247();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s1 = \"xx\", s2 = \"yy\"");
        try {
            String s1 = "xx";
            String s2 = "yy";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSwap(s1, s2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s1 = \"xy\", s2 = \"yx\"");
        try {
            String s1 = "xy";
            String s2 = "yx";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSwap(s1, s2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s1 = \"xx\", s2 = \"xy\"");
        try {
            String s1 = "xx";
            String s2 = "xy";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSwap(s1, s2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}