package com.leetcode.strings;

class Trie0820 {
    Trie0820[] children = new Trie0820[26];
}

class Solution0820 {
    public int minimumLengthEncoding(String[] words) {
        Trie0820 root = new Trie0820();
        for (String w : words) {
            Trie0820 cur = root;
            for (int i = w.length() - 1; i >= 0; i--) {
                int idx = w.charAt(i) - 'a';
                if (cur.children[idx] == null) {
                    cur.children[idx] = new Trie0820();
                }
                cur = cur.children[idx];
            }
        }
        return dfs(root, 1);
    }

    private int dfs(Trie0820 cur, int l) {
        boolean isLeaf = true;
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (cur.children[i] != null) {
                isLeaf = false;
                ans += dfs(cur.children[i], l + 1);
            }
        }
        if (isLeaf) {
            ans += l;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0820 _tcSol = new Solution0820();
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