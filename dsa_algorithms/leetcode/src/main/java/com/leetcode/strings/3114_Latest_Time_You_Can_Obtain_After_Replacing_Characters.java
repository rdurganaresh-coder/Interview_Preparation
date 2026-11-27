package com.leetcode.strings;

class Solution3114 {
    public String findLatestTime(String s) {
        for (int h = 11;; h--) {
            for (int m = 59; m >= 0; m--) {
                String t = String.format("%02d:%02d", h, m);
                boolean ok = true;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) != '?' && s.charAt(i) != t.charAt(i)) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    return t;
                }
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3114 _tcSol = new Solution3114();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"1?:?4\"");
        try {
            String s = "1?:?4";
            System.out.println("  Output  : " + _tcShow(_tcSol.findLatestTime(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"11:54\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"0?:5?\"");
        try {
            String s = "0?:5?";
            System.out.println("  Output  : " + _tcShow(_tcSol.findLatestTime(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"09:59\"");
        System.out.println();
    }
}