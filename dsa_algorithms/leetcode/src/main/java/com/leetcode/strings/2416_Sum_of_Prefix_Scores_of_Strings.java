package com.leetcode.strings;

class Trie2416 {
    private Trie2416[] children = new Trie2416[26];
    private int cnt;

    public void insert(String w) {
        Trie2416 node = this;
        for (char c : w.toCharArray()) {
            c -= 'a';
            if (node.children[c] == null) {
                node.children[c] = new Trie2416();
            }
            node = node.children[c];
            ++node.cnt;
        }
    }

    public int search(String w) {
        Trie2416 node = this;
        int ans = 0;
        for (char c : w.toCharArray()) {
            c -= 'a';
            if (node.children[c] == null) {
                return ans;
            }
            node = node.children[c];
            ans += node.cnt;
        }
        return ans;
    }
}

class Solution2416 {
    public int[] sumPrefixScores(String[] words) {
        Trie2416 trie = new Trie2416();
        for (String w : words) {
            trie.insert(w);
        }
        int[] ans = new int[words.length];
        for (int i = 0; i < words.length; ++i) {
            ans[i] = trie.search(words[i]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2416 _tcSol = new Solution2416();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"abc\",\"ab\",\"bc\",\"b\"]");
        try {
            String[] words = new String[]{"abc", "ab", "bc", "b"};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumPrefixScores(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,4,3,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"abcd\"]");
        try {
            String[] words = new String[]{"abcd"};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumPrefixScores(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4]");
        System.out.println();
    }
}