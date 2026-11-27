package com.leetcode.dynamic_programming;

class Solution2311 {
    public int longestSubsequence(String s, int k) {
        int ans = 0, v = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) == '0') {
                ++ans;
            } else if (ans < 30 && (v | 1 << ans) <= k) {
                v |= 1 << ans;
                ++ans;
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
        Solution2311 _tcSol = new Solution2311();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"1001010\", k = 5");
        try {
            String s = "1001010";
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.longestSubsequence(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"00101001\", k = 1");
        try {
            String s = "00101001";
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.longestSubsequence(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}