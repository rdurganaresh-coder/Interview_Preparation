package com.leetcode.sliding_window_two_pointers;

class Solution1400 {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if (n < k) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt[s.charAt(i) - 'a'];
        }
        int x = 0;
        for (int v : cnt) {
            x += v & 1;
        }
        return x <= k;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1400 _tcSol = new Solution1400();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"annabelle\", k = 2");
        try {
            String s = "annabelle";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.canConstruct(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"leetcode\", k = 3");
        try {
            String s = "leetcode";
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.canConstruct(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"true\", k = 4");
        try {
            String s = "true";
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.canConstruct(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}