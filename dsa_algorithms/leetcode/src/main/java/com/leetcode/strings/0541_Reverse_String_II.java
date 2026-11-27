package com.leetcode.strings;

class Solution0541 {
    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 0; i < n; i += k * 2) {
            for (int l = i, r = Math.min(i + k - 1, n - 1); l < r; ++l, --r) {
                char t = cs[l];
                cs[l] = cs[r];
                cs[r] = t;
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
        Solution0541 _tcSol = new Solution0541();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abcdefg\", k = 2");
        try {
            String s = "abcdefg";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.reverseStr(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"bacdfeg\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abcd\", k = 2");
        try {
            String s = "abcd";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.reverseStr(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"bacd\"");
        System.out.println();
    }
}