package com.leetcode.strings;

class Trie0140 {
    Trie0140[] children = new Trie0140[26];
    boolean isEnd;

    void insert(String word) {
        Trie0140 node = this;
        for (char c : word.toCharArray()) {
            c -= 'a';
            if (node.children[c] == null) {
                node.children[c] = new Trie0140();
            }
            node = node.children[c];
        }
        node.isEnd = true;
    }

    boolean search(String word) {
        Trie0140 node = this;
        for (char c : word.toCharArray()) {
            c -= 'a';
            if (node.children[c] == null) {
                return false;
            }
            node = node.children[c];
        }
        return node.isEnd;
    }
}

class Solution0140 {
    private Trie0140 trie = new Trie0140();

    public List<String> wordBreak(String s, List<String> wordDict) {
        for (String w : wordDict) {
            trie.insert(w);
        }
        List<List<String>> res = dfs(s);
        return res.stream().map(e -> String.join(" ", e)).collect(Collectors.toList());
    }

    private List<List<String>> dfs(String s) {
        List<List<String>> res = new ArrayList<>();
        if ("".equals(s)) {
            res.add(new ArrayList<>());
            return res;
        }
        for (int i = 1; i <= s.length(); ++i) {
            if (trie.search(s.substring(0, i))) {
                for (List<String> v : dfs(s.substring(i))) {
                    v.add(0, s.substring(0, i));
                    res.add(v);
                }
            }
        }
        return res;
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
        Solution0140 _tcSol = new Solution0140();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"catsanddog\", wordDict = [\"cat\",\"cats\",\"and\",\"sand\",\"dog\"]");
        try {
            String s = "catsanddog";
            List<String> wordDict = _tcL("cat", "cats", "and", "sand", "dog");
            System.out.println("  Output  : " + _tcShow(_tcSol.wordBreak(s, wordDict)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"cats and dog\",\"cat sand dog\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"pineapplepenapple\", wordDict = [\"apple\",\"pen\",\"applepen\",\"pine\",\"pineapple\"]");
        try {
            String s = "pineapplepenapple";
            List<String> wordDict = _tcL("apple", "pen", "applepen", "pine", "pineapple");
            System.out.println("  Output  : " + _tcShow(_tcSol.wordBreak(s, wordDict)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"pine apple pen apple\",\"pineapple pen apple\",\"pine applepen apple\"]");
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
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}