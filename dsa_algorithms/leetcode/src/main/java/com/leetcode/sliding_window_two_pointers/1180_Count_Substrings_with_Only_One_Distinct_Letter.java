package com.leetcode.sliding_window_two_pointers;

class Solution1180 {
    public int countLetters(String s) {
        int ans = 0;
        for (int i = 0, n = s.length(); i < n;) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                ++j;
            }
            ans += (1 + j - i) * (j - i) / 2;
            i = j;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1180 _tcSol = new Solution1180();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"aaaba\"");
        try {
            String s = "aaaba";
            System.out.println("  Output  : " + _tcShow(_tcSol.countLetters(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aaaaaaaaaa\"");
        try {
            String s = "aaaaaaaaaa";
            System.out.println("  Output  : " + _tcShow(_tcSol.countLetters(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "55");
        System.out.println();
    }
}