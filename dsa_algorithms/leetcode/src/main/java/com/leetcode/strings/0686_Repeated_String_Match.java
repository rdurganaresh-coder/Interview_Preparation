package com.leetcode.strings;

class Solution0686 {
    public int repeatedStringMatch(String a, String b) {
        int m = a.length(), n = b.length();
        int ans = (n + m - 1) / m;
        StringBuilder t = new StringBuilder(a.repeat(ans));
        for (int i = 0; i < 3; ++i) {
            if (t.toString().contains(b)) {
                return ans;
            }
            ++ans;
            t.append(a);
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0686 _tcSol = new Solution0686();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "a = \"abcd\", b = \"cdabcdab\"");
        try {
            String a = "abcd";
            String b = "cdabcdab";
            System.out.println("  Output  : " + _tcShow(_tcSol.repeatedStringMatch(a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "a = \"a\", b = \"aa\"");
        try {
            String a = "a";
            String b = "aa";
            System.out.println("  Output  : " + _tcShow(_tcSol.repeatedStringMatch(a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}