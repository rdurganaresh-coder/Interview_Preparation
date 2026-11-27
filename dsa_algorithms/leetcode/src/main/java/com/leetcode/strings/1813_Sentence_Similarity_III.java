package com.leetcode.strings;

class Solution1813 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        var words1 = sentence1.split(" ");
        var words2 = sentence2.split(" ");
        if (words1.length < words2.length) {
            var t = words1;
            words1 = words2;
            words2 = t;
        }
        int m = words1.length, n = words2.length;
        int i = 0, j = 0;
        while (i < n && words1[i].equals(words2[i])) {
            ++i;
        }
        while (j < n && words1[m - 1 - j].equals(words2[n - 1 - j])) {
            ++j;
        }
        return i + j >= n;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1813 _tcSol = new Solution1813();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "sentence1 = \"My name is Haley\", sentence2 = \"My Haley\"");
        try {
            String sentence1 = "My name is Haley";
            String sentence2 = "My Haley";
            System.out.println("  Output  : " + _tcShow(_tcSol.areSentencesSimilar(sentence1, sentence2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "sentence1 = \"of\", sentence2 = \"A lot of words\"");
        try {
            String sentence1 = "of";
            String sentence2 = "A lot of words";
            System.out.println("  Output  : " + _tcShow(_tcSol.areSentencesSimilar(sentence1, sentence2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "sentence1 = \"Eating right now\", sentence2 = \"Eating\"");
        try {
            String sentence1 = "Eating right now";
            String sentence2 = "Eating";
            System.out.println("  Output  : " + _tcShow(_tcSol.areSentencesSimilar(sentence1, sentence2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}