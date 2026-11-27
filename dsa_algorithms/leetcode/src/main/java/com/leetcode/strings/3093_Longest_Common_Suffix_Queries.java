package com.leetcode.strings;

class Trie3093 {
    private final int inf = 1 << 30;
    private Trie3093[] children = new Trie3093[26];
    private int length = inf;
    private int idx = inf;

    public void insert(String w, int i) {
        Trie3093 node = this;
        if (node.length > w.length()) {
            node.length = w.length();
            node.idx = i;
        }
        for (int k = w.length() - 1; k >= 0; --k) {
            int idx = w.charAt(k) - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie3093();
            }
            node = node.children[idx];
            if (node.length > w.length()) {
                node.length = w.length();
                node.idx = i;
            }
        }
    }

    public int query(String w) {
        Trie3093 node = this;
        for (int k = w.length() - 1; k >= 0; --k) {
            int idx = w.charAt(k) - 'a';
            if (node.children[idx] == null) {
                break;
            }
            node = node.children[idx];
        }
        return node.idx;
    }
}

class Solution3093 {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Trie3093 trie = new Trie3093();
        for (int i = 0; i < wordsContainer.length; ++i) {
            trie.insert(wordsContainer[i], i);
        }
        int n = wordsQuery.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = trie.query(wordsQuery[i]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3093 _tcSol = new Solution3093();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "wordsContainer = [\"abcd\",\"bcd\",\"xbcd\"], wordsQuery = [\"cd\",\"bcd\",\"xyz\"]");
        try {
            String[] wordsContainer = new String[]{"abcd", "bcd", "xbcd"};
            String[] wordsQuery = new String[]{"cd", "bcd", "xyz"};
            System.out.println("  Output  : " + _tcShow(_tcSol.stringIndices(wordsContainer, wordsQuery)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "wordsContainer = [\"abcdefgh\",\"poiuygh\",\"ghghgh\"], wordsQuery = [\"gh\",\"acbfgh\",\"acbfegh\"]");
        try {
            String[] wordsContainer = new String[]{"abcdefgh", "poiuygh", "ghghgh"};
            String[] wordsQuery = new String[]{"gh", "acbfgh", "acbfegh"};
            System.out.println("  Output  : " + _tcShow(_tcSol.stringIndices(wordsContainer, wordsQuery)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,0,2]");
        System.out.println();
    }
}