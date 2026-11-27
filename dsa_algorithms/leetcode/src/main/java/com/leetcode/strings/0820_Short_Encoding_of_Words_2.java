package com.leetcode.strings;

class Trie0820_2 {
    Trie0820_2[] children = new Trie0820_2[26];

    int insert(String w) {
        Trie0820_2 node = this;
        boolean pref = true;
        for (int i = w.length() - 1; i >= 0; --i) {
            int idx = w.charAt(i) - 'a';
            if (node.children[idx] == null) {
                pref = false;
                node.children[idx] = new Trie0820_2();
            }
            node = node.children[idx];
        }
        return pref ? 0 : w.length() + 1;
    }
}

class Solution0820_2 {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        int ans = 0;
        Trie0820_2 trie = new Trie0820_2();
        for (String w : words) {
            ans += trie.insert(w);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0820_2 _tcSol = new Solution0820_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"time\", \"me\", \"bell\"]");
        try {
            String[] words = new String[]{"time", "me", "bell"};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumLengthEncoding(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"t\"]");
        try {
            String[] words = new String[]{"t"};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumLengthEncoding(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}