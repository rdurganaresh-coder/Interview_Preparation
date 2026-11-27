package com.leetcode.sliding_window_two_pointers;

class Solution0409 {
    public int longestPalindrome(String s) {
        int[] cnt = new int[128];
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            ++cnt[s.charAt(i)];
        }
        int ans = 0;
        for (int v : cnt) {
            ans += v / 2 * 2;
        }
        ans += ans < n ? 1 : 0;
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0409 _tcSol = new Solution0409();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abccccdd\"");
        try {
            String s = "abccccdd";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestPalindrome(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"a\"");
        try {
            String s = "a";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestPalindrome(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}