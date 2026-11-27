package com.leetcode.dynamic_programming;

class Solution3517 {
    public String smallestPalindrome(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        StringBuilder t = new StringBuilder();
        String ch = "";

        for (char c = 'a'; c <= 'z'; c++) {
            int idx = c - 'a';
            int v = cnt[idx] / 2;
            if (v > 0) {
                t.append(String.valueOf(c).repeat(v));
            }
            cnt[idx] -= v * 2;
            if (cnt[idx] == 1) {
                ch = String.valueOf(c);
            }
        }

        String ans = t.toString();
        ans = ans + ch + new StringBuilder(ans).reverse();
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3517 _tcSol = new Solution3517();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"z\"");
        try {
            String s = "z";
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestPalindrome(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"z\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"babab\"");
        try {
            String s = "babab";
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestPalindrome(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"abbba\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"daccad\"");
        try {
            String s = "daccad";
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestPalindrome(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"acddca\"");
        System.out.println();
    }
}
