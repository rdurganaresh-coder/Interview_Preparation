package com.leetcode.strings;

class Trie0472 {
    Trie0472[] children = new Trie0472[26];
    boolean isEnd;

    void insert(String w) {
        Trie0472 node = this;
        for (char c : w.toCharArray()) {
            c -= 'a';
            if (node.children[c] == null) {
                node.children[c] = new Trie0472();
            }
            node = node.children[c];
        }
        node.isEnd = true;
    }
}

class Solution0472 {
    private Trie0472 trie = new Trie0472();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        List<String> ans = new ArrayList<>();
        for (String w : words) {
            if (dfs(w)) {
                ans.add(w);
            } else {
                trie.insert(w);
            }
        }
        return ans;
    }

    private boolean dfs(String w) {
        if ("".equals(w)) {
            return true;
        }
        Trie0472 node = trie;
        for (int i = 0; i < w.length(); ++i) {
            int idx = w.charAt(i) - 'a';
            if (node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
            if (node.isEnd && dfs(w.substring(i + 1))) {
                return true;
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0472 _tcSol = new Solution0472();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"cat\",\"cats\",\"catsdogcats\",\"dog\",\"dogcatsdog\",\"hippopotamuses\",\"rat\",\"ratcatdogcat\"]");
        try {
            String[] words = new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
            System.out.println("  Output  : " + _tcShow(_tcSol.findAllConcatenatedWordsInADict(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"catsdogcats\",\"dogcatsdog\",\"ratcatdogcat\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"cat\",\"dog\",\"catdog\"]");
        try {
            String[] words = new String[]{"cat", "dog", "catdog"};
            System.out.println("  Output  : " + _tcShow(_tcSol.findAllConcatenatedWordsInADict(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"catdog\"]");
        System.out.println();
    }
}