package com.leetcode.strings;

class Solution3106 {
    public String getSmallestString(String s, int k) {
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; ++i) {
            char c1 = cs[i];
            for (char c2 = 'a'; c2 < c1; ++c2) {
                int d = Math.min(c1 - c2, 26 - c1 + c2);
                if (d <= k) {
                    cs[i] = c2;
                    k -= d;
                    break;
                }
            }
        }
        return new String(cs);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3106 _tcSol = new Solution3106();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"zbbz\", k = 3");
        try {
            String s = "zbbz";
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.getSmallestString(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aaaz\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"xaxcd\", k = 4");
        try {
            String s = "xaxcd";
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.getSmallestString(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aawcd\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"lol\", k = 0");
        try {
            String s = "lol";
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.getSmallestString(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"lol\"");
        System.out.println();
    }
}