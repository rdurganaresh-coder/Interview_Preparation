package com.leetcode.trees_tries;

class Trie1804 {
    private Trie1804[] children = new Trie1804[26];
    private int v;
    private int pv;

    public Trie1804() {
    }

    public void insert(String word) {
        Trie1804 node = this;
        for (char c : word.toCharArray()) {
            c -= 'a';
            if (node.children[c] == null) {
                node.children[c] = new Trie1804();
            }
            node = node.children[c];
            ++node.pv;
        }
        ++node.v;
    }

    public int countWordsEqualTo(String word) {
        Trie1804 node = search(word);
        return node == null ? 0 : node.v;
    }

    public int countWordsStartingWith(String prefix) {
        Trie1804 node = search(prefix);
        return node == null ? 0 : node.pv;
    }

    public void erase(String word) {
        Trie1804 node = this;
        for (char c : word.toCharArray()) {
            c -= 'a';
            node = node.children[c];
            --node.pv;
        }
        --node.v;
    }

    private Trie1804 search(String word) {
        Trie1804 node = this;
        for (char c : word.toCharArray()) {
            c -= 'a';
            if (node.children[c] == null) {
                return null;
            }
            node = node.children[c];
        }
        return node;
    }
}

/**
 * Your Trie1804 object will be instantiated and called as such:
 * Trie1804 obj = new Trie1804();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */