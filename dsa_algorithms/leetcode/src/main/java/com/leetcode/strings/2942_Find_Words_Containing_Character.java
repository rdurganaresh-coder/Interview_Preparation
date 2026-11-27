package com.leetcode.strings;

class Solution2942 {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < words.length; ++i) {
            if (words[i].indexOf(x) != -1) {
                ans.add(i);
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
        Solution2942 _tcSol = new Solution2942();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"leet\",\"code\"], x = \"e\"");
        try {
            String[] words = new String[]{"leet", "code"};
            char x = 'e';
            System.out.println("  Output  : " + _tcShow(_tcSol.findWordsContaining(words, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"abc\",\"bcd\",\"aaaa\",\"cbc\"], x = \"a\"");
        try {
            String[] words = new String[]{"abc", "bcd", "aaaa", "cbc"};
            char x = 'a';
            System.out.println("  Output  : " + _tcShow(_tcSol.findWordsContaining(words, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,2]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "words = [\"abc\",\"bcd\",\"aaaa\",\"cbc\"], x = \"z\"");
        try {
            String[] words = new String[]{"abc", "bcd", "aaaa", "cbc"};
            char x = 'z';
            System.out.println("  Output  : " + _tcShow(_tcSol.findWordsContaining(words, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}