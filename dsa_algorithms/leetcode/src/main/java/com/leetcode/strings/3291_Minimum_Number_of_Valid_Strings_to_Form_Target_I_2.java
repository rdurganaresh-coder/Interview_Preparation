package com.leetcode.strings;

class Trie3291_2 {
    Trie3291_2[] children = new Trie3291_2[26];

    void insert(String w) {
        Trie3291_2 node = this;
        for (int i = 0; i < w.length(); ++i) {
            int j = w.charAt(i) - 'a';
            if (node.children[j] == null) {
                node.children[j] = new Trie3291_2();
            }
            node = node.children[j];
        }
    }
}

class Solution3291_2 {
    public int minValidStrings(String[] words, String target) {
        Trie3291_2 trie = new Trie3291_2();
        for (String w : words) {
            trie.insert(w);
        }
        int n = target.length();
        int inf = 1 << 30;
        int[] f = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            f[i] = inf;
        }
        char[] s = target.toCharArray();
        for (int i = n - 1; i >= 0; --i) {
            Trie3291_2 node = trie;
            for (int j = i; j < n; ++j) {
                int k = s[j] - 'a';
                if (node.children[k] == null) {
                    break;
                }
                node = node.children[k];
                f[i] = Math.min(f[i], 1 + f[j + 1]);
            }
        }
        return f[0] < inf ? f[0] : -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3291_2 _tcSol = new Solution3291_2();
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
