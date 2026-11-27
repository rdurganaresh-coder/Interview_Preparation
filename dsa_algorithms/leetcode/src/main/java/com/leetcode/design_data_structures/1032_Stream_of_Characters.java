package com.leetcode.design_data_structures;

class Trie1032 {
    Trie1032[] children = new Trie1032[26];
    boolean isEnd = false;

    public void insert(String w) {
        Trie1032 node = this;
        for (int i = w.length() - 1; i >= 0; --i) {
            int idx = w.charAt(i) - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie1032();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public boolean query(StringBuilder s) {
        Trie1032 node = this;
        for (int i = s.length() - 1; i >= 0; --i) {
            int idx = s.charAt(i) - 'a';
            if (node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
            if (node.isEnd) {
                return true;
            }
        }
        return false;
    }
}

class StreamChecker1032 {
    private StringBuilder sb = new StringBuilder();
    private Trie1032 trie = new Trie1032();

    public StreamChecker1032(String[] words) {
        for (String w : words) {
            trie.insert(w);
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        return trie.query(sb);
    }
}

/**
 * Your StreamChecker1032 object will be instantiated and called as such:
 * StreamChecker1032 obj = new StreamChecker1032(words);
 * boolean param_1 = obj.query(letter);
 */