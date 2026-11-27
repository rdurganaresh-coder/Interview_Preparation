package com.leetcode.strings;

class Trie1858 {
    private Trie1858[] children = new Trie1858[26];
    private boolean isEnd;

    public Trie1858() {
    }

    public void insert(String w) {
        Trie1858 node = this;
        for (char c : w.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie1858();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String w) {
        Trie1858 node = this;
        for (char c : w.toCharArray()) {
            int idx = c - 'a';
            node = node.children[idx];
            if (!node.isEnd) {
                return false;
            }
        }
        return true;
    }
}

class Solution1858 {
    public String longestWord(String[] words) {
        Trie1858 trie = new Trie1858();
        for (String w : words) {
            trie.insert(w);
        }
        String ans = "";
        for (String w : words) {
            if ((w.length() > ans.length() || (w.length() == ans.length() && w.compareTo(ans) < 0))
                && trie.search(w)) {
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
        Solution1858 _tcSol = new Solution1858();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"k\",\"ki\",\"kir\",\"kira\", \"kiran\"]");
        try {
            String[] words = new String[]{"k", "ki", "kir", "kira", "kiran"};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestWord(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"kiran\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"a\", \"banana\", \"app\", \"appl\", \"ap\", \"apply\", \"apple\"]");
        try {
            String[] words = new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestWord(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"apple\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "words = [\"abc\", \"bc\", \"ab\", \"qwe\"]");
        try {
            String[] words = new String[]{"abc", "bc", "ab", "qwe"};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestWord(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();
    }
}