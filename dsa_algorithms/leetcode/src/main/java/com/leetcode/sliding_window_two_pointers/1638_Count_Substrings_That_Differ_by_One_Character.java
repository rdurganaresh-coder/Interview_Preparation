package com.leetcode.sliding_window_two_pointers;

class Solution1638 {
    public int countSubstrings(String s, String t) {
        int ans = 0;
        int m = s.length(), n = t.length();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (s.charAt(i) != t.charAt(j)) {
                    int l = 0, r = 0;
                    while (i - l > 0 && j - l > 0 && s.charAt(i - l - 1) == t.charAt(j - l - 1)) {
                        ++l;
                    }
                    while (i + r + 1 < m && j + r + 1 < n
                        && s.charAt(i + r + 1) == t.charAt(j + r + 1)) {
                        ++r;
                    }
                    ans += (l + 1) * (r + 1);
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
        Solution1638 _tcSol = new Solution1638();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"aba\", t = \"baba\"");
        try {
            String s = "aba";
            String t = "baba";
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubstrings(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"ab\", t = \"bb\"");
        try {
            String s = "ab";
            String t = "bb";
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubstrings(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}