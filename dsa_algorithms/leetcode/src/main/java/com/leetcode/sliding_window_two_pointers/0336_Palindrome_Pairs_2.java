package com.leetcode.sliding_window_two_pointers;

class Trie0336_2 {
    Trie0336_2[] children = new Trie0336_2[26];
    Integer v;

    void insert(String w, int i) {
        Trie0336_2 node = this;
        for (char c : w.toCharArray()) {
            c -= 'a';
            if (node.children[c] == null) {
                node.children[c] = new Trie0336_2();
            }
            node = node.children[c];
        }
        node.v = i;
    }

    Integer search(String w, int i, int j) {
        Trie0336_2 node = this;
        for (int k = j; k >= i; --k) {
            int idx = w.charAt(k) - 'a';
            if (node.children[idx] == null) {
                return null;
            }
            node = node.children[idx];
        }
        return node.v;
    }
}

class Solution0336_2 {
    public List<List<Integer>> palindromePairs(String[] words) {
        Trie0336_2 trie = new Trie0336_2();
        int n = words.length;
        for (int i = 0; i < n; ++i) {
            trie.insert(words[i], i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String w = words[i];
            int m = w.length();
            for (int j = 0; j <= m; ++j) {
                if (isPalindrome(w, j, m - 1)) {
                    Integer k = trie.search(w, 0, j - 1);
                    if (k != null && k != i) {
                        ans.add(Arrays.asList(i, k));
                    }
                }
                if (j != 0 && isPalindrome(w, 0, j - 1)) {
                    Integer k = trie.search(w, j, m - 1);
                    if (k != null && k != i) {
                        ans.add(Arrays.asList(k, i));
                    }
                }
            }
        }
        return ans;
    }

    // TLE
    // private boolean isPalindrome(String w, int i, int j) {
    //     for (; i < j; ++i, --j) {
    //         if (w.charAt(i) != w.charAt(j)) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    private boolean isPalindrome(String w, int start, int end) {
        int i = start, j = end;
        for (; i < j; ++i, --j) {
            if (w.charAt(i) != w.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0336_2 _tcSol = new Solution0336_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"abcd\",\"dcba\",\"lls\",\"s\",\"sssll\"]");
        try {
            String[] words = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
            System.out.println("  Output  : " + _tcShow(_tcSol.palindromePairs(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,1],[1,0],[3,2],[2,4]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"bat\",\"tab\",\"cat\"]");
        try {
            String[] words = new String[]{"bat", "tab", "cat"};
            System.out.println("  Output  : " + _tcShow(_tcSol.palindromePairs(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,1],[1,0]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "words = [\"a\",\"\"]");
        try {
            String[] words = new String[]{"a", ""};
            System.out.println("  Output  : " + _tcShow(_tcSol.palindromePairs(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,1],[1,0]]");
        System.out.println();
    }
}