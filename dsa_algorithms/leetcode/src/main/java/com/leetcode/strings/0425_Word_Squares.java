package com.leetcode.strings;

class Trie0425 {
    Trie0425[] children = new Trie0425[26];
    List<Integer> v = new ArrayList<>();

    void insert(String word, int i) {
        Trie0425 node = this;
        for (char c : word.toCharArray()) {
            c -= 'a';
            if (node.children[c] == null) {
                node.children[c] = new Trie0425();
            }
            node = node.children[c];
            node.v.add(i);
        }
    }

    List<Integer> search(String pref) {
        Trie0425 node = this;
        for (char c : pref.toCharArray()) {
            c -= 'a';
            if (node.children[c] == null) {
                return Collections.emptyList();
            }
            node = node.children[c];
        }
        return node.v;
    }
}

class Solution0425 {
    private Trie0425 trie = new Trie0425();
    private String[] words;
    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> wordSquares(String[] words) {
        this.words = words;
        for (int i = 0; i < words.length; ++i) {
            trie.insert(words[i], i);
        }

        List<String> t = new ArrayList<>();
        for (String w : words) {
            t.add(w);
            dfs(t);
            t.remove(t.size() - 1);
        }
        return ans;
    }

    private void dfs(List<String> t) {
        if (t.size() == words[0].length()) {
            ans.add(new ArrayList<>(t));
            return;
        }
        int idx = t.size();
        StringBuilder pref = new StringBuilder();
        for (String x : t) {
            pref.append(x.charAt(idx));
        }
        List<Integer> indexes = trie.search(pref.toString());
        for (int i : indexes) {
            t.add(words[i]);
            dfs(t);
            t.remove(t.size() - 1);
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0425 _tcSol = new Solution0425();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"area\",\"lead\",\"wall\",\"lady\",\"ball\"]");
        try {
            String[] words = new String[]{"area", "lead", "wall", "lady", "ball"};
            System.out.println("  Output  : " + _tcShow(_tcSol.wordSquares(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"ball\",\"area\",\"lead\",\"lady\"],[\"wall\",\"area\",\"lead\",\"lady\"]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"abat\",\"baba\",\"atan\",\"atal\"]");
        try {
            String[] words = new String[]{"abat", "baba", "atan", "atal"};
            System.out.println("  Output  : " + _tcShow(_tcSol.wordSquares(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"baba\",\"abat\",\"baba\",\"atal\"],[\"baba\",\"abat\",\"baba\",\"atan\"]]");
        System.out.println();
    }
}