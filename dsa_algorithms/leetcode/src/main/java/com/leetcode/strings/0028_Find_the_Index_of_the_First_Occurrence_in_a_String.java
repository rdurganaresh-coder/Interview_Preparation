package com.leetcode.strings;

class Solution0028 {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n; ++i) {
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0028 _tcSol = new Solution0028();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "haystack = \"sadbutsad\", needle = \"sad\"");
        try {
            String haystack = "sadbutsad";
            String needle = "sad";
            System.out.println("  Output  : " + _tcShow(_tcSol.strStr(haystack, needle)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "haystack = \"leetcode\", needle = \"leeto\"");
        try {
            String haystack = "leetcode";
            String needle = "leeto";
            System.out.println("  Output  : " + _tcShow(_tcSol.strStr(haystack, needle)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
