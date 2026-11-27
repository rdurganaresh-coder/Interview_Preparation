package com.leetcode.strings;

class Solution0557 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; ++i) {
            words[i] = new StringBuilder(words[i]).reverse().toString();
        }
        return String.join(" ", words);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0557 _tcSol = new Solution0557();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"Let's take LeetCode contest\"");
        try {
            String s = "Let's take LeetCode contest";
            System.out.println("  Output  : " + _tcShow(_tcSol.reverseWords(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"s'teL ekat edoCteeL tsetnoc\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"Mr Ding\"");
        try {
            String s = "Mr Ding";
            System.out.println("  Output  : " + _tcShow(_tcSol.reverseWords(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"rM gniD\"");
        System.out.println();
    }
}
