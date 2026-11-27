package com.leetcode.strings;

class Solution1625_2 {
    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        String ans = s;
        for (int i = 0; i < n; ++i) {
            s = s.substring(b) + s.substring(0, b);
            char[] cs = s.toCharArray();
            for (int j = 0; j < 10; ++j) {
                for (int k = 1; k < n; k += 2) {
                    cs[k] = (char) (((cs[k] - '0' + a) % 10) + '0');
                }
                if ((b & 1) == 1) {
                    for (int p = 0; p < 10; ++p) {
                        for (int k = 0; k < n; k += 2) {
                            cs[k] = (char) (((cs[k] - '0' + a) % 10) + '0');
                        }
                        s = String.valueOf(cs);
                        if (ans.compareTo(s) > 0) {
                            ans = s;
                        }
                    }
                } else {
                    s = String.valueOf(cs);
                    if (ans.compareTo(s) > 0) {
                        ans = s;
                    }
                }
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
        Solution1625_2 _tcSol = new Solution1625_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"5525\", a = 9, b = 2");
        try {
            String s = "5525";
            int a = 9;
            int b = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.findLexSmallestString(s, a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"2050\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"74\", a = 5, b = 1");
        try {
            String s = "74";
            int a = 5;
            int b = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findLexSmallestString(s, a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"24\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"0011\", a = 4, b = 2");
        try {
            String s = "0011";
            int a = 4;
            int b = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.findLexSmallestString(s, a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"0011\"");
        System.out.println();
    }
}