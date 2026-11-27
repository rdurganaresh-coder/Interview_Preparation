package com.leetcode.strings;

class Solution1935 {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] s = new boolean[26];
        for (char c : brokenLetters.toCharArray()) {
            s[c - 'a'] = true;
        }
        int ans = 0;
        for (String w : text.split(" ")) {
            for (char c : w.toCharArray()) {
                if (s[c - 'a']) {
                    --ans;
                    break;
                }
            }
            ++ans;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1935 _tcSol = new Solution1935();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "text = \"hello world\", brokenLetters = \"ad\"");
        try {
            String text = "hello world";
            String brokenLetters = "ad";
            System.out.println("  Output  : " + _tcShow(_tcSol.canBeTypedWords(text, brokenLetters)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "text = \"leet code\", brokenLetters = \"lt\"");
        try {
            String text = "leet code";
            String brokenLetters = "lt";
            System.out.println("  Output  : " + _tcShow(_tcSol.canBeTypedWords(text, brokenLetters)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "text = \"leet code\", brokenLetters = \"e\"");
        try {
            String text = "leet code";
            String brokenLetters = "e";
            System.out.println("  Output  : " + _tcShow(_tcSol.canBeTypedWords(text, brokenLetters)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}