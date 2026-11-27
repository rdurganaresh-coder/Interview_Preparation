package com.leetcode.arrays_hashing_greedy;

class Solution0091_2 {
    public int numDecodings(String s) {
        int n = s.length();
        int f = 0, g = 1;
        for (int i = 1; i <= n; ++i) {
            int h = s.charAt(i - 1) != '0' ? g : 0;
            if (i > 1 && s.charAt(i - 2) != '0' && Integer.valueOf(s.substring(i - 2, i)) <= 26) {
                h += f;
            }
            f = g;
            g = h;
        }
        return g;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0091_2 _tcSol = new Solution0091_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"12\"");
        try {
            String s = "12";
            System.out.println("  Output  : " + _tcShow(_tcSol.numDecodings(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"226\"");
        try {
            String s = "226";
            System.out.println("  Output  : " + _tcShow(_tcSol.numDecodings(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"06\"");
        try {
            String s = "06";
            System.out.println("  Output  : " + _tcShow(_tcSol.numDecodings(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}