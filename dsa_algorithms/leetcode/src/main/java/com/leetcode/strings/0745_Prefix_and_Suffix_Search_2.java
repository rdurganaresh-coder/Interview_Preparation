package com.leetcode.strings;

class Trie0745_2 {
    Trie0745_2[] children = new Trie0745_2[26];
    List<Integer> indexes = new ArrayList<>();

    void insert(String word, int i) {
        Trie0745_2 node = this;
        for (char c : word.toCharArray()) {
            c -= 'a';
            if (node.children[c] == null) {
                node.children[c] = new Trie0745_2();
            }
            node = node.children[c];
            node.indexes.add(i);
        }
    }

    List<Integer> search(String pref) {
        Trie0745_2 node = this;
        for (char c : pref.toCharArray()) {
            c -= 'a';
            if (node.children[c] == null) {
                return Collections.emptyList();
            }
            node = node.children[c];
        }
        return node.indexes;
    }
}

class WordFilter0745_2 {
    private Trie0745_2 p = new Trie0745_2();
    private Trie0745_2 s = new Trie0745_2();

    public WordFilter0745_2(String[] words) {
        for (int i = 0; i < words.length; ++i) {
            String w = words[i];
            p.insert(w, i);
            s.insert(new StringBuilder(w).reverse().toString(), i);
        }
    }

    public int f(String pref, String suff) {
        suff = new StringBuilder(suff).reverse().toString();
        List<Integer> a = p.search(pref);
        List<Integer> b = s.search(suff);
        if (a.isEmpty() || b.isEmpty()) {
            return -1;
        }
        int i = a.size() - 1, j = b.size() - 1;
        while (i >= 0 && j >= 0) {
            int c = a.get(i), d = b.get(j);
            if (c == d) {
                return c;
            }
            if (c > d) {
                --i;
            } else {
                --j;
            }
        }
        return -1;
    }
}

/**
 * Your WordFilter0745_2 object will be instantiated and called as such:
 * WordFilter0745_2 obj = new WordFilter0745_2(words);
 * int param_1 = obj.f(pref,suff);
 */