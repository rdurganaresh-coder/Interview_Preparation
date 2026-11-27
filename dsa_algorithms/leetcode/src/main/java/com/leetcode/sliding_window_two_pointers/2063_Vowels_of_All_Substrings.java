package com.leetcode.sliding_window_two_pointers;

class Solution2063 {
    public long countVowels(String word) {
        long ans = 0;
        for (int i = 0, n = word.length(); i < n; ++i) {
            char c = word.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                ans += (i + 1L) * (n - i);
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
        Solution2063 _tcSol = new Solution2063();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"aba\"");
        try {
            String word = "aba";
            System.out.println("  Output  : " + _tcShow(_tcSol.countVowels(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"abc\"");
        try {
            String word = "abc";
            System.out.println("  Output  : " + _tcShow(_tcSol.countVowels(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "word = \"ltcd\"");
        try {
            String word = "ltcd";
            System.out.println("  Output  : " + _tcShow(_tcSol.countVowels(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}