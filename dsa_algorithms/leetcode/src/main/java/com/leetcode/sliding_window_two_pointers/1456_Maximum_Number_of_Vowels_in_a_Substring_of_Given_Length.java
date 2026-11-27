package com.leetcode.sliding_window_two_pointers;

class Solution1456 {
    public int maxVowels(String s, int k) {
        int cnt = 0;
        for (int i = 0; i < k; ++i) {
            if (isVowel(s.charAt(i))) {
                ++cnt;
            }
        }
        int ans = cnt;
        for (int i = k; i < s.length(); ++i) {
            if (isVowel(s.charAt(i))) {
                ++cnt;
            }
            if (isVowel(s.charAt(i - k))) {
                --cnt;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1456 _tcSol = new Solution1456();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abciiidef\", k = 3");
        try {
            String s = "abciiidef";
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxVowels(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aeiou\", k = 2");
        try {
            String s = "aeiou";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxVowels(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"leetcode\", k = 3");
        try {
            String s = "leetcode";
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxVowels(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}