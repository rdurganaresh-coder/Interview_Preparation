package com.leetcode.arrays_hashing_greedy;

class Solution3302 {
    public int[] validSequence(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        int[] suf = new int[m + 1];
        suf[m] = n;

        int j = n - 1;
        for (int i = m - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                j--;
            }
            suf[i] = j + 1;
        }

        int[] ans = new int[n];
        int size = 0;
        boolean changed = false;
        j = 0;

        for (int i = 0; i < m; i++) {
            char c = word1.charAt(i);
            if (c == word2.charAt(j) || (!changed && suf[i + 1] <= j + 1)) {
                if (c != word2.charAt(j)) {
                    changed = true;
                }
                ans[size++] = i;
                j++;
                if (j == n) {
                    return ans;
                }
            }
        }

        return new int[0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3302 _tcSol = new Solution3302();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word1 = \"vbcca\", word2 = \"abc\"");
        try {
            String word1 = "vbcca";
            String word2 = "abc";
            System.out.println("  Output  : " + _tcShow(_tcSol.validSequence(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word1 = \"bacdc\", word2 = \"abc\"");
        try {
            String word1 = "bacdc";
            String word2 = "abc";
            System.out.println("  Output  : " + _tcShow(_tcSol.validSequence(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,4]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "word1 = \"aaaaaa\", word2 = \"aaabc\"");
        try {
            String word1 = "aaaaaa";
            String word2 = "aaabc";
            System.out.println("  Output  : " + _tcShow(_tcSol.validSequence(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "word1 = \"abc\", word2 = \"ab\"");
        try {
            String word1 = "abc";
            String word2 = "ab";
            System.out.println("  Output  : " + _tcShow(_tcSol.validSequence(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1]");
        System.out.println();
    }
}