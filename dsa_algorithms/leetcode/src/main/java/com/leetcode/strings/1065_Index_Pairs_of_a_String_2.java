package com.leetcode.strings;

class Trie1065_2 {
    Trie1065_2[] children = new Trie1065_2[26];
    boolean isEnd = false;

    void insert(String word) {
        Trie1065_2 node = this;
        for (char c : word.toCharArray()) {
            c -= 'a';
            if (node.children[c] == null) {
                node.children[c] = new Trie1065_2();
            }
            node = node.children[c];
        }
        node.isEnd = true;
    }
}

class Solution1065_2 {
    public int[][] indexPairs(String text, String[] words) {
        Trie1065_2 trie = new Trie1065_2();
        for (String w : words) {
            trie.insert(w);
        }
        int n = text.length();
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            Trie1065_2 node = trie;
            for (int j = i; j < n; ++j) {
                int idx = text.charAt(j) - 'a';
                if (node.children[idx] == null) {
                    break;
                }
                node = node.children[idx];
                if (node.isEnd) {
                    ans.add(new int[] {i, j});
                }
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1065_2 _tcSol = new Solution1065_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "text = \"thestoryofleetcodeandme\", words = [\"story\",\"fleet\",\"leetcode\"]");
        try {
            String text = "thestoryofleetcodeandme";
            String[] words = new String[]{"story", "fleet", "leetcode"};
            System.out.println("  Output  : " + _tcShow(_tcSol.indexPairs(text, words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[3,7],[9,13],[10,17]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "text = \"ababa\", words = [\"aba\",\"ab\"]");
        try {
            String text = "ababa";
            String[] words = new String[]{"aba", "ab"};
            System.out.println("  Output  : " + _tcShow(_tcSol.indexPairs(text, words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,1],[0,2],[2,3],[2,4]]");
        System.out.println();
    }
}