package com.leetcode.strings;

class Solution0139_2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie0139_2 trie = new Trie0139_2();
        for (String w : wordDict) {
            trie.insert(w);
        }
        int n = s.length();
        boolean[] f = new boolean[n + 1];
        f[n] = true;
        for (int i = n - 1; i >= 0; --i) {
            Trie0139_2 node = trie;
            for (int j = i; j < n; ++j) {
                int k = s.charAt(j) - 'a';
                if (node.children[k] == null) {
                    break;
                }
                node = node.children[k];
                if (node.isEnd && f[j + 1]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution0139_2 _tcSol = new Solution0139_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"leetcode\", wordDict = [\"leet\",\"code\"]");
        try {
            String s = "leetcode";
            List<String> wordDict = _tcL("leet", "code");
            System.out.println("  Output  : " + _tcShow(_tcSol.wordBreak(s, wordDict)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"applepenapple\", wordDict = [\"apple\",\"pen\"]");
        try {
            String s = "applepenapple";
            List<String> wordDict = _tcL("apple", "pen");
            System.out.println("  Output  : " + _tcShow(_tcSol.wordBreak(s, wordDict)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"catsandog\", wordDict = [\"cats\",\"dog\",\"sand\",\"and\",\"cat\"]");
        try {
            String s = "catsandog";
            List<String> wordDict = _tcL("cats", "dog", "sand", "and", "cat");
            System.out.println("  Output  : " + _tcShow(_tcSol.wordBreak(s, wordDict)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}

class Trie0139_2 {
    Trie0139_2[] children = new Trie0139_2[26];
    boolean isEnd = false;

    public void insert(String w) {
        Trie0139_2 node = this;
        for (int i = 0; i < w.length(); ++i) {
            int j = w.charAt(i) - 'a';
            if (node.children[j] == null) {
                node.children[j] = new Trie0139_2();
            }
            node = node.children[j];
        }
        node.isEnd = true;
    }
}