package com.leetcode.strings;

class Solution1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; ++i) {
            if (words[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1455 _tcSol = new Solution1455();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "sentence = \"i love eating burger\", searchWord = \"burg\"");
        try {
            String sentence = "i love eating burger";
            String searchWord = "burg";
            System.out.println("  Output  : " + _tcShow(_tcSol.isPrefixOfWord(sentence, searchWord)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "sentence = \"this problem is an easy problem\", searchWord = \"pro\"");
        try {
            String sentence = "this problem is an easy problem";
            String searchWord = "pro";
            System.out.println("  Output  : " + _tcShow(_tcSol.isPrefixOfWord(sentence, searchWord)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "sentence = \"i am tired\", searchWord = \"you\"");
        try {
            String sentence = "i am tired";
            String searchWord = "you";
            System.out.println("  Output  : " + _tcShow(_tcSol.isPrefixOfWord(sentence, searchWord)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}