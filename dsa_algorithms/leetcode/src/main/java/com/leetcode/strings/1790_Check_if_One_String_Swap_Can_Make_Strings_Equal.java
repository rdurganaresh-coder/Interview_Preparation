package com.leetcode.strings;

class Solution1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        int cnt = 0;
        char c1 = 0, c2 = 0;
        for (int i = 0; i < s1.length(); ++i) {
            char a = s1.charAt(i), b = s2.charAt(i);
            if (a != b) {
                if (++cnt > 2 || (cnt == 2 && (a != c2 || b != c1))) {
                    return false;
                }
                c1 = a;
                c2 = b;
            }
        }
        return cnt != 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1790 _tcSol = new Solution1790();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s1 = \"bank\", s2 = \"kanb\"");
        try {
            String s1 = "bank";
            String s2 = "kanb";
            System.out.println("  Output  : " + _tcShow(_tcSol.areAlmostEqual(s1, s2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s1 = \"attack\", s2 = \"defend\"");
        try {
            String s1 = "attack";
            String s2 = "defend";
            System.out.println("  Output  : " + _tcShow(_tcSol.areAlmostEqual(s1, s2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s1 = \"kelb\", s2 = \"kelb\"");
        try {
            String s1 = "kelb";
            String s2 = "kelb";
            System.out.println("  Output  : " + _tcShow(_tcSol.areAlmostEqual(s1, s2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}