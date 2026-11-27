package com.leetcode.sliding_window_two_pointers;

class Solution0003 {
    public int lengthOfLongestSubstring(String s) {
        int[] cnt = new int[128];
        int ans = 0, n = s.length();
        for (int l = 0, r = 0; r < n; ++r) {
            char c = s.charAt(r);
            ++cnt[c];
            while (cnt[c] > 1) {
                --cnt[s.charAt(l++)];
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0003 _tcSol = new Solution0003();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abcabcbb\"");
        try {
            String s = "abcabcbb";
            System.out.println("  Output  : " + _tcShow(_tcSol.lengthOfLongestSubstring(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"bbbbb\"");
        try {
            String s = "bbbbb";
            System.out.println("  Output  : " + _tcShow(_tcSol.lengthOfLongestSubstring(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"pwwkew\"");
        try {
            String s = "pwwkew";
            System.out.println("  Output  : " + _tcShow(_tcSol.lengthOfLongestSubstring(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
