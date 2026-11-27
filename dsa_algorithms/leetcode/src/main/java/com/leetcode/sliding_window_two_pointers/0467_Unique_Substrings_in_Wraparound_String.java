package com.leetcode.sliding_window_two_pointers;

class Solution0467 {
    public int findSubstringInWraproundString(String s) {
        int[] f = new int[26];
        int n = s.length();
        for (int i = 0, k = 0; i < n; ++i) {
            if (i > 0 && (s.charAt(i) - s.charAt(i - 1) + 26) % 26 == 1) {
                ++k;
            } else {
                k = 1;
            }
            f[s.charAt(i) - 'a'] = Math.max(f[s.charAt(i) - 'a'], k);
        }
        return Arrays.stream(f).sum();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0467 _tcSol = new Solution0467();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"a\"");
        try {
            String s = "a";
            System.out.println("  Output  : " + _tcShow(_tcSol.findSubstringInWraproundString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"cac\"");
        try {
            String s = "cac";
            System.out.println("  Output  : " + _tcShow(_tcSol.findSubstringInWraproundString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"zab\"");
        try {
            String s = "zab";
            System.out.println("  Output  : " + _tcShow(_tcSol.findSubstringInWraproundString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}