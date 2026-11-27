package com.leetcode.strings;

class Node2707_2 {
    Node2707_2[] children = new Node2707_2[26];
    boolean isEnd;
}

class Solution2707_2 {
    public int minExtraChar(String s, String[] dictionary) {
        Node2707_2 root = new Node2707_2();
        for (String w : dictionary) {
            Node2707_2 node = root;
            for (int k = w.length() - 1; k >= 0; --k) {
                int i = w.charAt(k) - 'a';
                if (node.children[i] == null) {
                    node.children[i] = new Node2707_2();
                }
                node = node.children[i];
            }
            node.isEnd = true;
        }
        int n = s.length();
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            f[i] = f[i - 1] + 1;
            Node2707_2 node = root;
            for (int j = i - 1; j >= 0; --j) {
                node = node.children[s.charAt(j) - 'a'];
                if (node == null) {
                    break;
                }
                if (node.isEnd && f[j] < f[i]) {
                    f[i] = f[j];
                }
            }
        }
        return f[n];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2707_2 _tcSol = new Solution2707_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"leetscode\", dictionary = [\"leet\",\"code\",\"leetcode\"]");
        try {
            String s = "leetscode";
            String[] dictionary = new String[]{"leet", "code", "leetcode"};
            System.out.println("  Output  : " + _tcShow(_tcSol.minExtraChar(s, dictionary)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"sayhelloworld\", dictionary = [\"hello\",\"world\"]");
        try {
            String s = "sayhelloworld";
            String[] dictionary = new String[]{"hello", "world"};
            System.out.println("  Output  : " + _tcShow(_tcSol.minExtraChar(s, dictionary)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}