package com.leetcode.strings;

class Trie0616 {
    Trie0616[] children = new Trie0616[128];
    boolean isEnd;

    public void insert(String word) {
        Trie0616 node = this;
        for (char c : word.toCharArray()) {
            if (node.children[c] == null) {
                node.children[c] = new Trie0616();
            }
            node = node.children[c];
        }
        node.isEnd = true;
    }
}

class Solution0616 {
    public String addBoldTag(String s, String[] words) {
        Trie0616 trie = new Trie0616();
        for (String w : words) {
            trie.insert(w);
        }
        List<int[]> pairs = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            Trie0616 node = trie;
            for (int j = i; j < n; ++j) {
                int idx = s.charAt(j);
                if (node.children[idx] == null) {
                    break;
                }
                node = node.children[idx];
                if (node.isEnd) {
                    pairs.add(new int[] {i, j});
                }
            }
        }
        if (pairs.isEmpty()) {
            return s;
        }
        List<int[]> t = new ArrayList<>();
        int st = pairs.get(0)[0], ed = pairs.get(0)[1];
        for (int j = 1; j < pairs.size(); ++j) {
            int a = pairs.get(j)[0], b = pairs.get(j)[1];
            if (ed + 1 < a) {
                t.add(new int[] {st, ed});
                st = a;
                ed = b;
            } else {
                ed = Math.max(ed, b);
            }
        }
        t.add(new int[] {st, ed});
        int i = 0, j = 0;
        StringBuilder ans = new StringBuilder();
        while (i < n) {
            if (j == t.size()) {
                ans.append(s.substring(i));
                break;
            }
            st = t.get(j)[0];
            ed = t.get(j)[1];
            if (i < st) {
                ans.append(s.substring(i, st));
            }
            ++j;
            ans.append("<b>");
            ans.append(s.substring(st, ed + 1));
            ans.append("</b>");
            i = ed + 1;
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0616 _tcSol = new Solution0616();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abcxyz123\", words = [\"abc\",\"123\"]");
        try {
            String s = "abcxyz123";
            String[] words = new String[]{"abc", "123"};
            System.out.println("  Output  : " + _tcShow(_tcSol.addBoldTag(s, words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"<b>abc</b>xyz<b>123</b>\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aaabbb\", words = [\"aa\",\"b\"]");
        try {
            String s = "aaabbb";
            String[] words = new String[]{"aa", "b"};
            System.out.println("  Output  : " + _tcShow(_tcSol.addBoldTag(s, words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"<b>aaabbb</b>\"");
        System.out.println();
    }
}