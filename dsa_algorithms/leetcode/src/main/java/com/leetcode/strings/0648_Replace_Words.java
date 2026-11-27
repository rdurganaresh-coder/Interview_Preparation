package com.leetcode.strings;

class Trie0648 {
    Trie0648[] children = new Trie0648[26];
    boolean isEnd = false;

    void insert(String w) {
        Trie0648 node = this;
        for (char c : w.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie0648();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    String search(String w) {
        Trie0648 node = this;
        for (int i = 0; i < w.length(); i++) {
            int idx = w.charAt(i) - 'a';
            if (node.children[idx] == null) {
                return w;
            }
            node = node.children[idx];
            if (node.isEnd) {
                return w.substring(0, i + 1);
            }
        }
        return w;
    }
}

class Solution0648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie0648 trie = new Trie0648();
        for (String w : dictionary) {
            trie.insert(w);
        }

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = trie.search(words[i]);
        }
        return String.join(" ", words);
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
        Solution0648 _tcSol = new Solution0648();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "dictionary = [\"cat\",\"bat\",\"rat\"], sentence = \"the cattle was rattled by the battery\"");
        try {
            List<String> dictionary = _tcL("cat", "bat", "rat");
            String sentence = "the cattle was rattled by the battery";
            System.out.println("  Output  : " + _tcShow(_tcSol.replaceWords(dictionary, sentence)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"the cat was rat by the bat\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "dictionary = [\"a\",\"b\",\"c\"], sentence = \"aadsfasf absbs bbab cadsfafs\"");
        try {
            List<String> dictionary = _tcL("a", "b", "c");
            String sentence = "aadsfasf absbs bbab cadsfafs";
            System.out.println("  Output  : " + _tcShow(_tcSol.replaceWords(dictionary, sentence)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"a a b c\"");
        System.out.println();
    }
}
