package com.leetcode.strings;

class Solution2586 {
    public int vowelStrings(String[] words, int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; ++i) {
            var w = words[i];
            if (check(w.charAt(0)) && check(w.charAt(w.length() - 1))) {
                ++ans;
            }
        }
        return ans;
    }

    private boolean check(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2586 _tcSol = new Solution2586();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"are\",\"amy\",\"u\"], left = 0, right = 2");
        try {
            String[] words = new String[]{"are", "amy", "u"};
            int left = 0;
            int right = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.vowelStrings(words, left, right)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"hey\",\"aeo\",\"mu\",\"ooo\",\"artro\"], left = 1, right = 4");
        try {
            String[] words = new String[]{"hey", "aeo", "mu", "ooo", "artro"};
            int left = 1;
            int right = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.vowelStrings(words, left, right)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}