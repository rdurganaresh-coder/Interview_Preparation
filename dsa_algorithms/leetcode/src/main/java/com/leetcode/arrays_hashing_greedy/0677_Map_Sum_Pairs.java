package com.leetcode.arrays_hashing_greedy;

class Trie0677 {
    private Trie0677[] children = new Trie0677[26];
    private int val;

    public void insert(String w, int x) {
        Trie0677 node = this;
        for (int i = 0; i < w.length(); ++i) {
            int idx = w.charAt(i) - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie0677();
            }
            node = node.children[idx];
            node.val += x;
        }
    }

    public int search(String w) {
        Trie0677 node = this;
        for (int i = 0; i < w.length(); ++i) {
            int idx = w.charAt(i) - 'a';
            if (node.children[idx] == null) {
                return 0;
            }
            node = node.children[idx];
        }
        return node.val;
    }
}

class MapSum0677 {
    private Map<String, Integer> d = new HashMap<>();
    private Trie0677 trie = new Trie0677();

    public MapSum0677() {
    }

    public void insert(String key, int val) {
        int x = val - d.getOrDefault(key, 0);
        d.put(key, val);
        trie.insert(key, x);
    }

    public int sum(String prefix) {
        return trie.search(prefix);
    }
}

/**
 * Your MapSum0677 object will be instantiated and called as such:
 * MapSum0677 obj = new MapSum0677();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */