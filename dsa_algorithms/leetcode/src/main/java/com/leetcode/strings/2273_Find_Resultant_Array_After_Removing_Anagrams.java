package com.leetcode.strings;

class Solution2273 {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        for (int i = 1; i < words.length; ++i) {
            if (check(words[i - 1], words[i])) {
                ans.add(words[i]);
            }
        }
        return ans;
    }

    private boolean check(String s, String t) {
        if (s.length() != t.length()) {
            return true;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++cnt[s.charAt(i) - 'a'];
        }
        for (int i = 0; i < t.length(); ++i) {
            if (--cnt[t.charAt(i) - 'a'] < 0) {
                return true;
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2273 _tcSol = new Solution2273();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"abba\",\"baba\",\"bbaa\",\"cd\",\"cd\"]");
        try {
            String[] words = new String[]{"abba", "baba", "bbaa", "cd", "cd"};
            System.out.println("  Output  : " + _tcShow(_tcSol.removeAnagrams(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"abba\",\"cd\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"a\",\"b\",\"c\",\"d\",\"e\"]");
        try {
            String[] words = new String[]{"a", "b", "c", "d", "e"};
            System.out.println("  Output  : " + _tcShow(_tcSol.removeAnagrams(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"a\",\"b\",\"c\",\"d\",\"e\"]");
        System.out.println();
    }
}
