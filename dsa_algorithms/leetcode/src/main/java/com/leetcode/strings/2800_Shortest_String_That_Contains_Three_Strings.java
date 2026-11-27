package com.leetcode.strings;

class Solution2800 {
    public String minimumString(String a, String b, String c) {
        String[] s = {a, b, c};
        int[][] perm = {{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 1, 0}, {2, 0, 1}};
        String ans = "";
        for (var p : perm) {
            int i = p[0], j = p[1], k = p[2];
            String t = f(f(s[i], s[j]), s[k]);
            if ("".equals(ans) || t.length() < ans.length()
                || (t.length() == ans.length() && t.compareTo(ans) < 0)) {
                ans = t;
            }
        }
        return ans;
    }

    private String f(String s, String t) {
        if (s.contains(t)) {
            return s;
        }
        if (t.contains(s)) {
            return t;
        }
        int m = s.length(), n = t.length();
        for (int i = Math.min(m, n); i > 0; --i) {
            if (s.substring(m - i).equals(t.substring(0, i))) {
                return s + t.substring(i);
            }
        }
        return s + t;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2800 _tcSol = new Solution2800();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "a = \"abc\", b = \"bca\", c = \"aaa\"");
        try {
            String a = "abc";
            String b = "bca";
            String c = "aaa";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumString(a, b, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aaabca\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "a = \"ab\", b = \"ba\", c = \"aba\"");
        try {
            String a = "ab";
            String b = "ba";
            String c = "aba";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumString(a, b, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aba\"");
        System.out.println();
    }
}