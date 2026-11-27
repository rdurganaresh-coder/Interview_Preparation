package com.leetcode.strings;

class Trie0527 {
    private final Trie0527[] children = new Trie0527[26];
    private int cnt;

    public void insert(String w) {
        Trie0527 node = this;
        for (char c : w.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie0527();
            }
            node = node.children[idx];
            ++node.cnt;
        }
    }

    public int search(String w) {
        Trie0527 node = this;
        int ans = 0;
        for (char c : w.toCharArray()) {
            ++ans;
            int idx = c - 'a';
            node = node.children[idx];
            if (node.cnt == 1) {
                return ans;
            }
        }
        return w.length();
    }
}

class Solution0527 {
    public List<String> wordsAbbreviation(List<String> words) {
        Map<List<Integer>, Trie0527> tries = new HashMap<>();
        for (var w : words) {
            var key = List.of(w.length(), w.charAt(w.length() - 1) - 'a');
            tries.putIfAbsent(key, new Trie0527());
            tries.get(key).insert(w);
        }
        List<String> ans = new ArrayList<>();
        for (var w : words) {
            int m = w.length();
            var key = List.of(m, w.charAt(m - 1) - 'a');
            int cnt = tries.get(key).search(w);
            ans.add(cnt + 2 >= m ? w : w.substring(0, cnt) + (m - cnt - 1) + w.substring(m - 1));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution0527 _tcSol = new Solution0527();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"like\",\"god\",\"internal\",\"me\",\"internet\",\"interval\",\"intension\",\"face\",\"intrusion\"]");
        try {
            List<String> words = _tcL("like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion");
            System.out.println("  Output  : " + _tcShow(_tcSol.wordsAbbreviation(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"l2e\",\"god\",\"internal\",\"me\",\"i6t\",\"interval\",\"inte4n\",\"f2e\",\"intr4n\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"aa\",\"aaa\"]");
        try {
            List<String> words = _tcL("aa", "aaa");
            System.out.println("  Output  : " + _tcShow(_tcSol.wordsAbbreviation(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"aa\",\"aaa\"]");
        System.out.println();
    }
}