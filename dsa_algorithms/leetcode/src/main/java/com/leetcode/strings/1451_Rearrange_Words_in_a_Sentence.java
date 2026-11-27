package com.leetcode.strings;

class Solution1451 {
    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        words[0] = words[0].toLowerCase();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        words[0] = words[0].substring(0, 1).toUpperCase() + words[0].substring(1);
        return String.join(" ", words);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1451 _tcSol = new Solution1451();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "text = \"Leetcode is cool\"");
        try {
            String text = "Leetcode is cool";
            System.out.println("  Output  : " + _tcShow(_tcSol.arrangeWords(text)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Is cool leetcode\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "text = \"Keep calm and code on\"");
        try {
            String text = "Keep calm and code on";
            System.out.println("  Output  : " + _tcShow(_tcSol.arrangeWords(text)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"On and keep calm code\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "text = \"To be or not to be\"");
        try {
            String text = "To be or not to be";
            System.out.println("  Output  : " + _tcShow(_tcSol.arrangeWords(text)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"To be or to be not\"");
        System.out.println();
    }
}