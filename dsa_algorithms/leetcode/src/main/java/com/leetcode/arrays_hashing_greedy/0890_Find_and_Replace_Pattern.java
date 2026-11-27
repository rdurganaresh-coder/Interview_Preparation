package com.leetcode.arrays_hashing_greedy;

class Solution0890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern)) {
                ans.add(word);
            }
        }
        return ans;
    }

    private boolean match(String s, String t) {
        int[] m1 = new int[128];
        int[] m2 = new int[128];
        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (m1[c1] != m2[c2]) {
                return false;
            }
            m1[c1] = i + 1;
            m2[c2] = i + 1;
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0890 _tcSol = new Solution0890();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"abc\",\"deq\",\"mee\",\"aqq\",\"dkd\",\"ccc\"], pattern = \"abb\"");
        try {
            String[] words = new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"};
            String pattern = "abb";
            System.out.println("  Output  : " + _tcShow(_tcSol.findAndReplacePattern(words, pattern)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"mee\",\"aqq\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"a\",\"b\",\"c\"], pattern = \"a\"");
        try {
            String[] words = new String[]{"a", "b", "c"};
            String pattern = "a";
            System.out.println("  Output  : " + _tcShow(_tcSol.findAndReplacePattern(words, pattern)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"a\",\"b\",\"c\"]");
        System.out.println();
    }
}