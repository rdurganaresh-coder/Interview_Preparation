package com.leetcode.dynamic_programming;

class Trie3253_2 {
    public final int inf = 1 << 29;
    public Trie3253_2[] children = new Trie3253_2[26];
    public int cost = inf;

    public void insert(String word, int cost) {
        Trie3253_2 node = this;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie3253_2();
            }
            node = node.children[idx];
        }
        node.cost = Math.min(node.cost, cost);
    }
}

class Solution3253_2 {
    public int minimumCost(String target, String[] words, int[] costs) {
        Trie3253_2 trie = new Trie3253_2();
        for (int i = 0; i < words.length; ++i) {
            trie.insert(words[i], costs[i]);
        }
        int n = target.length();
        int inf = trie.inf;
        int[] f = new int[n + 1];
        Arrays.fill(f, inf);
        f[n] = 0;
        for (int i = n - 1; i >= 0; --i) {
            Trie3253_2 node = trie;
            for (int j = i; j < n; ++j) {
                int idx = target.charAt(j) - 'a';
                if (node.children[idx] == null) {
                    break;
                }
                node = node.children[idx];
                f[i] = Math.min(f[i], node.cost + f[j + 1]);
            }
        }
        return f[0] < inf ? f[0] : -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3253_2 _tcSol = new Solution3253_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "target = \"abcdef\", words = [\"abdef\",\"abc\",\"d\",\"def\",\"ef\"], costs = [100,1,1,10,5]");
        try {
            String target = "abcdef";
            String[] words = new String[]{"abdef", "abc", "d", "def", "ef"};
            int[] costs = new int[]{100, 1, 1, 10, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(target, words, costs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "target = \"aaaa\", words = [\"z\",\"zz\",\"zzz\"], costs = [1,10,100]");
        try {
            String target = "aaaa";
            String[] words = new String[]{"z", "zz", "zzz"};
            int[] costs = new int[]{1, 10, 100};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(target, words, costs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
