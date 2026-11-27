package com.leetcode.design_data_structures;

class Trie0642 {
    Trie0642[] children = new Trie0642[27];
    int v;
    String w = "";

    void insert(String w, int t) {
        Trie0642 node = this;
        for (char c : w.toCharArray()) {
            int idx = c == ' ' ? 26 : c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie0642();
            }
            node = node.children[idx];
        }
        node.v += t;
        node.w = w;
    }

    Trie0642 search(String pref) {
        Trie0642 node = this;
        for (char c : pref.toCharArray()) {
            int idx = c == ' ' ? 26 : c - 'a';
            if (node.children[idx] == null) {
                return null;
            }
            node = node.children[idx];
        }
        return node;
    }
}

class AutocompleteSystem0642 {
    private Trie0642 trie = new Trie0642();
    private StringBuilder t = new StringBuilder();

    public AutocompleteSystem0642(String[] sentences, int[] times) {
        int i = 0;
        for (String s : sentences) {
            trie.insert(s, times[i++]);
        }
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') {
            trie.insert(t.toString(), 1);
            t = new StringBuilder();
            return res;
        }
        t.append(c);
        Trie0642 node = trie.search(t.toString());
        if (node == null) {
            return res;
        }
        PriorityQueue<Trie0642> q
            = new PriorityQueue<>((a, b) -> a.v == b.v ? b.w.compareTo(a.w) : a.v - b.v);
        dfs(node, q);
        while (!q.isEmpty()) {
            res.add(0, q.poll().w);
        }
        return res;
    }

    private void dfs(Trie0642 node, PriorityQueue q) {
        if (node == null) {
            return;
        }
        if (node.v > 0) {
            q.offer(node);
            if (q.size() > 3) {
                q.poll();
            }
        }
        for (Trie0642 nxt : node.children) {
            dfs(nxt, q);
        }
    }
}

/**
 * Your AutocompleteSystem0642 object will be instantiated and called as such:
 * AutocompleteSystem0642 obj = new AutocompleteSystem0642(sentences, times);
 * List<String> param_1 = obj.input(c);
 */