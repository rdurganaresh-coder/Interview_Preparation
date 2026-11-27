package com.leetcode.strings;

class Trie0720 {
    private Trie0720[] children = new Trie0720[26];
    private boolean isEnd = false;

    public void insert(String w) {
        Trie0720 node = this;
        for (char c : w.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie0720();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String w) {
        Trie0720 node = this;
        for (char c : w.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null || !node.children[idx].isEnd) {
                return false;
            }
            node = node.children[idx];
        }
        return true;
    }
}

class Solution0720 {
    public String longestWord(String[] words) {
        Trie0720 trie = new Trie0720();
        for (String w : words) {
            trie.insert(w);
        }
        String ans = "";
        for (String w : words) {
            if (trie.search(w)
                && (ans.length() < w.length()
                    || (ans.length() == w.length() && w.compareTo(ans) < 0))) {
                ans = w;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0720 _tcSol = new Solution0720();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"w\",\"wo\",\"wor\",\"worl\",\"world\"]");
        try {
            String[] words = new String[]{"w", "wo", "wor", "worl", "world"};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestWord(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"world\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"a\",\"banana\",\"app\",\"appl\",\"ap\",\"apply\",\"apple\"]");
        try {
            String[] words = new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestWord(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"apple\"");
        System.out.println();
    }
}
