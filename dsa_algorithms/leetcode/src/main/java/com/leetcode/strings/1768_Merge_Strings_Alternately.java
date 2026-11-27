package com.leetcode.strings;

class Solution1768 {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < m || i < n; ++i) {
            if (i < m) {
                ans.append(word1.charAt(i));
            }
            if (i < n) {
                ans.append(word2.charAt(i));
            }
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1768 _tcSol = new Solution1768();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word1 = \"abc\", word2 = \"pqr\"");
        try {
            String word1 = "abc";
            String word2 = "pqr";
            System.out.println("  Output  : " + _tcShow(_tcSol.mergeAlternately(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"apbqcr\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word1 = \"ab\", word2 = \"pqrs\"");
        try {
            String word1 = "ab";
            String word2 = "pqrs";
            System.out.println("  Output  : " + _tcShow(_tcSol.mergeAlternately(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"apbqrs\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "word1 = \"abcd\", word2 = \"pq\"");
        try {
            String word1 = "abcd";
            String word2 = "pq";
            System.out.println("  Output  : " + _tcShow(_tcSol.mergeAlternately(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"apbqcd\"");
        System.out.println();
    }
}