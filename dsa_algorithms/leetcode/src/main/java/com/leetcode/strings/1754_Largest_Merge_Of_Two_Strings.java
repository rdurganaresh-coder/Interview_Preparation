package com.leetcode.strings;

class Solution1754 {
    public String largestMerge(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int i = 0, j = 0;
        StringBuilder ans = new StringBuilder();
        while (i < m && j < n) {
            boolean gt = word1.substring(i).compareTo(word2.substring(j)) > 0;
            ans.append(gt ? word1.charAt(i++) : word2.charAt(j++));
        }
        ans.append(word1.substring(i));
        ans.append(word2.substring(j));
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1754 _tcSol = new Solution1754();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word1 = \"cabaa\", word2 = \"bcaaa\"");
        try {
            String word1 = "cabaa";
            String word2 = "bcaaa";
            System.out.println("  Output  : " + _tcShow(_tcSol.largestMerge(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"cbcabaaaaa\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word1 = \"abcabc\", word2 = \"abdcaba\"");
        try {
            String word1 = "abcabc";
            String word2 = "abdcaba";
            System.out.println("  Output  : " + _tcShow(_tcSol.largestMerge(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"abdcabcabcaba\"");
        System.out.println();
    }
}