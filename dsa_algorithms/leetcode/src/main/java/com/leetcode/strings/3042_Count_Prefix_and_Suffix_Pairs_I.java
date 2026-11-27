package com.leetcode.strings;

class Solution3042 {
    public int countPrefixSuffixPairs(String[] words) {
        int ans = 0;
        int n = words.length;
        for (int i = 0; i < n; ++i) {
            String s = words[i];
            for (int j = i + 1; j < n; ++j) {
                String t = words[j];
                if (t.startsWith(s) && t.endsWith(s)) {
                    ++ans;
                }
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
        Solution3042 _tcSol = new Solution3042();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"a\",\"aba\",\"ababa\",\"aa\"]");
        try {
            String[] words = new String[]{"a", "aba", "ababa", "aa"};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPrefixSuffixPairs(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"pa\",\"papa\",\"ma\",\"mama\"]");
        try {
            String[] words = new String[]{"pa", "papa", "ma", "mama"};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPrefixSuffixPairs(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "words = [\"abab\",\"ab\"]");
        try {
            String[] words = new String[]{"abab", "ab"};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPrefixSuffixPairs(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}