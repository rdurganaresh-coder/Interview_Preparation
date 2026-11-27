package com.leetcode.sliding_window_two_pointers;

class Solution3088 {
    public String makeAntiPalindrome(String s) {
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        int n = cs.length;
        int m = n / 2;
        if (cs[m] == cs[m - 1]) {
            int i = m;
            while (i < n && cs[i] == cs[i - 1]) {
                ++i;
            }
            for (int j = m; j < n && cs[j] == cs[n - j - 1]; ++i, ++j) {
                if (i >= n) {
                    return "-1";
                }
                char t = cs[i];
                cs[i] = cs[j];
                cs[j] = t;
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
        Solution3088 _tcSol = new Solution3088();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abca\"");
        try {
            String s = "abca";
            System.out.println("  Output  : " + _tcShow(_tcSol.makeAntiPalindrome(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aabc\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abba\"");
        try {
            String s = "abba";
            System.out.println("  Output  : " + _tcShow(_tcSol.makeAntiPalindrome(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aabb\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"cccd\"");
        try {
            String s = "cccd";
            System.out.println("  Output  : " + _tcShow(_tcSol.makeAntiPalindrome(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"-1\"");
        System.out.println();
    }
}