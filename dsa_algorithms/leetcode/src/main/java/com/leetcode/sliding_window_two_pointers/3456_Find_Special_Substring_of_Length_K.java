package com.leetcode.sliding_window_two_pointers;

class Solution3456 {
    public boolean hasSpecialSubstring(String s, int k) {
        int n = s.length();
        for (int l = 0, cnt = 0; l < n;) {
            int r = l + 1;
            while (r < n && s.charAt(r) == s.charAt(l)) {
                ++r;
            }
            if (r - l == k) {
                return true;
            }
            l = r;
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3456 _tcSol = new Solution3456();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"aaabaaa\", k = 3");
        try {
            String s = "aaabaaa";
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.hasSpecialSubstring(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abc\", k = 2");
        try {
            String s = "abc";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.hasSpecialSubstring(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
