package com.leetcode.strings;

class Solution1750 {
    public int minimumLength(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            while (i + 1 < j && s.charAt(i) == s.charAt(i + 1)) {
                ++i;
            }
            while (i < j - 1 && s.charAt(j) == s.charAt(j - 1)) {
                --j;
            }
            ++i;
            --j;
        }
        return Math.max(0, j - i + 1);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1750 _tcSol = new Solution1750();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"ca\"");
        try {
            String s = "ca";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumLength(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"cabaabac\"");
        try {
            String s = "cabaabac";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumLength(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"aabccabba\"");
        try {
            String s = "aabccabba";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumLength(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}