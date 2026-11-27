package com.leetcode.design_data_structures;

class Trie0676 {
    private Trie0676[] children = new Trie0676[26];
    private boolean isEnd;

    public void insert(String w) {
        Trie0676 node = this;
        for (char c : w.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) {
                node.children[i] = new Trie0676();
            }
            node = node.children[i];
        }
        node.isEnd = true;
    }

    public boolean search(String w) {
        return dfs(w, 0, this, 0);
    }

    private boolean dfs(String w, int i, Trie0676 node, int diff) {
        if (i == w.length()) {
            return diff == 1 && node.isEnd;
        }
        int j = w.charAt(i) - 'a';
        if (node.children[j] != null) {
            if (dfs(w, i + 1, node.children[j], diff)) {
                return true;
            }
        }
        if (diff == 0) {
            for (int k = 0; k < 26; k++) {
                if (k != j && node.children[k] != null) {
                    if (dfs(w, i + 1, node.children[k], 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

class MagicDictionary0676 {
    private Trie0676 trie = new Trie0676();

    public MagicDictionary0676() {
    }

    public void buildDict(String[] dictionary) {
        for (String w : dictionary) {
            trie.insert(w);
        }
    }

    public boolean search(String searchWord) {
        return trie.search(searchWord);
    }
}

/**
 * Your MagicDictionary0676 object will be instantiated and called as such:
 * MagicDictionary0676 obj = new MagicDictionary0676();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */