package com.leetcode.trees_tries;

class Trie0208 {
    private Trie0208[] children;
    private boolean isEnd;

    public Trie0208() {
        children = new Trie0208[26];
    }

    public void insert(String word) {
        Trie0208 node = this;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie0208();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie0208 node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie0208 node = searchPrefix(prefix);
        return node != null;
    }

    private Trie0208 searchPrefix(String s) {
        Trie0208 node = this;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                return null;
            }
            node = node.children[idx];
        }
        return node;
    }
}

/**
 * Your Trie0208 object will be instantiated and called as such:
 * Trie0208 obj = new Trie0208();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */