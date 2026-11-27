package com.leetcode.strings;

class Solution2085 {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> cnt1 = new HashMap<>();
        Map<String, Integer> cnt2 = new HashMap<>();
        for (var w : words1) {
            cnt1.merge(w, 1, Integer::sum);
        }
        for (var w : words2) {
            cnt2.merge(w, 1, Integer::sum);
        }
        int ans = 0;
        for (var e : cnt1.entrySet()) {
            if (e.getValue() == 1 && cnt2.getOrDefault(e.getKey(), 0) == 1) {
                ++ans;
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
        Solution2085 _tcSol = new Solution2085();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words1 = [\"leetcode\",\"is\",\"amazing\",\"as\",\"is\"], words2 = [\"amazing\",\"leetcode\",\"is\"]");
        try {
            String[] words1 = new String[]{"leetcode", "is", "amazing", "as", "is"};
            String[] words2 = new String[]{"amazing", "leetcode", "is"};
            System.out.println("  Output  : " + _tcShow(_tcSol.countWords(words1, words2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words1 = [\"b\",\"bb\",\"bbb\"], words2 = [\"a\",\"aa\",\"aaa\"]");
        try {
            String[] words1 = new String[]{"b", "bb", "bbb"};
            String[] words2 = new String[]{"a", "aa", "aaa"};
            System.out.println("  Output  : " + _tcShow(_tcSol.countWords(words1, words2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "words1 = [\"a\",\"ab\"], words2 = [\"a\",\"a\",\"a\",\"ab\"]");
        try {
            String[] words1 = new String[]{"a", "ab"};
            String[] words2 = new String[]{"a", "a", "a", "ab"};
            System.out.println("  Output  : " + _tcShow(_tcSol.countWords(words1, words2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}