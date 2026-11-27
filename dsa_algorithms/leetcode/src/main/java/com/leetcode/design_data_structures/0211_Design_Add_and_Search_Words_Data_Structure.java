package com.leetcode.design_data_structures;

class Trie0211 {
    Trie0211[] children = new Trie0211[26];
    boolean isEnd;
}

class WordDictionary0211 {
    private Trie0211 trie;

    /** Initialize your data structure here. */
    public WordDictionary0211() {
        trie = new Trie0211();
    }

    public void addWord(String word) {
        Trie0211 node = trie;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie0211();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, trie);
    }

    private boolean search(String word, Trie0211 node) {
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if (c != '.' && node.children[idx] == null) {
                return false;
            }
            if (c == '.') {
                for (Trie0211 child : node.children) {
                    if (child != null && search(word.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false;
            }
            node = node.children[idx];
        }
        return node.isEnd;
    }
}

/**
 * Your WordDictionary0211 object will be instantiated and called as such:
 * WordDictionary0211 obj = new WordDictionary0211();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */