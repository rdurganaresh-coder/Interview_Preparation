package com.leetcode.dynamic_programming;

class Solution0005_2 {
    private String s;
    private int n;

    public String longestPalindrome(String s) {
        this.s = s;
        n = s.length();
        int start = 0, mx = 1;
        for (int i = 0; i < n; ++i) {
            int a = f(i, i);
            int b = f(i, i + 1);
            int t = Math.max(a, b);
            if (mx < t) {
                mx = t;
                start = i - ((t - 1) >> 1);
            }
        }
        return s.substring(start, start + mx);
    }

    private int f(int l, int r) {
        while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            --l;
            ++r;
        }
        return r - l - 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0005_2 _tcSol = new Solution0005_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"babad\"");
        try {
            String s = "babad";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestPalindrome(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"bab\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"cbbd\"");
        try {
            String s = "cbbd";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestPalindrome(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"bb\"");
        System.out.println();
    }
}