package com.leetcode.design_data_structures;

class Trie1166 {
    Map<String, Trie1166> children = new HashMap<>();
    int v;

    Trie1166(int v) {
        this.v = v;
    }

    boolean insert(String w, int v) {
        Trie1166 node = this;
        var ps = w.split("/");
        for (int i = 1; i < ps.length - 1; ++i) {
            var p = ps[i];
            if (!node.children.containsKey(p)) {
                return false;
            }
            node = node.children.get(p);
        }
        if (node.children.containsKey(ps[ps.length - 1])) {
            return false;
        }
        node.children.put(ps[ps.length - 1], new Trie1166(v));
        return true;
    }

    int search(String w) {
        Trie1166 node = this;
        var ps = w.split("/");
        for (int i = 1; i < ps.length; ++i) {
            var p = ps[i];
            if (!node.children.containsKey(p)) {
                return -1;
            }
            node = node.children.get(p);
        }
        return node.v;
    }
}

class FileSystem1166 {
    private Trie1166 trie = new Trie1166(-1);

    public FileSystem1166() {
    }

    public boolean createPath(String path, int value) {
        return trie.insert(path, value);
    }

    public int get(String path) {
        return trie.search(path);
    }
}

/**
 * Your FileSystem1166 object will be instantiated and called as such:
 * FileSystem1166 obj = new FileSystem1166();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */