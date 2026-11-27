package com.leetcode.strings;

class Solution3271 {
    public String stringHash(String s, int k) {
        StringBuilder ans = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i += k) {
            int t = 0;
            for (int j = i; j < i + k; ++j) {
                t += s.charAt(j) - 'a';
            }
            int hashedChar = t % 26;
            ans.append((char) ('a' + hashedChar));
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3271 _tcSol = new Solution3271();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abcd\", k = 2");
        try {
            String s = "abcd";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.stringHash(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"bf\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"mxz\", k = 3");
        try {
            String s = "mxz";
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.stringHash(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"i\"");
        System.out.println();
    }
}
