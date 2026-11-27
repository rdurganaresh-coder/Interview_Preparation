package com.leetcode.strings;

class Trie3291 {
    Trie3291[] children = new Trie3291[26];

    void insert(String w) {
        Trie3291 node = this;
        for (int i = 0; i < w.length(); ++i) {
            int j = w.charAt(i) - 'a';
            if (node.children[j] == null) {
                node.children[j] = new Trie3291();
            }
            node = node.children[j];
        }
    }
}

class Solution3291 {
    private Integer[] f;
    private char[] s;
    private Trie3291 trie;
    private final int inf = 1 << 30;

    public int minValidStrings(String[] words, String target) {
        trie = new Trie3291();
        for (String w : words) {
            trie.insert(w);
        }
        s = target.toCharArray();
        f = new Integer[s.length];
        int ans = dfs(0);
        return ans < inf ? ans : -1;
    }

    private int dfs(int i) {
        if (i >= s.length) {
            return 0;
        }
        if (f[i] != null) {
            return f[i];
        }
        Trie3291 node = trie;
        f[i] = inf;
        for (int j = i; j < s.length; ++j) {
            int k = s[j] - 'a';
            if (node.children[k] == null) {
                break;
            }
            f[i] = Math.min(f[i], 1 + dfs(j + 1));
            node = node.children[k];
        }
        return f[i];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3291 _tcSol = new Solution3291();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"abc\",\"aaaaa\",\"bcdef\"], target = \"aabcdabc\"");
        try {
            String[] words = new String[]{"abc", "aaaaa", "bcdef"};
            String target = "aabcdabc";
            System.out.println("  Output  : " + _tcShow(_tcSol.minValidStrings(words, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"abababab\",\"ab\"], target = \"ababaababa\"");
        try {
            String[] words = new String[]{"abababab", "ab"};
            String target = "ababaababa";
            System.out.println("  Output  : " + _tcShow(_tcSol.minValidStrings(words, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "words = [\"abcdef\"], target = \"xyz\"");
        try {
            String[] words = new String[]{"abcdef"};
            String target = "xyz";
            System.out.println("  Output  : " + _tcShow(_tcSol.minValidStrings(words, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
