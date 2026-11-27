package com.leetcode.strings;

class Solution0151 {
    public String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < n;) {
            while (i < n && s.charAt(i) == ' ') {
                ++i;
            }
            if (i < n) {
                StringBuilder t = new StringBuilder();
                int j = i;
                while (j < n && s.charAt(j) != ' ') {
                    t.append(s.charAt(j++));
                }
                words.add(t.toString());
                i = j;
            }
        }
        Collections.reverse(words);
        return String.join(" ", words);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0151 _tcSol = new Solution0151();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"the sky is blue\"");
        try {
            String s = "the sky is blue";
            System.out.println("  Output  : " + _tcShow(_tcSol.reverseWords(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"blue is sky the\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \" hello world \"");
        try {
            String s = " hello world ";
            System.out.println("  Output  : " + _tcShow(_tcSol.reverseWords(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"world hello\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"a good example\"");
        try {
            String s = "a good example";
            System.out.println("  Output  : " + _tcShow(_tcSol.reverseWords(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"example good a\"");
        System.out.println();
    }
}