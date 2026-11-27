package com.leetcode.strings;

class Trie2185_2 {
    private Trie2185_2[] children = new Trie2185_2[26];
    private int cnt;

    public void insert(String w) {
        Trie2185_2 node = this;
        for (int i = 0; i < w.length(); ++i) {
            int j = w.charAt(i) - 'a';
            if (node.children[j] == null) {
                node.children[j] = new Trie2185_2();
            }
            node = node.children[j];
            ++node.cnt;
        }
    }

    public int search(String pref) {
        Trie2185_2 node = this;
        for (int i = 0; i < pref.length(); ++i) {
            int j = pref.charAt(i) - 'a';
            if (node.children[j] == null) {
                return 0;
            }
            node = node.children[j];
        }
        return node.cnt;
    }
}

class Solution2185_2 {
    public int prefixCount(String[] words, String pref) {
        Trie2185_2 tree = new Trie2185_2();
        for (String w : words) {
            tree.insert(w);
        }
        return tree.search(pref);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2185_2 _tcSol = new Solution2185_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"pay\",\"attention\",\"practice\",\"attend\"], pref = \"at\"");
        try {
            String[] words = new String[]{"pay", "attention", "practice", "attend"};
            String pref = "at";
            System.out.println("  Output  : " + _tcShow(_tcSol.prefixCount(words, pref)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"leetcode\",\"win\",\"loops\",\"success\"], pref = \"code\"");
        try {
            String[] words = new String[]{"leetcode", "win", "loops", "success"};
            String pref = "code";
            System.out.println("  Output  : " + _tcShow(_tcSol.prefixCount(words, pref)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}