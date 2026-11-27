package com.leetcode.arrays_hashing_greedy;

class Solution0792_2 {
    public int numMatchingSubseq(String s, String[] words) {
        Deque<int[]>[] d = new Deque[26];
        Arrays.setAll(d, k -> new ArrayDeque<>());
        for (int i = 0; i < words.length; ++i) {
            d[words[i].charAt(0) - 'a'].offer(new int[] {i, 0});
        }
        int ans = 0;
        for (char c : s.toCharArray()) {
            var q = d[c - 'a'];
            for (int t = q.size(); t > 0; --t) {
                var p = q.pollFirst();
                int i = p[0], j = p[1] + 1;
                if (j == words[i].length()) {
                    ++ans;
                } else {
                    d[words[i].charAt(j) - 'a'].offer(new int[] {i, j});
                }
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0792_2 _tcSol = new Solution0792_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abcde\", words = [\"a\",\"bb\",\"acd\",\"ace\"]");
        try {
            String s = "abcde";
            String[] words = new String[]{"a", "bb", "acd", "ace"};
            System.out.println("  Output  : " + _tcShow(_tcSol.numMatchingSubseq(s, words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"dsahjpjauf\", words = [\"ahjpjau\",\"ja\",\"ahbwzgqnuk\",\"tnmlanowax\"]");
        try {
            String s = "dsahjpjauf";
            String[] words = new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"};
            System.out.println("  Output  : " + _tcShow(_tcSol.numMatchingSubseq(s, words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}