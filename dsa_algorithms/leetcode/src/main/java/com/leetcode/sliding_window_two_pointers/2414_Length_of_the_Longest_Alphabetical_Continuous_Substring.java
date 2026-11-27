package com.leetcode.sliding_window_two_pointers;

class Solution2414 {
    public int longestContinuousSubstring(String s) {
        int ans = 1, cnt = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) - s.charAt(i - 1) == 1) {
                ans = Math.max(ans, ++cnt);
            } else {
                cnt = 1;
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
        Solution2414 _tcSol = new Solution2414();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abacaba\"");
        try {
            String s = "abacaba";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestContinuousSubstring(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abcde\"");
        try {
            String s = "abcde";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestContinuousSubstring(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}
