package com.leetcode.sliding_window_two_pointers;

class Solution3407 {
    public boolean hasMatch(String s, String p) {
        int i = 0;
        for (String t : p.split("\\*")) {
            int j = s.indexOf(t, i);
            if (j == -1) {
                return false;
            }
            i = j + t.length();
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3407 _tcSol = new Solution3407();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"leetcode\", p = \"ee*e\"");
        try {
            String s = "leetcode";
            String p = "ee*e";
            System.out.println("  Output  : " + _tcShow(_tcSol.hasMatch(s, p)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"car\", p = \"c*v\"");
        try {
            String s = "car";
            String p = "c*v";
            System.out.println("  Output  : " + _tcShow(_tcSol.hasMatch(s, p)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"luck\", p = \"u*\"");
        try {
            String s = "luck";
            String p = "u*";
            System.out.println("  Output  : " + _tcShow(_tcSol.hasMatch(s, p)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}
