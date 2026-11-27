package com.leetcode.sliding_window_two_pointers;

class Solution2131 {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> cnt = new HashMap<>();
        for (var w : words) {
            cnt.merge(w, 1, Integer::sum);
        }
        int ans = 0, x = 0;
        for (var e : cnt.entrySet()) {
            var k = e.getKey();
            var rk = new StringBuilder(k).reverse().toString();
            int v = e.getValue();
            if (k.charAt(0) == k.charAt(1)) {
                x += v & 1;
                ans += v / 2 * 2 * 2;
            } else {
                ans += Math.min(v, cnt.getOrDefault(rk, 0)) * 2;
            }
        }
        ans += x > 0 ? 2 : 0;
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2131 _tcSol = new Solution2131();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"lc\",\"cl\",\"gg\"]");
        try {
            String[] words = new String[]{"lc", "cl", "gg"};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestPalindrome(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"ab\",\"ty\",\"yt\",\"lc\",\"cl\",\"ab\"]");
        try {
            String[] words = new String[]{"ab", "ty", "yt", "lc", "cl", "ab"};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestPalindrome(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "words = [\"cc\",\"ll\",\"xx\"]");
        try {
            String[] words = new String[]{"cc", "ll", "xx"};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestPalindrome(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}