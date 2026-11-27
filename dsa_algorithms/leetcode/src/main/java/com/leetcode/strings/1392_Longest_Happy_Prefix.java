package com.leetcode.strings;

class Solution1392 {
    private long[] p;
    private long[] h;

    public String longestPrefix(String s) {
        int base = 131;
        int n = s.length();
        p = new long[n + 10];
        h = new long[n + 10];
        p[0] = 1;
        for (int i = 0; i < n; ++i) {
            p[i + 1] = p[i] * base;
            h[i + 1] = h[i] * base + s.charAt(i);
        }
        for (int l = n - 1; l > 0; --l) {
            if (get(1, l) == get(n - l + 1, n)) {
                return s.substring(0, l);
            }
        }
        return "";
    }

    private long get(int l, int r) {
        return h[r] - h[l - 1] * p[r - l + 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1392 _tcSol = new Solution1392();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"level\"");
        try {
            String s = "level";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestPrefix(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"l\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"ababab\"");
        try {
            String s = "ababab";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestPrefix(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"abab\"");
        System.out.println();
    }
}