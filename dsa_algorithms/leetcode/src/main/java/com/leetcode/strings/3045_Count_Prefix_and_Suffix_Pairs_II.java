package com.leetcode.strings;

class Node3045 {
    Map<Integer, Node3045> children = new HashMap<>();
    int cnt;
}

class Solution3045 {
    public long countPrefixSuffixPairs(String[] words) {
        long ans = 0;
        Node3045 trie = new Node3045();
        for (String s : words) {
            Node3045 node = trie;
            int m = s.length();
            for (int i = 0; i < m; ++i) {
                int p = s.charAt(i) * 32 + s.charAt(m - i - 1);
                node.children.putIfAbsent(p, new Node3045());
                node = node.children.get(p);
                ans += node.cnt;
            }
            ++node.cnt;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3045 _tcSol = new Solution3045();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"a\",\"aba\",\"ababa\",\"aa\"]");
        try {
            String[] words = new String[]{"a", "aba", "ababa", "aa"};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPrefixSuffixPairs(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"pa\",\"papa\",\"ma\",\"mama\"]");
        try {
            String[] words = new String[]{"pa", "papa", "ma", "mama"};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPrefixSuffixPairs(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "words = [\"abab\",\"ab\"]");
        try {
            String[] words = new String[]{"abab", "ab"};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPrefixSuffixPairs(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}