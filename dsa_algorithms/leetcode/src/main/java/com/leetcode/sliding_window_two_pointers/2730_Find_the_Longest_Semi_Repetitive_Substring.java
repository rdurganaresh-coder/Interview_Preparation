package com.leetcode.sliding_window_two_pointers;

class Solution2730 {
    public int longestSemiRepetitiveSubstring(String s) {
        int ans = 1, n = s.length();
        for (int i = 1, j = 0, cnt = 0; i < n; ++i) {
            cnt += s.charAt(i) == s.charAt(i - 1) ? 1 : 0;
            for (; cnt > 1; ++j) {
                cnt -= s.charAt(j) == s.charAt(j + 1) ? 1 : 0;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2730 _tcSol = new Solution2730();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"52233\"");
        try {
            String s = "52233";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestSemiRepetitiveSubstring(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"5494\"");
        try {
            String s = "5494";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestSemiRepetitiveSubstring(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"1111111\"");
        try {
            String s = "1111111";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestSemiRepetitiveSubstring(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}